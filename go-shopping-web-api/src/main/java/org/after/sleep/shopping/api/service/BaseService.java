package org.after.sleep.shopping.api.service;

import org.after.sleep.shopping.common.config.PropertyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @ author liujianjian
 * @ date 2018/8/25 11:12
 */
public class BaseService {

    protected static final Logger log = LoggerFactory.getLogger(BaseService.class);

    @Resource
    protected PropertyConfig propertyConfig;

    protected boolean isDev() {
        return propertyConfig.isDev();
    }
}
