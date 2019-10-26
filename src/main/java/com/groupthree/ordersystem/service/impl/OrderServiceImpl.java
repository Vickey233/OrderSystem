package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Order;
import com.groupthree.ordersystem.dao.OrderDAO;
import com.groupthree.ordersystem.entity.User;
import com.groupthree.ordersystem.service.OrderCommodityService;
import com.groupthree.ordersystem.service.OrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.service.UserService;
import com.groupthree.ordersystem.utils.MD5Util;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.OrderVO;
import com.groupthree.ordersystem.vo.TempOrderVo;
import com.groupthree.ordersystem.vo.UserOrderVo;
import com.sun.org.apache.regexp.internal.RE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderDAO, Order> implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderCommodityService commodityService;

    public Long getId() {
        return null;
    }

    public Object getOrderPage(Integer pageNo, Integer pageSize) {
        log.info("获取订单列表");
        List<OrderVO> orderVOList = null;
        Page<OrderVO> page = new Page<>(pageNo, pageSize);
        orderVOList = baseMapper.getOrderPage(page);
        page.setRecords(orderVOList);
        return ResultUtil.success(page);
    }


    public Object getOrderPageByTime(Integer pageNo, Integer pageSize, String begintime, String overtime) throws ParseException {

        log.info("字符串转date格式");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begindate =new Date();
        Date overdate =new Date();
        if (begintime == null && overtime == null){
            log.info("时间段为空，默认查全部");
            return getOrderPage(pageNo, pageSize);
        }
        else if(begintime == overtime){
            begindate = sdf.parse(begintime);
        }
        else if(begintime == null && overdate != null)
        {
            log.info("开始时间为空，默认为1949-01-01 00:00:00");
            String b_time="1949-01-01 00:00:00";
            begindate=sdf.parse(b_time);
            overdate=sdf.parse(overtime);
        }
        else if(begintime != null && overdate == null)
        {
            log.info("截止时间为空，默认为9999-12-30 00:00:00");
            begindate = sdf.parse(begintime);
            String o_time="9999-12-30 00:00:00";
            overdate = sdf.parse(o_time);
        }
        else
        {
            begindate=sdf.parse(begintime);
            overdate=sdf.parse(overtime);
        }

        System.out.println(begindate+"       "+overdate);

        log.info("根据时间获取订单列表");
        List<OrderVO> orderVOList = null;
        Page<OrderVO> page = new Page<>(pageNo, pageSize);
        orderVOList = baseMapper.getOrderPageByTime(begindate, overdate, page);
        page.setRecords(orderVOList);
        return ResultUtil.success(page);
    }

    public Object getOrderPageByUserId(Integer userId){
        List<UserOrderVo> orderVOList = null;
        orderVOList=baseMapper.getOrderByUserId(userId);
        return ResultUtil.success(orderVOList);
    }
    public Object getOrderStatue(String orderId) {
        log.info("获取订单状态");
        Order order = this.selectById(orderId);
        return ResultUtil.success(order.getStatue());
    }

    public Object cancelOrder(String orderId) {
        log.info("取消订单");
        Order order = this.selectById(orderId);
        if (order.getStatue() == "已取消")
            return ResultUtil.error("订单早就已经取消了");
        order.setStatue("已取消");
        baseMapper.updateById(order);
        log.info("还钱");
        userService.moneyBack(order.getUserId(), order.getSum());
        return ResultUtil.successTip("取消下单成功！");
    }

    public Object insertOrder(TempOrderVo tempOrderVo) {
        User user = userService.selectById(tempOrderVo.getUserId());
        log.info("验证支付密码（登录密码）");
        if (MD5Util.verify(tempOrderVo.getPassword(), tempOrderVo.getPassword(), user.getPassWord())) {
            log.info("判断余额是否足够支付订单");
            if (userService.deductMoney(user.getUserId(), tempOrderVo.getSum())) {
                log.info("创建订单");
                Order order = new Order();
                order.setOrderId(autoOrderId());
                order.setUserId(tempOrderVo.getUserId());
                order.setAddressId(tempOrderVo.getAddressId());
                order.setStatue("已下单");
                order.setSum(tempOrderVo.getSum());
                baseMapper.insert(order);
                System.out.println(order);
                log.info("订单商品表插入商品id");
                commodityService.insertCommodityList(order.getOrderId(), tempOrderVo.getCommodityList(), tempOrderVo.getCommodityCount());
                return ResultUtil.success("下单成功", user.getMoney());
            }
            return ResultUtil.error("余额不足，下单失败！");
        }
        return ResultUtil.error("密码错误，支付失败！");
    }

    public Object orderStatistics(Date begintime, Date overtime){
        return null;
    }
    /**
     * 生成订单编号  时间戳+2位整数
     *
     * @return
     */
    public String autoOrderId() {

        Random random = new Random();
        SimpleDateFormat allTime = new SimpleDateFormat("YYYYMMddHHmmSS");
        String subjectno = allTime.format(new Date()) + random.nextInt(99);
        return subjectno + random.nextInt(10);
    }
}
