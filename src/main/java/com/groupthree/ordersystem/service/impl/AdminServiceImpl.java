package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Admin;
import com.groupthree.ordersystem.dao.AdminDAO;
import com.groupthree.ordersystem.service.AdminService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.vo.UserVo;
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
public class AdminServiceImpl extends ServiceImpl<AdminDAO, Admin> implements AdminService {

}
