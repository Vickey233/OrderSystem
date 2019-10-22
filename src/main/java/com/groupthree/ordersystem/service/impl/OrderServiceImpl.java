package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Order;
import com.groupthree.ordersystem.dao.OrderDAO;
import com.groupthree.ordersystem.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.OrderVO;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public Object getOrderPage(Integer pageNo, Integer pageSize) {
        List<OrderVO> orderVOList=null;
        Page<OrderVO> page=new Page<>(pageNo,pageSize);
        orderVOList=baseMapper.getOrderPage(page);
        page.setRecords(orderVOList);
        return ResultUtil.success(page);
    }

    public Object getOrderPageByTime(String begintime, String overtime){
        List<OrderVO> orderVOList=null;
        Page<OrderVO> page=new Page<>(1,5);
        orderVOList=baseMapper.getOrderPageByTime(begintime,overtime);
        page.setRecords(orderVOList);
        return ResultUtil.success(page);
    }
}
