package com.ranx.chowder.controller;

import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author ranx
 * @create 2018-08-09 14:45
 **/
@Controller
@RequestMapping("/index")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    private final String FILEPATH =  "E:\\IdeaProjects\\file";

    @RequestMapping(value = "/upload")
    public String upload(@RequestParam("file")MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "文件为空！";
            }

            String fileName = file.getOriginalFilename();//得到的是有后缀全名称
            //获取后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String path = FILEPATH + "\\" + fileName;
            File dest = new File(path);
            File abc = dest.getParentFile();
            //通过检查父目录来为创建文件夹做准备
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdir();
            }

            //文件写入
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @PostMapping("/batch")
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i=1; i<files.size()+1; i++) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File(FILEPATH + file.getOriginalFilename())
                    ));
                    stream.write(bytes);
                    stream.close();
                } catch (IOException e) {
                    stream = null;
                    return "第" + i + "个文件上传失败==》" + e.getMessage();
                }
            } else {
                return "第" + i + "个文件上传失败,因为文件为空";
            }
        }
        return "上传成功";
    }

    @GetMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam("fileName") String fileName) {
        if(fileName != null) {
            //设置文件路径
            File file = new File(FILEPATH + "\\" + fileName);
            if (file.exists()) {
                //设置强制下载不打开
                response.setContentType("application/force-download");
                //设置文件名
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
                byte[] buffer = new byte[1024];
                FileInputStream fis  = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bis != null) {
                            bis.close();
                        }
                        if (fis != null) {
                            fis.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "下载失败";
    }
}
