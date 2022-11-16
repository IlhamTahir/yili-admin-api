package com.bilitech.api.core.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class BaseDto {
    protected String id;

    protected Date createdTime;

    protected Date updatedTime;
}
