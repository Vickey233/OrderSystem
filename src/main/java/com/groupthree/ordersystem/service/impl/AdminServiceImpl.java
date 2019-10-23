package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.Admin;
import com.groupthree.ordersystem.dao.AdminDAO;
import com.groupthree.ordersystem.service.AdminService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.MD5Util;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
@Slf4j

public class AdminServiceImpl extends ServiceImpl<AdminDAO, Admin> implements AdminService {

    public Long getId() {
        return baseMapper.getId();
    }

    public Admin getAdminById(Integer adminId) {
        return baseMapper.selectById(adminId);
    }

    public Object login(HttpServletRequest request, String phoneNumber, String passWord) throws Exception {
        log.info("管理员登录");
        Admin admin=baseMapper.findAdminByPhoneNumber(phoneNumber);
//        String prepassword=password;
//        password= MD5Util.md5(password,password);
        HttpSession session=request.getSession();
        if(admin != null)
        {
            if(MD5Util.verify(passWord,passWord,admin.getPassWord()))
            {
                log.info("向session中插入Admin属性");
                session.setAttribute("Admin", admin);
                return ResultUtil.success("登录成功!", admin);
            }
            else{
                return ResultUtil.error("密码错误");
            }
        }
        return ResultUtil.error("账号不存在");
    }
}
