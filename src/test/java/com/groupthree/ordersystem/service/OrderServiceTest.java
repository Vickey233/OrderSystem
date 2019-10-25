package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.User;
import com.groupthree.ordersystem.vo.TempOrderVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Test
    public void getOrderPage() {
        orderService.getOrderPage(1, 5);
    }

    @Test
    public void getOrderStatue() {
        orderService.getOrderStatue("201910240115710345");
    }

    @Test
    public void cancelOrder() {
        orderService.cancelOrder("201910240115710345");
    }

    @Test
    public void getOrderPageByTime() {
        orderService.getOrderPageByTime(1,5,"", "");
    }

    @Test
    public void insertOrder() {
        TempOrderVo tempOrderVo = new TempOrderVo();
        User user = userService.selectById(1);
        Integer[] commodityList = {1, 2, 3};
        int[] commodityCount = {1, 2, 3};
        tempOrderVo.setUserId(user.getUserId());
        tempOrderVo.setAddressId(1);
        tempOrderVo.setSum(52.1);
        tempOrderVo.setPassword(user.getPassWord());
        tempOrderVo.setCommodityList(commodityList);
        tempOrderVo.setCommodityCount(commodityCount);
        orderService.insertOrder(tempOrderVo);
    }
}