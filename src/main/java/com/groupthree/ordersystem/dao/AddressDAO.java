package com.groupthree.ordersystem.dao;

import com.groupthree.ordersystem.entity.Address;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.AddressVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface AddressDAO extends BaseMapper<Address> {

    /**
     * 主键
     *
     * @return
     */
    public Long getId();

    public List<AddressVo> getAddressVo(@Param("userId") Integer userId);

}
