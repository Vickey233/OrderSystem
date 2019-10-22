package com.groupthree.ordersystem.service.impl;

import com.groupthree.ordersystem.entity.OrderCommodity;
import com.groupthree.ordersystem.dao.OrderCommodityDAO;
import com.groupthree.ordersystem.service.OrderCommodityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.OrderComVo;
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
public class OrderCommodityServiceImpl extends ServiceImpl<OrderCommodityDAO, OrderCommodity> implements OrderCommodityService {

    public Object getOrderComVo(Integer orderId){
        List<OrderComVo> commodityVoList = null;
        commodityVoList = baseMapper.getOrderComVo(orderId);
        return ResultUtil.success(commodityVoList);
    }
}
