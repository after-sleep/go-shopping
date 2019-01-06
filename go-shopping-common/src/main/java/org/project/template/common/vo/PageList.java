package org.project.template.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Author: liujianjian
 * DateTime: 16/12/14 下午10:00.
 * </pre>
 */
@Data
public class PageList<T> implements Serializable {

    private long total;

    private List<T> list;
    private int pageNo = 1;


    public PageList() {
    }

    public PageList(long total, List<T> rows) {
        this.total = total;
        this.list = rows;
    }

    public PageList(long total, List<T> rows, int pageNo) {
        this.total = total;
        this.list = rows;
        this.pageNo = pageNo;
    }

    public static <T> PageList<T> newInstance() {
        return new PageList<>();
    }

    public static <T> PageList<T> newInstance(long total, List<T> rows, int pageNo) {
        return new PageList<>(total, rows, pageNo);
    }


    public List<T> getList() {
        return list == null ? new ArrayList<>() : list;
    }
}
