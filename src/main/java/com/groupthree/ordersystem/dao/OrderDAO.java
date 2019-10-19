package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.OrderVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface OrderDAO extends BaseMapper<Order> {

    public List<OrderVO> getOrderPage(Page<OrderVO> page);
}
