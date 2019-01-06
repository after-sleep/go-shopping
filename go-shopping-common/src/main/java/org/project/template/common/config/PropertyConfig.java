package org.project.template.common.config;


import lombok.Data;

/**
 * 一些项目相关的属性配置
 */
public class PropertyConfig {

    private String env; //运行环境的配置，dev-本地开发，test-测试环境，production-线上
    private String domainHost;
    private String projectName;
    private RedisConfig redis;
    private OssConfig oss;

    public boolean isDev() {
        return "dev".equals(env);
    }

    public boolean isTest() {
        return "test".equals(env);
    }

    public boolean isProd() {
        return "production".equals(env);
    }

    public boolean isNotProd() {
        return !isProd();
    }

    @Data
    public static class OssConfig {
        private String endpoint;
        private String accessKeyId;
        private String secretAccessKey;
        private String bucketName;
    }

    @Data
    public static class RedisConfig {
        private boolean enable;
        private String url;
        private String pwd;
        private Integer port;
    }

    public RedisConfig getRedis() {
        return redis;
    }

    public void setRedis(RedisConfig redis) {
        this.redis = redis;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public OssConfig getOss() {
        return oss;
    }

    public void setOss(OssConfig oss) {
        this.oss = oss;
    }

    public String getDomainHost() {
        return domainHost;
    }

    public void setDomainHost(String domainHost) {
        this.domainHost = domainHost;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
