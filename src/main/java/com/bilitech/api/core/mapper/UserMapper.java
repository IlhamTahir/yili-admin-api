package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.UserCreateRequest;
import com.bilitech.api.core.dto.UserDto;
import com.bilitech.api.core.dto.UserUpdateRequest;
import com.bilitech.api.core.entity.Role;
import com.bilitech.api.core.entity.User;
import com.bilitech.api.core.vo.UserVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper extends MapperInterface<User, UserDto, UserVo> {

  User createEntity(UserCreateRequest userCreateRequest);

  User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
