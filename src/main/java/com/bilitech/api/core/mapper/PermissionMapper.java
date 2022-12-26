package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.PermissionDto;
import com.bilitech.api.core.entity.Permission;
import com.bilitech.api.core.vo.PermissionVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@DecoratedWith(PermissionMapperDecorator.class)
public interface PermissionMapper extends MapperInterface<Permission, PermissionDto, PermissionVo> {
    Permission nameToPermission(String name);

    String permissionToName(PermissionDto permission);
}
