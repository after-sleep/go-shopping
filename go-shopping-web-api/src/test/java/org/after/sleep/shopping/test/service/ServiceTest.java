package org.after.sleep.shopping.test.service;

import org.after.sleep.shopping.service.TestUserService;
import org.after.sleep.shopping.test.BaseSpringBootJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:56
 */
public class ServiceTest extends BaseSpringBootJunitTest {

    @Resource
    private TestUserService testUserService;

    @Test
    public void add() {
        System.out.println(testUserService.add("t"));
    }

    @Test
    public void get() {
        System.out.println(testUserService.selectList());
    }
}
