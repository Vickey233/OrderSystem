package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.service.OrderCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LR
 * @since 2019-10-22
 */
@RestController
@RequestMapping("/orderCommodity")
public class OrderCommodityController {

    @Autowired
    private OrderCommodityService orderCommodityService;

    @WebLog(description = "获取商品详细列表")
    @RequestMapping(value = "/commodityList",method = RequestMethod.GET)
    public Object commodityList(@RequestParam("orderId") String orderId)
    {
        return orderCommodityService.getOrderComVo(orderId);
    }
}
