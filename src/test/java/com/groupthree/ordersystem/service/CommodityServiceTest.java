package com.groupthree.ordersystem.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.dao.CommodityDAO;
import com.groupthree.ordersystem.entity.Commodity;
import com.groupthree.ordersystem.vo.EditCommodityVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommodityServiceTest {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommodityDAO commodityDAO;

    @Test
    public void getCommodityById() {
        Assert.assertEquals(commodityService.getCommodityById(1).getCommodityName(), "香辣蛋包饭");
    }

    @Test
    public void getCommodityPage() {
        commodityService.getCommodityPage("", 1, 5);
    }

    @Test
    public void insertOne() {
        commodityService.insertOne("测试菜", "好吃", "", 12.5);
    }

    @Test
    public void updateMsg() {
        EditCommodityVo editCommodityVo = new EditCommodityVo();
        Commodity commodity = commodityDAO.getBycommodityName("测试菜");
        editCommodityVo.setCommodityId(commodity.getCommodityId());
        editCommodityVo.setCommodityName(commodity.getCommodityName());
        editCommodityVo.setCommodityDesc("不好吃");
        editCommodityVo.setPrice(999.0);
        commodityService.updateMsg(editCommodityVo);
    }

    @Test
    public void getCommdityMsg() {
        Commodity commodity = commodityDAO.getBycommodityName("测试菜");
        commodityService.getCommdityMsg(commodity.getCommodityId());
    }

    @Test
    public void delete() {
        Commodity commodity = commodityDAO.getBycommodityName("测试菜");
        commodityService.delete(commodity.getCommodityId());
    }
}