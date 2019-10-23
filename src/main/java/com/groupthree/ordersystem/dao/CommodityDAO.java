package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Commodity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.CommodityVo;
import com.groupthree.ordersystem.vo.EditCommodityVo;
import com.groupthree.ordersystem.vo.ShowCommodityVo;
import org.hibernate.validator.internal.constraintvalidators.bv.time.past.PastValidatorForYear;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface CommodityDAO extends BaseMapper<Commodity> {

    public Long getId();

    public Commodity getBycommodityName(String commodityName);

    public List<CommodityVo> getCommodityPage(String commodityName, Page<CommodityVo> page);

    public ShowCommodityVo getShowCommodityVo(Integer commodityId);

    public List<ShowCommodityVo> getShowCommodityList(String commodityName, Page<ShowCommodityVo> page);

    public Integer insertOne(String commodityName, String commodityDesc, String imagePath, Double price);

    public Integer updateByCommodityId(Integer commodityId,String commodityName, String commodityDesc, String imagePath, Double price);
}
