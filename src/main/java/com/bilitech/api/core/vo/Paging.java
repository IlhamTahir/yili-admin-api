package com.bilitech.api.core.vo;

import lombok.Data;

@Data
public class Paging {
    private Long page;

    private Long size;

    private Long total;
}
