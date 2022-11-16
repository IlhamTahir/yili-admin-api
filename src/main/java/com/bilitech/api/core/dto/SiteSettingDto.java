package com.bilitech.api.core.dto;

import com.bilitech.api.core.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingDto {
    private String bucket;

    private String region;

    private Storage storage;
}
