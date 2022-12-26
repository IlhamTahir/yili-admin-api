package com.bilitech.api.core.mapper;


import com.bilitech.api.core.entity.Role;
import com.bilitech.api.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class RoleMapperDecorator implements RoleMapper {

    @Autowired
    @Qualifier("delegate")
    private RoleMapper delegate;
    RoleService roleService;

    @Override
    public Role nameToRole(String name) {
        return roleService.getByName(name);
    }


    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
