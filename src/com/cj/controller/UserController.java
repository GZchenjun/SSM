package com.cj.controller;

import com.cj.bean.User;
import com.cj.common.EncryptUtil;
import com.cj.common.Pager4EasyUI;
import com.cj.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by interface on 2017/2/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("all")
    public List<User> userList(){
        return userService.queryAll();
    }
    @ResponseBody
    @RequestMapping("and")
    public User AndUser(){
        User user = new User();
        user.setName("junxuan");
        user.setEmail("test@126.com");
        user.setPwd(EncryptUtil.encrypt("wqeqwe"));
        userService.Add(user);
        return user;
    }
    @ResponseBody
    @RequestMapping("pager")
    public List<User> Pager(){
        Pager4EasyUI<User> pager = new Pager4EasyUI<User>();
        pager.setPageNo(1);
        pager.setPageSize(2);
        User us = new User();
//        us.setName("junxuan");
        userService.queryByPagerAndCriteria(pager,us);
        return pager.getRows();
    }
}
