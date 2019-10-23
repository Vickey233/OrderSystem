package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Commodity;
import com.groupthree.ordersystem.dao.CommodityDAO;
import com.groupthree.ordersystem.service.CommodityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.CommodityVo;
import com.groupthree.ordersystem.vo.EditCommodityVo;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class CommodityServiceImpl extends ServiceImpl<CommodityDAO, Commodity> implements CommodityService {

    public Long getId() {
        return baseMapper.getId();
    }

    public Commodity getCommodityById(Integer commodityId) {
        return baseMapper.selectById(commodityId);
    }

    public Object getCommodityPage(String commodityName, Integer pageNo, Integer pageSize) {
        log.info("获取商品列表");
        List<CommodityVo> commodityVoList = null;
        Page<CommodityVo> page = new Page<>(pageNo, pageSize);
        System.out.println(commodityName);
        commodityVoList = baseMapper.getCommodityPage(commodityName, page);
        page.setRecords(commodityVoList);
        return ResultUtil.success(page);
    }

    public Object insertOne(String commodityName, String commodityDesc, String imagePath, Double price) {
        log.info("插入商品");
        Commodity commodity=baseMapper.getByCommodityName(commodityName);
        if(commodity==null)
        {
            baseMapper.insertOne(commodityName, commodityDesc, imagePath, price);
            commodity=baseMapper.getByCommodityName(commodityName);
            return ResultUtil.success(commodity.getCommodityId());
        }
        return ResultUtil.error("商品名重复");
    }

    public Object getCommdityMsg(Integer commodityId){
        log.info("获取商品详细信息");
        return ResultUtil.success(baseMapper.getShowCommodityVo(commodityId));
    }

    public Object updateMsg(EditCommodityVo editCommodityVo) {
        log.info("更新商品信息");
        baseMapper.updateByCommodityId(editCommodityVo.getCommodityId(),
                editCommodityVo.getCommodityName(),
                editCommodityVo.getCommodityDesc(),
                editCommodityVo.getImagePath(),
                editCommodityVo.getPrice());
        return ResultUtil.success(editCommodityVo.getCommodityId());
    }

    public Object delete(Integer commodityId){
        log.info("删除商品");
        Commodity commodity=this.getCommodityById(commodityId);
        return ResultUtil.success(baseMapper.deleteById(commodity));
    }

}
