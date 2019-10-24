package com.groupthree.ordersystem.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderCommodityServiceTest {


    @Autowired
    private OrderCommodityService orderCommodityService;

    @Test
    public void getOrderComVo() {
        orderCommodityService.getOrderComVo("201910240115710345");
    }

    @Test
    public void insertCommodityList() {
        Integer[] commodityList = {1, 2, 3};
        int[] commodityCount = {1, 2, 3};
        orderCommodityService.insertCommodityList("201910240115710345", commodityList,commodityCount);
    }
}