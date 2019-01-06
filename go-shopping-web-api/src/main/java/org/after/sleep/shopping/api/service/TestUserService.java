package org.after.sleep.shopping.api.service;

import org.after.sleep.shopping.common.dao.TestUserMapper;
import org.after.sleep.shopping.common.domain.TestUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:50
 */
@Service
public class TestUserService extends BaseService {
    @Resource
    private TestUserMapper testUserMapper;

    public int add(String userName) {
        return testUserMapper.insert(userName);
    }

    public List<TestUser> selectList() {
        return testUserMapper.select();
    }
}
