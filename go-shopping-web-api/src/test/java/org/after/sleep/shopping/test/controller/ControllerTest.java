package org.after.sleep.shopping.test.controller;

import org.after.sleep.shopping.test.BaseSpringBootJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author liujianjian
 * @ date 2018/8/25 11:03
 */
public class ControllerTest extends BaseSpringBootJunitTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void query() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("userName", "lj");//传值，但要在url上配置相应的参数

        String p = "?userName={userName}";

        String body = this.restTemplate.getForObject("/test/query" + p, String.class, params);
        System.out.println(body);
    }
}
