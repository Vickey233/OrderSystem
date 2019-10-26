package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.OrderCommodity;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-22
 */
public interface OrderCommodityService extends IService<OrderCommodity> {


    /**
     * 查询商品详细信息
     *
     * @return
     */
    public Object getOrderComVo(String orderId,Integer userId);

    /**
     * 插入商品列表
     *
     * @return
     */
    public Object insertCommodityList(String orderId, Integer[] commodityList,int[] commodityCount);
}
