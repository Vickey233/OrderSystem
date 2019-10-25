package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Order;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface OrderDAO extends BaseMapper<Order> {

    public List<OrderVO> getOrderPage(Page<OrderVO> page);

    public List<OrderVO> getOrderPageByTime(@Param("begintime") String begintime,@Param("overtime") String overtime, Page<OrderVO> page);

    public List<OrderVO> getOrderPageByTime(@Param("begintime") Date begintime, @Param("overtime") Date overtime);
}
