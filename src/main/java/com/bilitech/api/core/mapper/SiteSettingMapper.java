package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.SiteSettingDto;
import com.bilitech.api.core.vo.SiteSettingVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
    SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
