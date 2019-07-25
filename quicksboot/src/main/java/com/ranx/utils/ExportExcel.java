package com.ranx.utils;

import org.apache.poi.hssf.usermodel.*;

/**
 * 导出Excel
 * @author ranx
 * @create 2018-10-19 13:42
 **/
public class ExportExcel {

    /**
     *
     * Jakarta POI HSSF API组件:
     HSSF（用于操作Excel的组件）提供给用户使用的对象在rg.apache.poi.hssf.usermodel包中,主要部分包括Excel对象，样式和格式，
     有以下几种常用的对象：
     常用组件：
     HSSFWorkbook     excel的文档对象
     HSSFSheet            excel的表单
     HSSFRow               excel的行
     HSSFCell                excel的格子单元
     HSSFFont               excel字体
     样式：
     HSSFCellStyle         cell样式

     * @param sheetName
     * @param title
     * @param values
     * @param wb
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {
        //s1:创建一个HSSFWorkbook,对应一个Excel文件
        if (wb == null) {
            wb = new HSSFWorkbook();
        }
        //s2:在workbook中添加一个sheet,对应Excel中sheet
        HSSFSheet sheet = wb.createSheet(sheetName);
        //设置列宽（第几列，大小）
        sheet.setColumnWidth(1,15 * 256); // 1 * 256 = 0.58 7像素
        //s3:在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        //s4:创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFCell cell = null; //声明列对象

        //创建标题
        for (int i=0; i<title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }

        //创建内容
        if (values  == null || "".equals(values)) {
            return wb;
        }
        for (int i=0; i<values.length; i++) {
            row = sheet.createRow(i + 1);
            for (int j=0; j<values[i].length; j++) {
                //将内容按顺序付给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }

        return wb;
    }
}
