package org.project.template.springboot.service;

import org.project.template.common.dao.TestUserMapper;
import org.project.template.common.domain.TestUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:50
 */
@Service
public class TestUserService extends BaseService{
    @Resource
    private TestUserMapper testUserMapper;

    public int add(String userName) {
        return testUserMapper.insert(userName);
    }

    public List<TestUser> selectList() {
        return testUserMapper.select();
    }
}
