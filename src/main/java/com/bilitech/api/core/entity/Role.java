package com.bilitech.api.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)

public class Role extends BaseEntity {
    private String name;

    private String label;
}
