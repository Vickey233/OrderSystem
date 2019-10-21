package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.entity.User;
import com.groupthree.ordersystem.service.UserService;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @WebLog(description = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Map<String, Object> map, HttpServletRequest request) throws Exception{
        System.out.println(map.get("phoneNumber").toString()+"   "+map.get("password").toString());
        return userService.Login(request,map.get("phoneNumber").toString(),map.get("password").toString());
    }

    @WebLog(description = "用户注册")
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Object regist(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

}
