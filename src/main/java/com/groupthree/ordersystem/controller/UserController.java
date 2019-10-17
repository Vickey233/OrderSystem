package com.groupthree.ordersystem.controller;

import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.common.BaseException;
import com.groupthree.ordersystem.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Slf4j
public class UserController {

    @WebLog(description = "请求了hello接口")
    @RequestMapping("/hello")
    @ResponseBody
    public String print(){
        log.info("hello!");
        throw new BaseException(ResultEnum.UNKONW_ERROR);
//        return "Hello!";
    }
}
