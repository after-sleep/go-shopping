package org.after.sleep.shopping.web.api.controller;

import org.after.sleep.shopping.service.TestUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:51
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private TestUserService testUserService;

    @RequestMapping("/add")
    public Object add(String userName) {
        return testUserService.add(userName);
    }

    @RequestMapping("/query")
    public Object query() {
        return testUserService.selectList();
    }
}
