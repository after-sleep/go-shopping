package org.after.sleep.shopping.service;

import org.after.sleep.shopping.common.dao.biz.BizUserBMapper;
import org.after.sleep.shopping.common.domain.UserB;
import org.after.sleep.shopping.common.domain.UserBCriteria;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ author liujianjian
 * @ date 2019/2/9 21:32
 */
@Service
public class BizUserBService extends BaseService {

    @Resource
    private BizUserBMapper bizUserBMapper;

    public UserB getUserBByUserName(String userName) {
        UserBCriteria crt = new UserBCriteria();
        crt.createCriteria().andUserNameEqualTo(userName);
        crt.limitOne();
        List<UserB> list = bizUserBMapper.selectByExample(crt);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
