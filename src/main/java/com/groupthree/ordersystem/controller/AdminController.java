package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.service.UserService;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/userList")
    public Object userList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize)
    {
        return userService.getUserPage(pageNo,pageSize);
    }
}
