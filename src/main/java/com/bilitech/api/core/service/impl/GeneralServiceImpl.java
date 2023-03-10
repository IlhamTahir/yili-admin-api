package com.bilitech.api.core.service.impl;

import com.bilitech.api.core.dto.BaseDto;
import com.bilitech.api.core.entity.BaseEntity;
import com.bilitech.api.core.exception.BizException;
import com.bilitech.api.core.service.GeneralService;
import com.bilitech.api.core.vo.BaseVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class GeneralServiceImpl<Entity extends BaseEntity, Dto extends BaseDto, Vo extends BaseVo> extends BaseService implements GeneralService<Entity, Dto, Vo> {

    @Override
    public Dto create(Dto dto) {
        Entity entity = getMapper().toEntity(dto);
        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public Dto get(String id) {
        return getMapper().toDto(getEntity(id));
    }

    protected Entity getEntity(String id) {
        Optional<Entity> optionalEntity = getRepository().findById(id);
        if (!optionalEntity.isPresent()) {
            throw new BizException(getNotFoundExceptionType());
        }
        return optionalEntity.get();
    }


    @Override
    @Transactional
    public Dto update(String id, Dto dto) {
        // Todo: dto 可能无法控制更新字段
        Entity existedEntity = getEntity(id);
        Entity updatedEntity = getRepository().save(getMapper().updateEntity(existedEntity, dto));
        return getMapper().toDto(updatedEntity);
    }

    @Override
    public void delete(String id) {
        Entity existedEntity = getEntity(id);
        getRepository().delete(existedEntity);
    }
}
