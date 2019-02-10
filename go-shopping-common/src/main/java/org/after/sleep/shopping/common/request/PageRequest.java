package org.after.sleep.shopping.common.request;

import lombok.Data;

/**
 * @ author liujianjian
 * @ date 2019/2/10 13:16
 */
@Data
public class PageRequest {

    private int pageNo = 1;

    private int pageSize = 10;

    public void limitOne() {
        this.pageSize = 1;
    }

    public void noLimit() {
        this.pageSize = 10000;
    }
}
