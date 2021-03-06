package com.groupthree.ordersystem.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.User;
import com.groupthree.ordersystem.dao.UserDAO;
import com.groupthree.ordersystem.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.groupthree.ordersystem.utils.MD5Util;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDAO, User> implements UserService {

    public static final Base64.Decoder DECODER = Base64.getDecoder();

    public Long getId() {
        return baseMapper.getId();
    }

    public User getUserById(Integer userId) {
        return baseMapper.selectById(userId);
    }

    public Object getUserPage(Integer pageNo, Integer pageSize) {
        log.info("获取用户列表");
        List<UserVo> userVoList = null;
        Page<UserVo> page = new Page<>(pageNo, pageSize);
        userVoList = baseMapper.getUserPage(page);
        page.setRecords(userVoList);
        return ResultUtil.success(page);
    }

    public Object login(HttpServletRequest request, String phoneNumber, String passWord) throws UnsupportedEncodingException {
        log.info("用户登录");
        User user = baseMapper.findUserByPhoneNumber(phoneNumber);
        HttpSession session = request.getSession();
        if (user != null) {
            log.info("对密码进行解密");
            String depassword = new String(DECODER.decode(passWord),"UTF-8");
            System.out.println("解密后的密码是："+depassword);
            if (MD5Util.verify(depassword, depassword, user.getPassWord())) {
                log.info("向session中插入User属性");
                session.setAttribute("User", user);
                return ResultUtil.success("登录成功！", user);
            } else {
                return ResultUtil.error("密码错误");
            }
        }
        return ResultUtil.error("账号不存在");
    }

    public Object addUser(User user) throws Exception {
        log.info("注册/添加用户");
        User tmp = baseMapper.findUserByPhoneNumber(user.getPhoneNumber());
        if (tmp == null) {
            log.info("对密码进行解密");
            String depassword = new String(DECODER.decode(user.getPassWord()),"UTF-8");
            System.out.println("解密后的密码是："+depassword);
            user.setPassWord(MD5Util.md5(depassword, depassword));
            log.info("注册默认充值300元");
            user.setMoney(300.0);
            baseMapper.insert(user);
            return ResultUtil.success("注册成功");
        }
        return ResultUtil.error("该手机号已被注册！");
    }

    public Object updateUser(User user) {
        log.info("更新用户基本信息");
        User upuser=this.getUserById(user.getUserId());
        upuser.setRealName(user.getRealName());
        upuser.setPhoneNumber(user.getPhoneNumber());
//        upuser.setMoney(user.getMoney());
//        upuser.setPassWord(user.getPassWord());
        baseMapper.updateById(upuser);
        return  ResultUtil.successTip("修改用户信息成功");
    }

    public void deleteUser(Integer userId) {
        log.info("删除用户");
        User user = this.getUserById(userId);
        baseMapper.deleteById(user);
    }

    public boolean deductMoney(Integer userId, Double sum) {
        log.info("支付订单要扣钱，看看够不够");
        User user = this.getUserById(userId);
        if (user.getMoney() - sum > 0) {
            System.out.println(user.getMoney()+"   "+sum);
            user.setMoney(user.getMoney() - sum);
            baseMapper.updateById(user);
            return true;
        }
        return false;
    }

    public Object moneyBack(Integer userId, Double sum) {
        log.info("不买了，还钱");
        User user = this.getUserById(userId);
        System.out.println(user);
        if(user.getMoney()==null)
        {
            user.setMoney(sum);
        }
        else
        {
            user.setMoney(user.getMoney() + sum);
        }
        baseMapper.updateById(user);
        return ResultUtil.success("冲钱成功！",user.getMoney());
    }

    public Object updatePassWord(Integer userId, String passWord, String newPassWord) throws Exception {
        User user =this.getUserById(userId);
        log.info("对密码进行解密");
        String prePassword = new String(DECODER.decode(passWord),"UTF-8");
        System.out.println("解密后的密码是："+prePassword);
        if (MD5Util.verify(prePassword, prePassword, user.getPassWord())) {
            log.info("向session中插入User属性");
            log.info("对密码进行解密");
            String nowPassword = new String(DECODER.decode(newPassWord),"UTF-8");
            System.out.println("解密后的新密码是："+prePassword);
            user.setPassWord(MD5Util.md5(nowPassword,nowPassword));
            baseMapper.updateById(user);
            return ResultUtil.success("修改密码成功！", user);
        }else {
            return ResultUtil.error("原密码错误!");
        }
    }
}
