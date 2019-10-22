package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Commodity;
import com.groupthree.ordersystem.dao.CommodityDAO;
import com.groupthree.ordersystem.service.CommodityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.CommodityVo;
import com.groupthree.ordersystem.vo.EditCommodityVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityDAO, Commodity> implements CommodityService {

    public Long getId() {
        return baseMapper.getId();
    }

    public Commodity getCommodityById(Integer commodityId) {
        return baseMapper.selectById(commodityId);
    }

    public Object getCommodityPage(String commodityName, Integer pageNo, Integer pageSize) {
        List<CommodityVo> commodityVoList = null;
        Page<CommodityVo> page = new Page<>(pageNo, pageSize);
        commodityVoList = baseMapper.getCommodityPage(commodityName, page);
        page.setRecords(commodityVoList);
        return ResultUtil.success(page);
    }

    public Object insertOne(String commodityName, String commodityDesc, String imagePath, Double price) {
        baseMapper.insertOne(commodityName, commodityDesc, imagePath, price);
        Commodity commodity=baseMapper.getBycommodityName(commodityName);
        return ResultUtil.success(commodity.getCommodityId());
    }

    public Object updateMsg(EditCommodityVo editCommodityVo) {
        baseMapper.updateByCommodityId(editCommodityVo.getCommodityId(),
                editCommodityVo.getCommodityName(),
                editCommodityVo.getCommodityDesc(),
                editCommodityVo.getImagePath(),
                editCommodityVo.getPrice());
        return ResultUtil.success(editCommodityVo.getCommodityId());
    }

    public Object delete(Integer commodityId){
        Commodity commodity=this.getCommodityById(commodityId);
        return ResultUtil.success(baseMapper.deleteById(commodity));
    }

}
