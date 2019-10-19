package com.groupthree.ordersystem.service.impl;

import com.groupthree.ordersystem.entity.Order;
import com.groupthree.ordersystem.dao.OrderDAO;
import com.groupthree.ordersystem.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDAO, Order> implements OrderService {

}
