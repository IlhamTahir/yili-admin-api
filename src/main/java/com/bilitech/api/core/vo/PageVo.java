package com.bilitech.api.core.vo;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageVo<T> {
    private Paging paging;

    private List<T> data;

    public PageVo(Page<T> page) {
        Paging paging = new Paging();
        paging.setPage((long) page.getPageable().getPageNumber() + 1);
        paging.setSize((long) page.getPageable().getPageSize());
        paging.setTotal(page.getTotalElements());
        this.setPaging(paging);
        this.setData(page.getContent());
    }
}
