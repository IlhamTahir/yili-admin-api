package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.UserCreateRequest;
import com.bilitech.api.core.dto.UserDto;
import com.bilitech.api.core.dto.UserUpdateRequest;
import com.bilitech.api.core.entity.User;
import com.bilitech.api.core.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserDto toDto(User user);

  UserVo toVo(UserDto userDto);

  User createEntity(UserCreateRequest userCreateRequest);

  User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
