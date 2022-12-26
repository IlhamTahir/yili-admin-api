package com.bilitech.api.core.service;

import com.bilitech.api.core.dto.RoleCreateRequest;
import com.bilitech.api.core.dto.RoleDto;
import com.bilitech.api.core.dto.RoleSearchFilter;
import com.bilitech.api.core.dto.RoleUpdateRequest;
import com.bilitech.api.core.entity.Role;
import org.springframework.data.domain.Page;

public interface RoleService{
    Role getByName(String name);

    Page<RoleDto> search(RoleSearchFilter roleSearchFilter);

    RoleDto create(RoleCreateRequest roleCreateRequest);

    RoleDto update(String id, RoleUpdateRequest roleUpdateRequest);
}
