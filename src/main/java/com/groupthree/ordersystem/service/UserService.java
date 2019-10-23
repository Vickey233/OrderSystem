package com.groupthree.ordersystem.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.groupthree.ordersystem.vo.UserVo;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
public interface UserService extends IService<User> {

    /**
     * 主键
     *
     * @return
     */
    public Long getId();

    public User getUserById(Integer userId);

    /**
     * 查询用户  分页
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Object getUserPage(Integer pageNo, Integer pageSize);

    /**
     * 查询用户  登录
     *
     * @param phoneNumber
     * @return
     */
    public Object login(HttpServletRequest request, String phoneNumber, String passWord);


    /**
     * 查询用户  注册
     * @param user
     * @return
     */
//    public String regiest(User user) throws Exception;

    /**
     * 新增用户
     *
     * @param user
     */
    public Object addUser(User user) throws Exception;

    /**
     * 更新用户
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除用户
     *
     * @param userId
     */
    public void deleteUser(Integer userId);

    /**
     * 扣钱
     *
     * @param userId
     * @param sum
     */
    public boolean deductMoney(Integer userId, Double sum);

    /**
     * 还钱/冲钱
     *
     * @param userId
     * @param sum
     */
    public Object moneyBack(Integer userId, Double sum);
}
