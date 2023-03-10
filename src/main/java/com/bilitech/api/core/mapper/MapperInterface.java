package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.BaseDto;
import com.bilitech.api.core.entity.BaseEntity;
import com.bilitech.api.core.vo.BaseVo;
import org.mapstruct.MappingTarget;

public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto, Vo extends BaseVo> {
    Dto toDto(Entity entity);

    Entity toEntity(Dto dto);

    Vo toVo(Dto dto);

    Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}
