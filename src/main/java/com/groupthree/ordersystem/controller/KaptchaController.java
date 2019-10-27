package com.groupthree.ordersystem.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
public class KaptchaController {
    /**
     * 1、验证码工具
     */
    @Autowired
    DefaultKaptcha defaultKaptcha;
    /**
     * 2、生成验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws Exception
     */
    @WebLog(description = "生成验证码")
    @RequestMapping("/defaultKaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("rightCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;}
        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @WebLog(description = "验证，验证码")
    @RequestMapping("/checkCode")
    public Object checkCode(HttpServletRequest httpServletRequest,
                                                   @RequestParam("code") String code) {
        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
        String ClientCode = code;
//        rightCode是生成码，ClientCode是表单提交码
        System.out.println("rightCode:" + rightCode + " ———— ClientCode:" + ClientCode);
        if (!rightCode.equals(ClientCode)) {
            return ResultUtil.error("验证码错误");
        } else {
            return ResultUtil.successTip("登录成功");
        }
    }
}
