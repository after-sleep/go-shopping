package org.project.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:33
 */
@SpringBootApplication
@MapperScan("org.project.template.common.dao")
@EnableScheduling
public class SpringBootMainWar extends SpringBootServletInitializer {

    public SpringBootMainWar() {
        super();
        setRegisterErrorPageFilter(false);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootMainWar.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainWar.class, args);
    }
}
