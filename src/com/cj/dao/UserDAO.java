package com.cj.dao;

import com.cj.bean.User;
import com.cj.common.Pager4EasyUI;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by interface on 2017/2/15.
 */
@Repository
public interface UserDAO extends BaseDAO<User> {
    public List<User> queryByPagerAndCriteria(@Param("pager")Pager4EasyUI<User> pager, @Param("user")User user);

    public int countByCriteria(User user);
}
