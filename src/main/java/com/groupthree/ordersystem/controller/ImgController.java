package com.groupthree.ordersystem.controller;

import com.groupthree.ordersystem.aop.WebLog;
import com.groupthree.ordersystem.utils.FileUtils;
import com.groupthree.ordersystem.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/image")
public class ImgController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImgController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    /**
     * 跳转到文件上传页面
     *
     * @return
     */
    @RequestMapping("index")
    public String toUpload() {
        return "index";
    }

    /**
     * @param file 要上传的文件
     * @return
     */
    @WebLog(description = "上传图片")
    @RequestMapping("/fileUpload")
    public Object upload(@RequestParam("fileName") MultipartFile file) {

        // 要上传的目标文件存放路径
//        String localPath = "E:/Develop/Files/Photos";
        String localPath = path;
        // 上传成功或者失败的提示
        String msg = "";
//        if (FileUtils.upload(file, localPath, file.getOriginalFilename())){
        if (FileUtils.upload(file, localPath, file.getOriginalFilename())) {
            // 上传成功，给出页面提示
            return ResultUtil.success("上传成功!", file.getOriginalFilename());
//            return ResultUtil.success("上传成功!", resourceLoader.getResource("file:"+path+file.getOriginalFilename()).toString());
        }
        return ResultUtil.error("上传失败！");
    }

    /**
     * 显示单张图片
     *
     * @return
     */
    @WebLog(description = "获取图片地址")
    @RequestMapping("/show")
    public Object showPhotos(String fileName) {

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
//            System.out.println(resourceLoader.getResource("file:" + path + fileName));
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
