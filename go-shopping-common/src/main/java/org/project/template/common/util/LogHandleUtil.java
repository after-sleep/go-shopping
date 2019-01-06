package org.project.template.common.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.project.template.common.config.PropertyConfig;
import org.project.template.common.exception.BizException;
import org.project.template.common.response.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Map;

/**
 * @ author liujianjian
 * @ date 2018/9/3 20:35
 */
public class LogHandleUtil {

    private final static Logger log = LoggerFactory.getLogger(LogHandleUtil.class);

    public static void handleException(Exception ex, Map<String, String[]> paramMap, String userInfo, String uri, PropertyConfig propertyConfig, PrintWriter pw) {
        String msg = StringUtils.isBlank(ex.getMessage()) ? "系统异常" : ex.getMessage();
        String logMsg = getRequestLog(userInfo, uri, propertyConfig, paramMap) + ", msg: " + msg;

        if (ex instanceof BizException) {
            BizException bex = (BizException) ex;
            BaseResponse<String> br = BaseResponse.fail(bex.getCode(), msg);
            print(pw, br);
            if (bex.isNeedLog()) {
                logMsg = logMsg + ", result: " + JSON.toJSONString(br);
                log.info(logMsg);
            }
            return;
        }

        log.error(logMsg, ex);
        print(pw, BaseResponse.error(msg));
    }

    public static String getRequestLog(String userInfo, String uri, PropertyConfig propertyConfig, Map<String, String[]> paramMap) {
        if (StringUtils.isNotBlank(propertyConfig.getProjectName())) {
            uri = uri.replaceAll("/" + propertyConfig.getProjectName(), "");
        }
        return bind(StrUtil.nullToEmpty(userInfo)) + propertyConfig.getDomainHost() + uri + StrUtil.bindRequestParam(paramMap) + ", params:" + (MapUtils.isNotEmpty(paramMap) ? JSON.toJSONString(paramMap) : "");
    }

    private static void print(PrintWriter pw, BaseResponse br) {
        try {
            pw.write(JSON.toJSONString(br));
            pw.close();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private static String bind(String s) {
        if (StringUtils.isBlank(s)) return "";

        return s.endsWith(", ") ? s : s + ", ";
    }
}
