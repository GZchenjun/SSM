package com.cj.serviceImpl;

import com.cj.bean.User;
import com.cj.common.Pager4EasyUI;
import com.cj.dao.UserDAO;
import com.cj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by interface on 2017/2/15.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDAO userDAO;
    @Override
    public List<User> queryAll() {
        List<User> users = userDAO.queryAll();
        return users;
    }

    @Override
    public void Add(User user) {
        userDAO.Add(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(Serializable id) {

    }

    @Override
    public Pager4EasyUI<User> queryByPagerAndCriteria(Pager4EasyUI<User> pager, User user) {
        List<User> users = userDAO.queryByPagerAndCriteria(pager,user);
        pager.setRows(users);
        pager.setTotal(userDAO.countByCriteria(user));
        return pager;
    }

    @Override
    public int countByCriteria(User user) {
        return userDAO.countByCriteria(user);
    }
}
