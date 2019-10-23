package com.groupthree.ordersystem.service;

import com.groupthree.ordersystem.dao.UserDAO;
import com.groupthree.ordersystem.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private HttpServletRequest request;

    @Test
    public void getUserPage() {
        userService.getUserPage(1,5);
    }

    @Test
    public void login() {
        userService.login(request,"","");
    }

    @Test
    public void addUser() throws Exception {
        User user=new User();
        user.setRealName("测试");
        user.setPassWord("123");
        user.setPhoneNumber("13546987542");
        userService.addUser(user);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
        User user =userDAO.findUserByPhoneNumber("13546987542");
        userService.deleteUser(user.getUserId());
    }
}