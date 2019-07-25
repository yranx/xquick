package com.ranx.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ranx.model.entity.TSysUser;
import com.ranx.service.TSysUserService;
import com.ranx.utils.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ranx
 * @create 2018-10-19 14:00
 **/
@Controller
@RequestMapping("/index")
public class ExcelController {
    @Autowired
    private TSysUserService tSysUserService;

    @RequestMapping(value = "exportExcel")
    @ResponseBody
    public Object exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        EntityWrapper<TSysUser> ew = new EntityWrapper<>();
        ew.where("del_flag=0")
                .like("username", "r");
        List<TSysUser> list = tSysUserService.selectList(ew);

        //excel标题
        String[] title = {"名称","密码"};
        //excel文件名
        String fileName = "测试_信息表"+System.currentTimeMillis()+".xls";
        //sheet名
        String sheetName = "信息表";
        String[][] content = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
//            content[i] = new String[title.length];
//            System.out.println(content[i]);
//            System.out.println("**");
            TSysUser obj = list.get(i);
            content[i][0] = obj.getUsername();
            content[i][1] = obj.getPassword();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExportExcel.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    /**
     * 发送响应流方法
     * @param response
     * @param fileName
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));
//            response.addHeader("Pargam", "no-cache");
//            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
