package org.project.template.springboot.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.project.template.common.config.PropertyConfig;
import org.project.template.common.response.BaseResponse;
import org.project.template.common.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ author liujianjian
 * @ date 2018/8/25 14:00
 */
public class BaseController {

    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

    @Resource
    private PropertyConfig propertyConfig;

    BaseResponse success(HttpServletRequest request) {
        return success(request, null);
    }

    <T> BaseResponse<T> success(HttpServletRequest request, T data) {
        return success(request, null, data);
    }

    <T> BaseResponse<T> success(HttpServletRequest request, String code, T data) {
        BaseResponse<T> r = StringUtils.isBlank(code) ? BaseResponse.success(data) : BaseResponse.success(code, data);
        if (propertyConfig.isNotProd()) {
            String userInfo = "";

            String requestUri = request.getRequestURI();
            if (StringUtils.isNotBlank(propertyConfig.getProjectName())) {
                requestUri = requestUri.replaceAll("/" + propertyConfig.getProjectName(), "");
            }

            log.info(userInfo + requestUri + StrUtil.bindRequestParam(request.getParameterMap()) + ", params: " + JSON.toJSONString(request.getParameterMap()) + ", result: " + JSON.toJSONString(r));
        }
        return r;
    }
}
