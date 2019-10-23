package com.groupthree.ordersystem.service.impl;

import com.groupthree.ordersystem.entity.Address;
import com.groupthree.ordersystem.dao.AddressDAO;
import com.groupthree.ordersystem.service.AddressService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.AddressVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressDAO, Address> implements AddressService {

    public Long getId() {
        return baseMapper.getId();
    }

    public Address getAddressById(Integer addressId) {
        return baseMapper.selectById(addressId);
    }

    public Object getAddressVo(Integer userId){
        List<AddressVo> addressVoList = null;
        addressVoList = baseMapper.getAddressVo(userId);
        return ResultUtil.success(addressVoList);
    }

    public Object insertAddress(Integer userId,AddressVo addressVo){
        Address address=new Address();
        address.setUserId(userId);
        address.setAddress(addressVo.getAddress());
        address.setContact(addressVo.getContact());
        address.setPhoneNumber(addressVo.getPhoneNumber());
        baseMapper.insert(address);
        return  ResultUtil.success(address);
    }
}
