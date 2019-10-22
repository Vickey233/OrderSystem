package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.service.UserService;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @WebLog(description = "获取用户列表")
    @RequestMapping("/userList")
    public Object userList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize)
    {
        return userService.getUserPage(pageNo,pageSize);
    }

    @WebLog(description = "管理员登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Map<String, Object> map) throws Exception{
        return userService.login(request, map.get("phoneNumber").toString(),map.get("password").toString());
    }
}
