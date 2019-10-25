package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Order;
import com.baomidou.mybatisplus.service.IService;
import com.groupthree.ordersystem.vo.TempOrderVo;

import java.util.Date;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface OrderService extends IService<Order> {

    /**
     * 主键
     *
     * @return
     */
//    public Long getId();

    /**
     * 查询订单  分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Object getOrderPage(Integer pageNo, Integer pageSize);

    /**
     * 获取订单状态
     *
     * @param orderId
     * @return
     */
    public Object getOrderStatue(String orderId);

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    public Object cancelOrder(String orderId);

    /**
     * 按时间查询订单  分页
     *
     * @param begintime
     * @param overtime
     * @return
     */
    public Object getOrderPageByTime(Integer pageNo, Integer pageSize,String begintime, String overtime);

    public Object getOrderPageByTime(Integer pageNo, Integer pageSize, Date begintime, Date overtime);

    public Object insertOrder(TempOrderVo tempOrderVo);

}
