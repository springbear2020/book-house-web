package com.bear.bookhouse.pojo;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/21 10:48
 */
public class Page<T> {
    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页显示的数据量
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer pageTotal;
    /**
     * 总记录数
     */
    private Integer recordTotal;
    /**
     * 当前页数据
     */
    private List<T> pageData;

    public Page() {
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(Integer recordTotal) {
        this.recordTotal = recordTotal;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageTotal=" + pageTotal +
                ", recordTotal=" + recordTotal +
                ", pageData=" + pageData +
                '}';
    }
}
