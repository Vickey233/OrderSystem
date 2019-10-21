package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Commodity;
import com.baomidou.mybatisplus.service.IService;
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

    /**
     * 查询商品
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Object getCommodityPage(String commodityName, Integer pageNo, Integer pageSize);

    /**
     * 新增商品
     * @param commodityName
     * @param commodityDesc
     * @param imagePath
     * @param price
     * @return
     */
    public Object insertOne(String commodityName, String commodityDesc, String imagePath, Double price);

    /**
     * 修改商品
     * @param editCommodityVo
     * @return
     */
    public Object updateMsg(EditCommodityVo editCommodityVo);

    public Object delete(Integer commodityId);
}
