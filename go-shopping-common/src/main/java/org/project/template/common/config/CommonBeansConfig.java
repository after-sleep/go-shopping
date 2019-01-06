package org.project.template.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ author liujianjian
 * @ date 2018/8/25 11:11
 */
@Configuration
public class CommonBeansConfig {
    @Bean
    @ConfigurationProperties(prefix = "biz.config")
    public PropertyConfig propertyConfig() {
        return new PropertyConfig();
    }
}
