package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.OrderCommodity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.OrderComVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-22
 */
public interface OrderCommodityDAO extends BaseMapper<OrderCommodity> {

    public List<OrderComVo> getOrderComVo(@Param("orderId") String orderId);

//    public Object insertCommodity(String orderId, Integer commodityId,Integer count);
}
