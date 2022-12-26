package com.bilitech.api.core.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)

public class RoleVo extends BaseVo {
    private String id;

    private String name;

    private String label;

    private List<String> permissions;

}
