package com.groupthree.ordersystem.service.impl;

import com.groupthree.ordersystem.entity.OrderCommodity;
import com.groupthree.ordersystem.dao.OrderCommodityDAO;
import com.groupthree.ordersystem.service.OrderCommodityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.OrderComVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
@Slf4j
public class OrderCommodityServiceImpl extends ServiceImpl<OrderCommodityDAO, OrderCommodity> implements OrderCommodityService {

    public Object getOrderComVo(String orderId){
        log.info("获取订单详细菜品信息");
        List<OrderComVo> commodityVoList = null;
        commodityVoList = baseMapper.getOrderComVo(orderId);
        Iterator<OrderComVo> iter = commodityVoList.iterator();
        while (iter.hasNext()) {
            OrderComVo o = (OrderComVo) iter.next();
            o.setArriverDate(getNewDate(o.getCreateDate()));
        }
        return ResultUtil.success(commodityVoList);
    }

    public Object insertCommodityList(String orderId,Integer[] commodityList,int[] commodityCount){
        log.info("向订单中插入菜品");
        for (int i=0;i<commodityList.length;i++)
        {
//            baseMapper.insertCommodity(orderId,commodityList[i],commodityCount[i]);
            OrderCommodity orderCommodity=new OrderCommodity();
            orderCommodity.setOrderId(orderId);
            orderCommodity.setCommodityId(commodityList[i]);
            orderCommodity.setCount(commodityCount[i]);
            baseMapper.insert(orderCommodity);
        }
        return ResultUtil.successTip("成功向订单中插入菜品");
    }

    public Date getNewDate(Date cur) {
        Calendar c = Calendar.getInstance();
        c.setTime(cur);   //设置时间
        c.add(Calendar.MINUTE, 30); //日期分钟加1,Calendar.DATE(天),Calendar.HOUR(小时)
        Date date = c.getTime(); //结果
        return date;
    }
}
