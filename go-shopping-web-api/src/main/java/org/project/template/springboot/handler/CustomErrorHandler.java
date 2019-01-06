package org.project.template.springboot.handler;

import org.project.template.common.response.BaseResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重写 spring boot 的异常处理
 */
@Controller
@RequestMapping("/common/error")
public class CustomErrorHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }

    @RequestMapping
    @ResponseBody
    public BaseResponse error(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
