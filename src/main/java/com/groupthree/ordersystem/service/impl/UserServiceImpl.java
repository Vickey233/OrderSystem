package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.User;
import com.groupthree.ordersystem.dao.UserDAO;
import com.groupthree.ordersystem.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.MD5Util;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.UserVo;
import org.springframework.http.HttpRequest;
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
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {

    public Long getId() {
        return baseMapper.getId();
    }

    public User getUserById(Integer userId) {
        return baseMapper.selectById(userId);
    }

    public Object getUserPage(Integer pageNo, Integer pageSize) {
        List<UserVo> userVoList=null;
        Page<UserVo> page=new Page<>(pageNo,pageSize);
        userVoList=baseMapper.getUserPage(page);
        page.setRecords(userVoList);
        return ResultUtil.success(page);
    }

    public Object login(HttpServletRequest request,String phoneNumber, String passWord) {
        User user=baseMapper.findUserByPhoneNumber(phoneNumber);
//        String prepassword=password;
//        password= MD5Util.md5(password,password);
        HttpSession session=request.getSession();
        if(user!=null)
        {
            if(MD5Util.verify(passWord,passWord,user.getPassWord()))
            {
                session.setAttribute("User",user);
                return ResultUtil.success("登录成功！",user);
            }
            else{
                return ResultUtil.error("密码错误");
            }
        }
        return ResultUtil.error("账号不存在");
    }

    public Object addUser(User user) throws Exception {
        User tmp=baseMapper.findUserByPhoneNumber(user.getPhoneNumber());
        if(tmp == null)
        {
            user.setPassWord(MD5Util.md5(user.getPassWord(),user.getPassWord()));
            baseMapper.insert(user);
            return ResultUtil.success("注册成功");
        }
        return ResultUtil.error("该手机号已被注册！");
    }

    public void updateUser(User user) {

    }

    public void deleteUser(Integer userId) {
        User user=this.getUserById(userId);
        baseMapper.deleteById(user);

    }
}
