package org.project.template.common.domain;


public class BaseCriteria {

    protected String orderByClause;

    private int start;
    private int pageNo = 1;

    private int limit;

    protected boolean distinct;

    public void noLimit() {
        this.limit = 10000;
    }

    public void limitOne() {
        this.start = 0;
        this.pageNo = 1;
        this.limit = 1;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start > 0 ? start : (getPageNo() - 1) * limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit > 10000 ? 10000 : limit;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public int getPageNo() {
        return pageNo > 0 ? pageNo : 1;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
