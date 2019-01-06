package org.project.template.common.util;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtil {

    //单位为元的转成分
    public static int yuanStrToFen(String yuan) {
        if (StringUtils.isBlank(yuan)) return 0;
        String pre, suffix = "";

        String[] arr = yuan.trim().split("\\.");
        pre = arr[0];
        if (arr.length > 1) {
            suffix = arr[1];
        }
        return Integer.parseInt(pre + suffix);
    }

    //单位分的金额转成字符串单位元
    public static String fenToYuanStr(int amount) {
        String s = "" + amount;
        String pre, suffix;
        if (s.length() >= 3) {
            pre = s.substring(0, s.length() - 2);
            suffix = s.substring(s.length() - 2);
        } else {
            pre = "0";
            suffix = s.length() < 2 ? "0" + s : s;
        }
        return pre + "." + suffix;
    }

    public static String bindRequestParam(Map<String, String[]> params) {
        String pp = "";
        if (MapUtils.isNotEmpty(params)) {
            StringBuilder p = new StringBuilder();
            params.forEach((k, v) -> p.append("&").append(k).append("=").append(v[0]));
            pp = "?" + p.replace(0, 1, "").toString();
        }
        return pp;
    }

    public static String maskPayAccount(String account) {
        if (StringUtils.isBlank(account)) return "";

        return account.substring(0, 3) + "****" + account.substring(account.length() - 4);
    }

    //138****0101
    public static String maskMobileNo(String mobileNo) {
        if (StringUtils.isBlank(mobileNo)) return "";
        return mobileNo.substring(0, 3) + "****" + mobileNo.substring(mobileNo.length() - 4);
    }

    public static String maskRealName(String name) {
        if (StringUtils.isBlank(name)) return "";

        return name.substring(0, 1) + "**";
    }

    public static String substring(String str, int length) {
        if (StringUtils.isBlank(str)) return "";
        if (str.length() <= length) return str;

        return str.substring(0, length);
    }

    public static String urlDecodeStr(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String urlDecodeJsonArrStr(String jsonArrStr) {
        if (StringUtils.isBlank(jsonArrStr) || jsonArrStr.startsWith("[")) return jsonArrStr;

        int i = 0;
        while (!jsonArrStr.startsWith("[") && i < 10) {
            try {
                jsonArrStr = URLDecoder.decode(jsonArrStr, "UTF-8");
                i++;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return jsonArrStr;
    }

    public static Set<Long> strToLongs(String str) {
        return strToLongs(str, ",");
    }

    private static Set<Long> strToLongs(String str, String reg) {
        if (StringUtils.isBlank(str)) return null;
        if (StringUtils.isBlank(reg)) reg = ",";
        String[] arr = str.split(reg);
        Set<Long> set = new HashSet<>();
        for (String s : arr) {
            if (StringUtils.isBlank(s)) continue;
            set.add(Long.parseLong(s.trim()));
        }
        return set;
    }

    public static String nullToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static boolean noNull(Object... objs) {
        for (Object o : objs) {
            if (o == null) return false;
        }
        return true;
    }

    public static boolean noEmptyStr(String... str) {
        for (String s : str) {
            if (StringUtils.isBlank(s)) return false;
        }
        return true;
    }

    //去掉双引号
    static String removeQuotes(String val) {
        return StringUtils.isNotBlank(val) ? val.replaceAll("\"", "") : "";
    }

    //是否是手机号
    public static boolean isNotMobileNo(String value) {
        return !isMobileNo(value);
    }

    private static boolean isMobileNo(String value) {
        if (StringUtils.isBlank(value)) return false;
        String regExp = "^1(3|4|5|7|8)\\d{9}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(value);
        return m.find();
    }

}
