package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.FileUploadDto;
import com.bilitech.api.core.vo.FileUploadVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
    FileUploadVo toVo(FileUploadDto fileUploadDto);
}
