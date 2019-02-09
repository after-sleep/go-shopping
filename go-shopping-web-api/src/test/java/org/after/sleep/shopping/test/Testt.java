package org.after.sleep.shopping.test;

import org.after.sleep.shopping.common.util.EncoderUtil;
import org.junit.Test;

/**
 * @ author liujianjian
 * @ date 2019/2/1 15:36
 */
public class Testt {

    @Test
    public void md5() throws Exception {
        System.out.println(EncoderUtil.md5("20190101").length());
    }
}
