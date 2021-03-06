package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.service.OrderService;
import com.groupthree.ordersystem.vo.TempOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import sun.rmi.runtime.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @WebLog(description = "根据用户id获取订单列表")
    @RequestMapping(value = "/userOrderList", method = RequestMethod.GET)
    public Object userOrderList(@RequestParam("userId") Integer userId) {
        return orderService.getOrderPageByUserId(userId);
    }

    @WebLog(description = "根据时间获取订单列表")
    @RequestMapping(value = "/timeOrderList", method = RequestMethod.GET)
    public Object timeOrderList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "begintime",required = false) String begintime, @RequestParam(value = "overtime",required = false) String overtime) throws ParseException {
        return orderService.getOrderPageByTime(pageNo, pageSize, begintime, overtime);
    }

    @WebLog(description = "获取订单状态")
    @RequestMapping(value = "/orderStatue", method = RequestMethod.GET)
    public Object orderStatue(@RequestParam("orderId") String orderId) {
        return orderService.getOrderStatue(orderId);
    }

    @WebLog(description = "取消订单")
    @RequestMapping(value = "/cancelList", method = RequestMethod.GET)
    public Object cancelList(@RequestParam("orderId") String orderId) {
        return orderService.cancelOrder(orderId);
    }

    @WebLog(description = "下单")
    @RequestMapping(value = "/doOrder", method = RequestMethod.PUT)
    public Object doOrder(@RequestBody TempOrderVo tempOrderVo) {
        return orderService.insertOrder(tempOrderVo);
    }

}
