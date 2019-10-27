package com.groupthree.ordersystem.controller;

import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.utils.FileUtils;
import com.groupthree.ordersystem.utils.ResultUtil;
import com.groupthree.ordersystem.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.net.URL;
import java.util.UUID;


@RestController
@RequestMapping("/image")
@Slf4j
public class ImgController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImgController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

//    @Value("${web.upload-path}")
    private URL path = this.getClass().getResource("/");

    /**
     * @param file 要上传的文件
     * @return
     */
    @WebLog(description = "上传图片")
    @RequestMapping("/fileUpload")
    public Object upload(@RequestParam("file") MultipartFile file) {

        log.info("要上传的目标文件存放路径");
        String localPath = path.getPath()+"images";
        System.out.println(localPath);
        log.info("上传文件");
        String filename=FileUtils.upload(file, localPath, file.getOriginalFilename());
        if (filename!="失败") {
            return ResultUtil.success("上传成功!", filename);
        }
        return ResultUtil.error("上传失败！");
    }

    /**
     * 显示单张图片
     *
     * @return
     */
    @WebLog(description = "获取图片地址")
//    @RequestMapping("/show")
    public Object showPhotos(String fileName) {

        try {
            return ResultUtil.success("URL", resourceLoader.getResource("file:" + path + fileName).toString());
        } catch (Exception e) {
            return ResultUtil.error("获取图片失败！");
        }
    }

//    /**
//     * 显示单张图片
//     * @return
//     */
//    @RequestMapping("show")
//    public ResponseEntity showPhotos(String fileName){
//
//        try {
//            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
