package org.project.template.common.util;

/**
 * @ author liujianjian
 * @ date 2018/9/17 21:43
 */
public class RandomUtil {

    public static String genRandomStr(int len) {
        //字符源，可以根据需要删减
        String generateSource = "23456789ABCDEFGHGKLMNPQRSTUVWXYZ";//去掉1和i ，0和o
        StringBuilder rtnStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            //循环随机获得当次字符，并移走选出的字符
            String nowStr = String.valueOf(generateSource.charAt((int) Math.floor(Math.random() * generateSource.length())));
            rtnStr.append(nowStr);
            generateSource = generateSource.replaceAll(nowStr, "");
        }
        return rtnStr.toString();
    }
}
