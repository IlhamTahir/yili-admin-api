package com.bilitech.api.core.repository;

import com.bilitech.api.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
    Role getByName(String name);

    Optional<Role> findByLabel(String label);
}
