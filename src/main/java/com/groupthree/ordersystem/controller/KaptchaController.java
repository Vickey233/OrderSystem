package com.groupthree.ordersystem.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
//@RestController
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
//    @WebLog(description = "获取验证码")
//    @RequestMapping(value = "/defaultKaptcha")
//    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
//            throws Exception {
//        byte[] captchaChallengeAsJpeg = null;
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//        try {
//            // 生产验证码字符串并保存到session中
//            String createText = defaultKaptcha.createText();
//            httpServletRequest.getSession().setAttribute("rightCode", createText);
//            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
//            BufferedImage challenge = defaultKaptcha.createImage(createText);
//            ImageIO.write(challenge, "jpg", jpegOutputStream);
//        } catch (IllegalArgumentException e) {
//            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
//
//        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
//        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//        httpServletResponse.setHeader("Cache-Control", "no-store");
//        httpServletResponse.setHeader("Pragma", "no-cache");
//        httpServletResponse.setDateHeader("Expires", 0);
//        httpServletResponse.setContentType("image/jpeg");
//        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
//        responseOutputStream.write(captchaChallengeAsJpeg);
//        responseOutputStream.flush();
//        responseOutputStream.close();
//    }



    /**
     * 3、校对验证码
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
//    @WebLog(description = "验证，验证码")
//    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
//    public ModelAndView imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest,
//                                                         HttpServletResponse httpServletResponse) {
//        ModelAndView andView = new ModelAndView();
//        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
//        String tryCode = httpServletRequest.getParameter("tryCode");
//        System.out.println("rightCode:" + rightCode + " ———— tryCode:" + tryCode);
//        if (!rightCode.equals(tryCode)) {
//            andView.addObject("info", "错误的验证码");
//            andView.setViewName("index");
//        } else {
//            andView.addObject("info", "登录成功");
//            andView.setViewName("success");
//        }
//        return andView;
//    }

        @WebLog(description = "获取验证码")
    @RequestMapping(value = "/defaultKaptcha")
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
            return;
        }

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
    @RequestMapping("/imgvrifyControllerDefaultKaptcha")
    public Object imgvrifyControllerDefaultKaptcha(HttpServletRequest httpServletRequest,
                                                         HttpServletResponse httpServletResponse) {
//        ModelAndView andView = new ModelAndView();
        String rightCode = (String) httpServletRequest.getSession().getAttribute("rightCode");
        String tryCode = httpServletRequest.getParameter("tryCode");
        System.out.println("rightCode:" + rightCode + " ———— tryCode:" + tryCode);
        if (!rightCode.equals(tryCode)) {
            return ResultUtil.error("错误的验证码");
        } else {
            return ResultUtil.successTip("登录成功");
        }
    }
}