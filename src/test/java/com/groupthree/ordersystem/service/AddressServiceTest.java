package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Address;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.AddressVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void getAddressVo() {
        Object o=addressService.getAddressVo(1);
        System.out.println(o);
//        Assert.assertEquals(addressVo.getContact(), "张三");
    }

    @Test
    public void insertAddress() {
        AddressVo addressVo = new AddressVo();
        addressVo.setAddress("中国");
        addressVo.setContact("李四");
        addressVo.setPhoneNumber("13354268371");
        addressVo.setAddressId(111111);
        addressService.insertAddress(2, addressVo);
    }

}