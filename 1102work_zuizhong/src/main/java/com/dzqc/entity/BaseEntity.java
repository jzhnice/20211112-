package com.dzqc.entity;

import java.io.Serializable;

/**Serializable 可序列化接口
 * 分页信息
 * */

public class BaseEntity implements Serializable {

    public Integer page;

    public Integer pageSize;

    public Integer beginCount;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeginCount() {
        return (page-1)+pageSize;
    }



    public BaseEntity() {
    }

    public BaseEntity(Integer page, Integer pageSize, Integer beginCount) {
        this.page = page;
        this.pageSize = pageSize;
        this.beginCount = beginCount;
    }
}
