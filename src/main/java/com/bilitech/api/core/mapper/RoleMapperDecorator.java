package com.bilitech.api.core.mapper;


import com.bilitech.api.core.entity.Role;
import com.bilitech.api.core.repository.RoleRepository;
import com.bilitech.api.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class RoleMapperDecorator implements RoleMapper {

    @Autowired
    @Qualifier("delegate")
    private RoleMapper delegate;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role nameToRole(String name) {
        return roleRepository.getByName(name);
    }


}
