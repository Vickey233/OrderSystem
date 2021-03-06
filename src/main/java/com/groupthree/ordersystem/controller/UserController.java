package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.dao.UserDAO;
import com.groupthree.ordersystem.entity.User;
import com.groupthree.ordersystem.service.UserService;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </
 *
 * @author LR
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @WebLog(description = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Map<String, Object> map) throws UnsupportedEncodingException {
        return userService.login(request, map.get("phoneNumber").toString(), map.get("passWord").toString());

    }

    @WebLog(description = "用户注册")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Object regist(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @WebLog(description = "获取用户信息")
    @RequestMapping(value = "/userMsg", method = RequestMethod.GET)
    public Object userMsg(@RequestParam("userId") Integer userId){
        return ResultUtil.success(userService.getUserById(userId));
    }

    @WebLog(description = "冲钱")
    @RequestMapping(value = "/addMoney", method = RequestMethod.POST)
    public Object addMoney(@RequestParam("userId") Integer userId, @RequestParam("sum") Double sum) {
        return userService.moneyBack(userId, sum);
    }

    @WebLog(description = "更新用户信息")
    @RequestMapping(value = "/updateMsg", method = RequestMethod.POST)
    public Object updateMsg(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @WebLog(description = "修改用户密码")
    @RequestMapping(value = "/updatePassWord", method = RequestMethod.POST)
    public Object updatePassWord(@RequestParam("userId") Integer userId,@RequestParam("passWord") String passWord,@RequestParam("newPassWord") String newPassWord) throws Exception {
        return userService.updatePassWord(userId,passWord,newPassWord);
    }
}
