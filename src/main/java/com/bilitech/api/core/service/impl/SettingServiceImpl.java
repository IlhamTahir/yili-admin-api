package com.bilitech.api.core.service.impl;

import com.bilitech.api.core.dto.SiteSettingDto;
import com.bilitech.api.core.service.FileService;
import com.bilitech.api.core.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    @Value("${cos.bucket}")
    private String bucket;


    @Value("${cos.region}")
    private String region;


    private FileService fileService;


    @Override
    public SiteSettingDto getSiteSetting() {
        SiteSettingDto siteSettingDto = new SiteSettingDto();
        siteSettingDto.setBucket(bucket);
        siteSettingDto.setRegion(region);
        siteSettingDto.setStorage(fileService.getDefaultStorage());
        return siteSettingDto;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }
}
