package com.bilitech.api.core.service;

import com.bilitech.api.core.dto.BaseDto;
import com.bilitech.api.core.entity.BaseEntity;
import com.bilitech.api.core.exception.ExceptionType;
import com.bilitech.api.core.mapper.MapperInterface;
import com.bilitech.api.core.vo.BaseVo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto, Vo extends BaseVo> {
    JpaRepository<Entity, String> getRepository();

    MapperInterface<Entity, Dto, Vo> getMapper();

    ExceptionType getNotFoundExceptionType();

    Dto create(Dto dto);

    Dto get(String id);

    Dto update(String id, Dto dto);

    void delete(String id);
}
