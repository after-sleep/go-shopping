package org.project.template.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClientUtil {

    private String url;
    private Integer port;
    private String pwd;
    private JedisPool pool;
    private boolean enable;

    public RedisClientUtil(String url, Integer port, String pwd, boolean enable) {
        this.url = url;
        this.port = port;
        this.pwd = pwd;
        this.enable = enable;

        JedisPoolConfig config = new JedisPoolConfig();
//最大空闲连接数, 应用自己评估，不要超过ApsaraDB for Redis每个实例最大的连接数
        config.setMaxIdle(200);
//最大连接数, 应用自己评估，不要超过ApsaraDB for Redis每个实例最大的连接数
        config.setMaxTotal(10000);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        pool = new JedisPool(config, url, port, 3000, pwd);
    }

    public String get(String key) {
        if (noUse()) return null;

        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis != null ? jedis.get(key) : null;
        } finally {
            closeJedis(jedis);
        }
    }

    public String set(String key, String value, long timeout) {
        if (noUse()) return "";

        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis == null) return "";

            boolean keyExist = jedis.exists(key);
            // NX是不存在时才set， XX是存在时才set， EX是秒，PX是毫秒
            if (keyExist) {
                jedis.del(key);
            }
            return jedis.set(key, value, "NX", "EX", timeout);
        } finally {
            closeJedis(jedis);
        }
    }

    public void del(String key) {
        if (noUse()) return;

        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis == null) return;

            jedis.del(key);
        } finally {
            closeJedis(jedis);
        }
    }

    private Jedis getJedis() {
        if (noUse()) return null;

        if (pool == null) return null;
        return pool.getResource();
    }

    private void closeJedis(Jedis jedis) {
        if (jedis == null) return;

        jedis.close();
    }

    private boolean noUse() {
        return !enable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public JedisPool getPool() {
        return pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
