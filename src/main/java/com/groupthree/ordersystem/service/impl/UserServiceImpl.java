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
            Base64.Decoder decoder = Base64.getDecoder();
            String depassword = new String(decoder.decode(passWord),"UTF-8");
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
            user.setPassWord(MD5Util.md5(user.getPassWord(), user.getPassWord()));
            baseMapper.insert(user);
            return ResultUtil.success("注册成功");
        }
        return ResultUtil.error("该手机号已被注册！");
    }

    public void updateUser(User user) {
        log.info("更新用户基本信息");

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
        user.setMoney(user.getMoney() + sum);
        baseMapper.updateById(user);
        return ResultUtil.successTip("冲钱成功！");
    }
}
