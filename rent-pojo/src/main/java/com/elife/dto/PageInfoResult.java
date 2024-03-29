package com.elife.dto;

import java.util.List;

/**
 *
 * @author:yy
 */
public class PageInfoResult<T> {

    /**
     * 总数据条数
     */
    private long totalSize;
    /**
     * 当前页数
     */
    private int currPage = 1;
    /**
     * 每页显示多少条数据 ，默认6条
     */
    private int pageSize = 6;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * 当前页的数据
     */

    private List<T> dataList;
   /* 一共多少页*/
    private int pages;
    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
