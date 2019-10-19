package com.groupthree.ordersystem.service.impl;

import com.groupthree.ordersystem.entity.Address;
import com.groupthree.ordersystem.dao.AddressDAO;
import com.groupthree.ordersystem.service.AddressService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
