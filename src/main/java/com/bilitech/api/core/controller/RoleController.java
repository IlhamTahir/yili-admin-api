package com.bilitech.api.core.controller;

import com.bilitech.api.core.dto.RoleCreateRequest;
import com.bilitech.api.core.dto.RoleSearchFilter;
import com.bilitech.api.core.dto.RoleUpdateRequest;
import com.bilitech.api.core.mapper.RoleMapper;
import com.bilitech.api.core.service.RoleService;
import com.bilitech.api.core.vo.PageVo;
import com.bilitech.api.core.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    RoleService roleService;

    RoleMapper roleMapper;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('user:roles')")
    public PageVo<RoleVo> search(@Validated RoleSearchFilter roleSearchFilter) {
        return new PageVo<>(roleService.search(roleSearchFilter).map(roleMapper::toVo));
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('user:roles:create')")
    RoleVo create(@Validated @RequestBody RoleCreateRequest roleCreateRequest) {
        return roleMapper.toVo(roleService.create(roleCreateRequest));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasPermission('user:roles:edit')")
    RoleVo update(@PathVariable String id, @Validated @RequestBody RoleUpdateRequest roleUpdateRequest) {
        return roleMapper.toVo(roleService.update(id, roleUpdateRequest));
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }
}
