package com.groupthree.ordersystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Autowired
    private HttpServletRequest request;

    @Test
    public void getId() {
        Assert.assertEquals(adminService.getAdminById(1).getRealName(), "大明");
    }

    @Test
    public void login() throws Exception {
        adminService.login(request, "18120732222", "a123456");
    }
}