package org.project.template.common.util;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class EncoderUtil {

    public static String toBase64(String str) throws Exception {
        if(StringUtils.isBlank(str)) return "";

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encodeBuffer(str.getBytes());
    }

    public static String md5(String key) throws Exception {
        if (key == null || key.trim().equals("")) return "";

        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        byte[] btInput = key.getBytes();
        // 获得MD5摘要算法的 MessageDigest 对象
        MessageDigest mdInst = MessageDigest.getInstance("MD5");
        // 使用指定的字节更新摘要
        mdInst.update(btInput);
        // 获得密文
        byte[] md = mdInst.digest();
        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }
}
