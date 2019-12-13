package com.tarena.entity;

import java.util.List;

public class PageBean<T> {
    private int pageSize;//每页显示的条目数
    private int pageCode;//当前页
    private int totalCount;//总条目数
    private int totalPage;//总页数
    private List<T> listBean;//存放当前页数据

    //计算总页数
    public int getTotalPage() {
        totalPage = totalCount / pageSize;
        if (totalCount % pageSize != 0) {
            return totalPage + 1;
        }
        return totalPage;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getListBean() {
        return listBean;
    }

    public void setListBean(List<T> listBean) {
        this.listBean = listBean;
    }

}
