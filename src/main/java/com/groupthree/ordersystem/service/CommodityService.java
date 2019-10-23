package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Commodity;
import com.baomidou.mybatisplus.service.IService;
import com.groupthree.ordersystem.vo.CommodityVo;
import com.groupthree.ordersystem.vo.EditCommodityVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface CommodityService extends IService<Commodity> {

    /**
     * 主键
     * @return
     */
    public Long getId();

    public Commodity getCommodityById(Integer commodityId);

    /**
     * 查询商品
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Object getCommodityPage(String commodityName, Integer pageNo, Integer pageSize);

    /**
     * 新增商品
     * @param commodityVo
     * @return
     */
    public Object insertOne(CommodityVo commodityVo);

    /**
     * 修改商品
     * @param editCommodityVo
     * @return
     */
    public Object updateMsg(EditCommodityVo editCommodityVo);

    public Object getCommdityMsg(Integer commodityId);

    public Object delete(Integer commodityId);
}
