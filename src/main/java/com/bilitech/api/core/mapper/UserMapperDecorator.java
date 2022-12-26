package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.UserDto;
import com.bilitech.api.core.vo.RoleVo;
import com.bilitech.api.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public abstract class UserMapperDecorator implements UserMapper{
    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;



    @Override
    public UserVo toVo(UserDto userDto) {
        UserVo userVo = delegate.toVo(userDto);
        buildPermissions(userVo);
        return userVo;
    }


    private static void buildPermissions(UserVo userVo) {
        List<String> permissions = new ArrayList<>();
        List<RoleVo> roles = userVo.getRoles();
        if (roles != null) {
            for (RoleVo role : roles) {
                permissions.addAll(role.getPermissions());
            }
        }
        userVo.setPermissions(permissions);
    }
}
