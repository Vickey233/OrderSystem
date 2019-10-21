package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.UserVo;
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
public interface AdminDAO extends BaseMapper<Admin> {

    public Long getId();


    public Admin findAdminByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
