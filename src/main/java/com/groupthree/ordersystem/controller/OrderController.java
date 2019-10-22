package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @WebLog(description = "获取订单列表")
    @RequestMapping("/orderList")
    public Object orderList(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize)
    {
        return orderService.getOrderPage(pageNo,pageSize);
    }

    @WebLog(description = "获取订单列表")
    @RequestMapping("/timeOrderList")
    public Object timeOrderList(@RequestParam("begintime") String begintime, @RequestParam("overtime") String overtime)
    {
        return orderService.getOrderPageByTime(begintime,overtime);
    }

}
