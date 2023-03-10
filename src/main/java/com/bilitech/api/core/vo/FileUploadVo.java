package com.bilitech.api.core.vo;

import lombok.Data;

@Data
public class FileUploadVo {
    private String secretId;

    private String secretKey;

    private String sessionToken;

    private String key;

    private String fileId;
    

    private Long startTime;

    private Long expiredTime;
}
