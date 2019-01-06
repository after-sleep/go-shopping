package org.after.sleep.shooping.web.api.handler;

import org.after.sleep.shopping.common.config.PropertyConfig;
import org.after.sleep.shopping.common.constant.WebConstant;
import org.after.sleep.shopping.common.util.LogHandleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class ExceptionHandler implements HandlerExceptionResolver {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @Resource
    private PropertyConfig propertyConfig;

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type", "application/json;charset=UTF-8");

        LogHandleUtil.handleException(ex, request.getParameterMap(), getUserInfo(request), request.getRequestURI(), propertyConfig, getWriter(response));
        return null;
    }

    private PrintWriter getWriter(HttpServletResponse response) {
        try {
            return response.getWriter();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    private String getUserInfo(HttpServletRequest request) {
        Object obj = request.getAttribute(WebConstant.USER_REQUEST_ATTRIBUTE_KEY);
        if (obj == null) return "";

        return "";
    }

}
