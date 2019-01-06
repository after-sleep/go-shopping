package org.project.template.common.dao;

import org.project.template.common.domain.TestUser;

import java.util.List;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:41
 */
public interface TestUserMapper {

    int insert(String userName);

    List<TestUser> select();
}
