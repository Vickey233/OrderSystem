package com.groupthree.ordersystem.service.impl;

import com.groupthree.ordersystem.entity.OrderCommodity;
import com.groupthree.ordersystem.dao.OrderCommodityDAO;
import com.groupthree.ordersystem.service.OrderCommodityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.OrderComVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LR
 * @since 2019-10-22
 */
@Service
@Slf4j
public class OrderCommodityServiceImpl extends ServiceImpl<OrderCommodityDAO, OrderCommodity> implements OrderCommodityService {

    public Object getOrderComVo(String orderId){
        log.info("获取订单详细菜品信息");
        List<OrderComVo> commodityVoList = null;
        commodityVoList = baseMapper.getOrderComVo(orderId);
        return ResultUtil.success(commodityVoList);
    }

    public Object insertCommodityList(String orderId,Integer[] commodityList){
        log.info("向订单中插入菜品");
        for (int i=0;i<commodityList.length;i++)
        {
            baseMapper.insertCommodity(orderId,commodityList[i]);
        }
        return ResultUtil.successTip("成功向订单中插入菜品");
    }
}
