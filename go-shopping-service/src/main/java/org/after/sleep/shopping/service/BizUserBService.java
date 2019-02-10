package org.after.sleep.shopping.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.after.sleep.shopping.common.dao.biz.BizUserBMapper;
import org.after.sleep.shopping.common.domain.UserB;
import org.after.sleep.shopping.common.domain.UserBCriteria;
import org.after.sleep.shopping.common.request.GetUserBListRequest;
import org.after.sleep.shopping.common.vo.PageList;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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

    public PageList<UserB> queryUserBList(GetUserBListRequest req) {

        Page<UserB> page = PageHelper.startPage(req.getPageNo(), req.getPageSize());

        UserBCriteria crt = new UserBCriteria();
        if (StringUtils.isNotBlank(req.getUserName()))
            crt.createCriteria().andUserNameEqualTo(req.getUserName());

        List<UserB> list = bizUserBMapper.selectByExample(crt);
        return PageList.newInstance(page.getTotal(), list, req.getPageNo());
    }

    public UserB getUserBByUserName(String userName) {
        GetUserBListRequest req = new GetUserBListRequest();
        req.setUserName(userName);
        req.limitOne();
        PageList<UserB> pl = queryUserBList(req);
        return CollectionUtils.isEmpty(pl.getList()) ? null : pl.getList().get(0);
    }

    public void addUserB(UserB r) {
        bizUserBMapper.insertSelective(r);
    }
}
