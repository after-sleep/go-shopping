package org.project.template.springboot.controller;

import org.junit.Test;
import org.project.template.springboot.BaseSpringBootJunitTest;
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
    public void doLogin() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("userName", "lj");//传值，但要在url上配置相应的参数

        String p = "?userName={userName}";

        String body = this.restTemplate.getForObject("/test/add" + p, String.class, params);
        System.out.println(body);
    }
}
