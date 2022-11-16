package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.FileDto;
import com.bilitech.api.core.dto.FileUploadRequest;
import com.bilitech.api.core.entity.File;
import com.bilitech.api.core.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
    File createEntity(FileUploadRequest fileUploadRequest);

    FileVo toVo(FileDto fileDto);

    FileDto toDto(File file);

    File toEntity(FileDto fileDto);
}
