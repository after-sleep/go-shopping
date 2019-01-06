package org.project.template.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author liujianjian
 * @ date 2018/9/11 15:25
 */
public class BaseWebConfig {

    protected HttpMessageConverters getFastJsonConverter() {
        //        QuoteFieldNames———-输出key时是否使用双引号,默认为true
//        WriteMapNullValue——–是否输出值为null的字段,默认为false
//        WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
//        WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
//        WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
//        WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
        FastJsonHttpMessageConverter fjmc = new FastJsonHttpMessageConverter();
        FastJsonConfig conf = new FastJsonConfig();
        conf.setSerializerFeatures(SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty);
        fjmc.setFastJsonConfig(conf);
        return new HttpMessageConverters(fjmc);
    }

    protected List<ContentNegotiationStrategy> getContentNegotiationList() {
        //设置响应头格式 application/json;charset=UTF-8
        List<ContentNegotiationStrategy> list = new ArrayList<>();
        list.add((webRequest) -> {
            List<MediaType> mediaTypes = new ArrayList<>();
            mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            return mediaTypes;
        });
        return list;
    }
}
