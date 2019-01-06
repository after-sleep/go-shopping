package org.after.sleep.shopping.common.dao;

import org.after.sleep.shopping.common.domain.TestUser;

import java.util.List;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:41
 */
public interface TestUserMapper {

    int insert(String userName);

    List<TestUser> select();
}
