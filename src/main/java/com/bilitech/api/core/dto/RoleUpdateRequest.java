package com.bilitech.api.core.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class RoleUpdateRequest {
    @NotBlank(message = "角色名称不能为空")
    private String label;

    @NotBlank(message = "角色标识不能为空")
    private String name;

    private List<String> permissions;
}
