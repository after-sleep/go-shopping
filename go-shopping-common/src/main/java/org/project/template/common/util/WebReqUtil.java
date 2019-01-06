package org.project.template.common.util;

import com.alipay.api.internal.util.WebUtils;

import java.util.Map;

/**
 * @ author liujianjian
 * @ date 2018/8/21 13:36
 */
public class WebReqUtil {

    public static String doPost(String url, Map<String, String> params) throws Exception {
        return WebUtils.doPost(url, params, "UTF-8", 10000, 30000, null, 0);
    }

    public static String doPost(String url, Map<String, String> params, int connectTimeout, int readTimeout) throws Exception {
        return WebUtils.doPost(url, params, "UTF-8", connectTimeout, readTimeout, null, 0);
    }
}
