package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.entity.Admin;
import com.baomidou.mybatisplus.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface AdminService extends IService<Admin> {

    /**
     * 主键
     * @return
     */
    public Long getId();

    /**
     * 查询管理员  登录
     * @param phoneNumber
     * @return
     */
    public Object login(HttpServletRequest request, String phoneNumber, String password) throws Exception;
}
