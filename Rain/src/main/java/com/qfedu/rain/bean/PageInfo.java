package com.qfedu.rain.bean;

import java.util.List;

public class PageInfo<T>{
    private int pageNo;
    private int pageSum;
    private int pageSize;
    private List<T> list;//页面的数据

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageSum=" + pageSum +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
