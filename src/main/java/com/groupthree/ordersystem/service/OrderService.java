package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Order;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface OrderService extends IService<Order> {

    /**
     * 主键
     * @return
     */
    public Long getId();

    /**
     * 查询用户  分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Object getOrderPage(Integer pageNo, Integer pageSize);

}
