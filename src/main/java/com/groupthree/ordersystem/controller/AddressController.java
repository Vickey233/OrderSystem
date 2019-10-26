package com.groupthree.ordersystem.controller;


import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.service.AddressService;
import com.groupthree.ordersystem.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @WebLog(description = "获取地址列表")
    @RequestMapping(value = "/addressList", method = RequestMethod.GET)
    public Object addressList(@RequestParam("userId") Integer userId) {
        return addressService.getAddressVo(userId);
    }

    @WebLog(description = "新增地址")
    @RequestMapping(value = "/addAddress", method = RequestMethod.PUT)
    public Object addressList(@RequestParam("userId") Integer userId, @RequestBody AddressVo addressVo) {
        return addressService.insertAddress(userId,addressVo);
    }
}
