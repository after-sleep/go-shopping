package org.project.template.common.service;

import org.project.template.common.config.PropertyConfig;
import org.project.template.common.util.RedisClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService implements InitializingBean {

    private final static Logger log = LoggerFactory.getLogger(RedisService.class);

    private static final long CACHE_TIME_ONE_WEEK = 3600L * 24 * 7;
    private static final long CACHE_TIME_ONE_DAY = 3600L * 24;

    @Resource
    private PropertyConfig propertyConfig;

    private RedisClientUtil redisClientUtil;

    public void set(String key, String val, long time) {
        redisClientUtil.set(key, val, time);
    }

    public String get(String key) {
        return redisClientUtil.get(key);
    }

    public void del(String key) {
        redisClientUtil.del(key);
    }

    @Override
    public void afterPropertiesSet() {
        PropertyConfig.RedisConfig redis = propertyConfig.getRedis();
        if (redis == null) return;
        redisClientUtil = new RedisClientUtil(redis.getUrl(), redis.getPort(), redis.getPwd(),
                redis.isEnable());
        log.info("redis 服务初始化完成... current env: " + propertyConfig.getEnv());
    }

    private long getUserAppTokenCacheTime() {
        return propertyConfig.isProd() ? CACHE_TIME_ONE_WEEK : CACHE_TIME_ONE_DAY;
    }
}
