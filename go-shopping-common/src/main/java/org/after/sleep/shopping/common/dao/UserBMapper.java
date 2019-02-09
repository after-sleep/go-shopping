package org.after.sleep.shopping.common.dao;

import org.after.sleep.shopping.common.domain.UserB;
import org.after.sleep.shopping.common.domain.UserBCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBMapper {
    /**
     * user_b数据表的操作方法: countByExample  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int countByExample(UserBCriteria example);

    /**
     * user_b数据表的操作方法: deleteByExample  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int deleteByExample(UserBCriteria example);

    /**
     * user_b数据表的操作方法: deleteByPrimaryKey  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int deleteByPrimaryKey(Long id);

    /**
     * user_b数据表的操作方法: insert  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int insert(UserB record);

    /**
     * user_b数据表的操作方法: insertSelective  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int insertSelective(UserB record);

    /**
     * user_b数据表的操作方法: selectByExample  
     * 创建时间 : 2019-02-09 21:12:10
     */
    List<UserB> selectByExample(UserBCriteria example);

    /**
     * user_b数据表的操作方法: selectByPrimaryKey  
     * 创建时间 : 2019-02-09 21:12:10
     */
    UserB selectByPrimaryKey(Long id);

    /**
     * user_b数据表的操作方法: updateByExampleSelective  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int updateByExampleSelective(@Param("record") UserB record, @Param("example") UserBCriteria example);

    /**
     * user_b数据表的操作方法: updateByExample  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int updateByExample(@Param("record") UserB record, @Param("example") UserBCriteria example);

    /**
     * user_b数据表的操作方法: updateByPrimaryKeySelective  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int updateByPrimaryKeySelective(UserB record);

    /**
     * user_b数据表的操作方法: updateByPrimaryKey  
     * 创建时间 : 2019-02-09 21:12:10
     */
    int updateByPrimaryKey(UserB record);
}