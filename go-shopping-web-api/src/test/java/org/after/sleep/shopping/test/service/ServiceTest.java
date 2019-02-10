package org.after.sleep.shopping.test.service;

import org.after.sleep.shopping.common.domain.UserB;
import org.after.sleep.shopping.common.request.GetUserBListRequest;
import org.after.sleep.shopping.service.BizUserBService;
import org.after.sleep.shopping.test.BaseSpringBootJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @ author liujianjian
 * @ date 2018/8/25 10:56
 */
public class ServiceTest extends BaseSpringBootJunitTest {

    @Resource
    private BizUserBService bizUserBService;

    @Test
    public void test() {
//        UserB u = new UserB();
//        u.setUserName("tt");
//        bizUserBService.addUserB(u);
//        UserB t = bizUserBService.getUserBByUserName("t");
//        System.out.println(t);

        GetUserBListRequest req = new GetUserBListRequest();
        req.setPageNo(2);
        req.setPageSize(1);
        System.out.println(bizUserBService.queryUserBList(req));
    }
}
