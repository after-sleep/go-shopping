package org.project.template.common.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:59
 */
public class BaseDomain implements Serializable {
    private Long id;
    private Date createTime;
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

}
