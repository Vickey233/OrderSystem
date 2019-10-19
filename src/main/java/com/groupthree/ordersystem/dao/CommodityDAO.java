package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Commodity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.CommodityVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface CommodityDAO extends BaseMapper<Commodity> {

    public List<CommodityVo> getCommodityPage(Page<CommodityVo> page);
}
