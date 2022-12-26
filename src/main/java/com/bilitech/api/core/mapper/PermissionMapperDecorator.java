package com.bilitech.api.core.mapper;

import com.bilitech.api.core.dto.PermissionDto;
import com.bilitech.api.core.entity.Permission;
import com.bilitech.api.core.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public abstract class PermissionMapperDecorator implements PermissionMapper{

    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public Permission nameToPermission(String name) {
        if ( name == null ) {
            return null;
        }

        Optional<Permission> result = permissionRepository.findByName(name);

        if (result.isPresent()) {
            return result.get();
        }

        Permission permission = new Permission();

        permission.setName( name );

        return permission;
    }

    public String permissionToName(PermissionDto permission) {
        return permission.getName();
    }

}
