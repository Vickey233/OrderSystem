package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Address;
import com.baomidou.mybatisplus.service.IService;
import com.groupthree.ordersystem.vo.AddressVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface AddressService extends IService<Address> {

    /**
     * 获取地址列表
     *
     * @param userId
     * @return
     */
    public Object getAddressVo(Integer userId);

    public Address getAddressById(Integer addressId);

    /**
     * 插入地址
     * @param userId
     * @param addressVo
     * @return
     */
    public Object insertAddress(Integer userId, AddressVo addressVo);
}
