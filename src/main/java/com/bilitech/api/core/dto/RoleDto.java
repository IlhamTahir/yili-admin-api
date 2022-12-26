package com.bilitech.api.core.dto;

import com.bilitech.api.core.entity.Permission;
import lombok.Data;

import java.util.List;

@Data
public class RoleDto extends BaseDto {
    private String name;

    private String label;

    private List<PermissionDto> permissions;
}
