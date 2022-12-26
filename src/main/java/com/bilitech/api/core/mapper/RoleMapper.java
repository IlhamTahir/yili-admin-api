package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.RoleCreateRequest;
import com.bilitech.api.core.dto.RoleDto;
import com.bilitech.api.core.dto.RoleUpdateRequest;
import com.bilitech.api.core.entity.Role;
import com.bilitech.api.core.vo.RoleVo;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PermissionMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@DecoratedWith(RoleMapperDecorator.class)
public interface RoleMapper extends MapperInterface<Role, RoleDto, RoleVo> {
    Role nameToRole(String name);

    Role createEntity(RoleCreateRequest roleCreateRequest);
    Role updateEntity(@MappingTarget Role role, RoleUpdateRequest roleUpdateRequest);
}
