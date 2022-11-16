package com.bilitech.api.core.vo;

import com.bilitech.api.core.enums.Storage;
import lombok.Data;

@Data
public class SiteSettingVo {
    private String bucket;

    private String region;

    private Storage storage;
}
