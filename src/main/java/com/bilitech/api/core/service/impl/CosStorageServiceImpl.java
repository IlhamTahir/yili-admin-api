package com.bilitech.api.core.service.impl;

import com.bilitech.api.core.dto.FileUploadDto;
import com.bilitech.api.core.exception.BizException;
import com.bilitech.api.core.exception.ExceptionType;
import com.bilitech.api.core.service.StorageService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import com.tencent.cloud.CosStsClient;
import com.tencent.cloud.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service("COS")
public class CosStorageServiceImpl implements StorageService {

    @Value("${cos.bucket}")
    private String bucket;

    @Value("${cos.secret-id}")
    private String secretId;

    @Value("${cos.secret-key}")
    private String secretKey;

    @Value("${cos.region}")
    private String region;

    @Override
    public FileUploadDto initFileUpload() {
        try {
            Response response = CosStsClient.getCredential(getCosStsConfig());
            FileUploadDto fileUploadDto = new FileUploadDto();
            fileUploadDto.setSecretId(response.credentials.tmpSecretId);
            fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
            fileUploadDto.setSessionToken(response.credentials.sessionToken);
            fileUploadDto.setStartTime(response.startTime);
            fileUploadDto.setExpiredTime(response.expiredTime);
            return fileUploadDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(ExceptionType.INNER_ERROR);
        }
    }

    @Override
    public String getFileUri(String fileKey) {
        COSClient cosClient = createCOSClient();
        Date expirationDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> headers = new HashMap<String, String>();
        HttpMethodName method = HttpMethodName.GET;
        URL url = cosClient.generatePresignedUrl(bucket, fileKey, expirationDate, method, headers, params);
        cosClient.shutdown();
        return url.toString();
    }

    private TreeMap<String, Object> getCosStsConfig() {
        TreeMap<String, Object> config = new TreeMap<String, Object>();
        config.put("secretId", secretId);
        config.put("secretKey", secretKey);

        // ???????????????????????????????????????
        config.put("durationSeconds", 1800);
        config.put("allowPrefixes", new String[]{
                "*"
        });
        config.put("bucket", bucket);
        config.put("region", region);
        String[] allowActions = new String[]{
                // ????????????
                "name/cos:PutObject",
                "name/cos:PostObject",
                // ????????????
                "name/cos:InitiateMultipartUpload",
                "name/cos:ListMultipartUploads",
                "name/cos:ListParts",
                "name/cos:UploadPart",
                "name/cos:CompleteMultipartUpload"
        };
        config.put("allowActions", allowActions);
        return config;
    }


    // Todo: ??????client????????????
    COSClient createCOSClient() {
        // ???????????????????????????????????????????????????
        // ??????????????????????????? https://cloud.tencent.com/document/product/436/14048#cos-sts-sdk

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

        // ClientConfig ???????????????????????? COS ?????????????????????
        ClientConfig clientConfig = new ClientConfig();

        // ?????? bucket ?????????
        // COS_REGION ????????? https://cloud.tencent.com/document/product/436/6224
        clientConfig.setRegion(new Region(region));

        // ??????????????????, http ?????? https
        // 5.6.53 ??????????????????????????????????????? https ??????
        // 5.6.54 ????????????????????????????????? https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // ?????????????????????????????????

        // ?????? socket ????????????????????? 30s
        clientConfig.setSocketTimeout(30 * 1000);
        // ????????????????????????????????? 30s
        clientConfig.setConnectionTimeout(30 * 1000);

        return new COSClient(cred, clientConfig);
    }
}

