package com.example.demo.entity;

import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;


public class PageResponse<T> {
    private final List<T> list;
    private final int page;
    private final int pageSize;
    private final int totalPage;

    public PageResponse(List<T> data, int pageSize, int page){
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = (int)Math.ceil(BigDecimal.valueOf(data.size()).divide(BigDecimal.valueOf(pageSize)).doubleValue());
        this.list = data.subList((page -1) * pageSize, Math.min(page * pageSize, data.size()));
    }

    public PageResponse(Page<T> page){
        this.list = page.getContent();
        //page类的number是从0开始计数的
        this.page = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.totalPage = page.getTotalPages();
    }

    public static <T> PageResponse<T> of(List<T> data, int pageSize, int page){
        return new PageResponse<>(data, pageSize, page);
    }

    public List<T> getList() {
        return list;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
