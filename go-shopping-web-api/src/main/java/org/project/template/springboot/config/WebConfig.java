package org.project.template.springboot.config;

import org.project.template.common.config.BaseWebConfig;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig extends BaseWebConfig implements WebMvcConfigurer {

    //拦截器设置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration ir2 = registry.addInterceptor(urlParamDecodeInterceptor);
//        ir2.addPathPatterns("/**").excludePathPatterns("/friendlyT/error/**");
//
//        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor);
//        ir.addPathPatterns("/friendlyT/**").excludePathPatterns("/friendlyT/error/**").excludePathPatterns("/friendlyT/common/**");
    }

    //跨域设置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    //使用fast json转换
    @Bean
    public HttpMessageConverters customConverters() {
        return getFastJsonConverter();
    }

    //Content Types
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        //设置响应头格式 application/json;charset=UTF-8
        configurer.strategies(getContentNegotiationList());
    }

}
