package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.service.CommodityService;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.CommodityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @WebLog(description = "获取商品列表")
    @RequestMapping(value = "/commodityList",method = RequestMethod.GET)
    public Object commodityList(@RequestParam("commodityName") String commodityName, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize)
    {
        return commodityService.getCommodityPage(commodityName,pageNo,pageSize);
    }


    @WebLog(description = "新增商品")
    @RequestMapping("/addcommodity")
    public Object addcommodity(@RequestBody CommodityVo commodityVo)
    {
        return commodityService.insertOne(commodityVo.getCommodityName(), commodityVo.getCommodityDesc(), commodityVo.getImagePath(), commodityVo.getPrice());
    }
}
