package com.groupthree.ordersystem.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.groupthree.ordersystem.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.groupthree.ordersystem.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LR
 * @since 2019-10-18
 */
@Repository
public interface UserDAO extends BaseMapper<User> {

    /**
     * 主键
     *
     * @return
     */
    public Long getId();

    public List<UserVo> getUserPage(Page<UserVo> page);

    public User findUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
