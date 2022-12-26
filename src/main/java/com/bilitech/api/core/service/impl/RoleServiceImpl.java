package com.bilitech.api.core.service.impl;

import com.bilitech.api.core.dto.RoleCreateRequest;
import com.bilitech.api.core.dto.RoleDto;
import com.bilitech.api.core.dto.RoleSearchFilter;
import com.bilitech.api.core.dto.RoleUpdateRequest;
import com.bilitech.api.core.entity.Role;
import com.bilitech.api.core.exception.BizException;
import com.bilitech.api.core.exception.ExceptionType;
import com.bilitech.api.core.mapper.RoleMapper;
import com.bilitech.api.core.repository.RoleRepository;
import com.bilitech.api.core.repository.specs.AbstractSpecification;
import com.bilitech.api.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class RoleServiceImpl extends BaseService implements RoleService {

    private RoleRepository repository;

    private RoleMapper mapper;


    public Role getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public RoleDto create(RoleCreateRequest roleCreateRequest) {
        checkLabel(roleCreateRequest.getLabel());
        return mapper.toDto(repository.save(mapper.createEntity(roleCreateRequest)));
    }

    @Override
    public RoleDto update(String id, RoleUpdateRequest roleUpdateRequest) {
        Role role = getById(id);
        if (!Objects.equals(role.getName(), roleUpdateRequest.getName())) {
            checkLabel(roleUpdateRequest.getLabel());
        }
        return mapper.toDto(repository.save(mapper.updateEntity(role, roleUpdateRequest)));

    }

    private Role getById(String id) {
        Optional<Role> role = repository.findById(id);
        if (role.isEmpty()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return role.get();
    }




    private void checkLabel(String label) {
        Optional<Role> role = repository.findByLabel(label);
        if (role.isPresent()) {
            throw new BizException(ExceptionType.ROLE_LABEL_DUPLICATE);
        }
    }

    @Override
    public Page<RoleDto> search(RoleSearchFilter roleSearchFilter) {
        AbstractSpecification<Role> specs = new AbstractSpecification<Role>();
        return repository.findAll(specs, roleSearchFilter.toPageable()).map(mapper::toDto);    }

    @Autowired
    public void setRepository(RoleRepository repository) {
        this.repository = repository;
    }

    @Autowired
    public void setMapper(RoleMapper mapper) {
        this.mapper = mapper;
    }
}
