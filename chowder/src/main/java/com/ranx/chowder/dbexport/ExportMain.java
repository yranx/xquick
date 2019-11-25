package com.ranx.chowder.dbexport;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedList;

/** 导出数据库中表信息到Excel
 * @author ranx
 * @create 2018-05-19 13:37
 **/
public class ExportMain {


    public static final String url = "jdbc:mysql://localhost:3306/ranzh";//MYSQL数据库JDBC链接地址
    public static final String name = "com.mysql.jdbc.Driver";//MYSQL连接驱动
    public static final String user = "root";//数据库账号
    public static final String password = "root";//数据库密码

    public static final String dbname="ranzh";//数据库DB名

    public static final String outputpath="F:\\logs\\dataChange\\dbExchange.xls";//Excel输出地址

    public static Connection conn = null;

    public static void main(String[] args) throws Exception{
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接

            LinkedList<dbStruct> dbStructLinkedList=new LinkedList<dbStruct>();

            PreparedStatement selectTablesPs=conn.prepareStatement(
                    "select table_name,table_comment from information_schema.tables where table_schema=? and TABLE_TYPE=?"
            );
            selectTablesPs.setString(1,dbname);
            selectTablesPs.setString(2,"BASE TABLE");
            ResultSet tableRs=selectTablesPs.executeQuery();

            //数据库中的表名 （可以改为手动输入）
            String[] tables={
                    "cityweather",
                    "py_user",
                    "sys_user",
                    "t_sys_user"
            };
            //遍历表名
            while(tableRs.next()){
                String tablename=tableRs.getString(1);
                if(Arrays.binarySearch(tables,tablename)>=0){
                    String tablecomment=tableRs.getString(2);

                    //查询表结构
                    String sql="select COLUMN_NAME,DATA_TYPE,COLUMN_TYPE,COLUMN_COMMENT from information_schema.columns\n" +
                            "where table_schema = ? " +
                            "and table_name = ? ";

                    PreparedStatement ps2=conn.prepareStatement(
                            sql
                    );
                    ps2.setString(1,dbname);
                    ps2.setString(2,tablename);

                    dbStruct dbStruct=new dbStruct();
                    dbStruct.tablename=tablename;
                    dbStruct.tablecomment=tablecomment;

                    ResultSet rs2=ps2.executeQuery();

                    LinkedList<tableStruct> tableStructLinkedList=new LinkedList<tableStruct>();

                    //查询列讯息
                    while(rs2.next()){
                        tableStruct ts=new tableStruct();
                        ts.columnname=rs2.getString(1);
                        ts.type=rs2.getString(2);
                        ts.length=rs2.getString(3);

                        int t=ts.length.indexOf("(");
                        if(t>0){
                            ts.length=ts.length.substring(t+1);
                            t=ts.length.indexOf(")");
                            ts.length=ts.length.substring(0,t);
                        }
                        else{
                            ts.length="";
                        }

                        ts.comment=rs2.getString(4);

                        tableStructLinkedList.add(ts);
                    }

                    dbStruct.tableStructList=tableStructLinkedList;

                    dbStructLinkedList.add(dbStruct);
                }

            }


//创建HSSFWorkbook对象
            HSSFWorkbook wb = new HSSFWorkbook();
//创建HSSFSheet对象
            HSSFSheet sheet = wb.createSheet("sheet0");

//居中样式（带有边框）
            HSSFCellStyle centerCellStyle = wb.createCellStyle();  //新建单元格样式
            centerCellStyle.setAlignment(HorizontalAlignment.CENTER); // 居中
            centerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            centerCellStyle.setBorderBottom(BorderStyle.THIN); //下边框
            centerCellStyle.setBorderLeft(BorderStyle.THIN);//左边框
            centerCellStyle.setBorderTop(BorderStyle.THIN);//上边框
            centerCellStyle.setBorderRight(BorderStyle.THIN);//右边框


            //创建首行
            HSSFRow firstRow = sheet.createRow(0);


            HSSFCell firstRowCell2=firstRow.createCell(0);
            firstRowCell2.setCellValue("Table");
            firstRowCell2.setCellStyle(centerCellStyle);

            HSSFCell firstRowCell3=firstRow.createCell(1);
            firstRowCell3.setCellValue("Column");
            firstRowCell3.setCellStyle(centerCellStyle);

            HSSFCell firstRowCell4=firstRow.createCell(2);
            firstRowCell4.setCellValue("Type");
            firstRowCell4.setCellStyle(centerCellStyle);

            HSSFCell firstRowCell5=firstRow.createCell(3);
            firstRowCell5.setCellValue("Length");
            firstRowCell5.setCellStyle(centerCellStyle);

            HSSFCell firstRowCell6=firstRow.createCell(4);
            firstRowCell6.setCellValue("Comment");
            firstRowCell6.setCellStyle(centerCellStyle);

            int nowrow=1;
            for(int i=0;i<dbStructLinkedList.size();i++){

                int cellStartRow=0;

                for(int j=0;j<dbStructLinkedList.get(i).tableStructList.size();j++){
                    dbStruct d=dbStructLinkedList.get(i);

                    //创建HSSFRow对象
                    HSSFRow row = sheet.createRow(nowrow);
                    if(j==0){

                        //创建HSSFCell对象
                        HSSFCell cell=row.createCell(0);
                        cell.setCellValue(d.tablename+"("+d.tablecomment+")");
                        cell.setCellStyle(centerCellStyle);


                        cellStartRow=nowrow;
                    }

                    HSSFCell cell1=row.createCell(1);
                    cell1.setCellValue(d.tableStructList.get(j).columnname);
                    cell1.setCellStyle(centerCellStyle);
                    HSSFCell cell2=row.createCell(2);
                    cell2.setCellValue(d.tableStructList.get(j).type);
                    cell2.setCellStyle(centerCellStyle);
                    HSSFCell cell3=row.createCell(3);
                    cell3.setCellValue(d.tableStructList.get(j).length);
                    cell3.setCellStyle(centerCellStyle);
                    HSSFCell cell4=row.createCell(4);
                    cell4.setCellValue(d.tableStructList.get(j).comment);
                    cell4.setCellStyle(centerCellStyle);
                    nowrow++;

                }

                if(nowrow-1!=cellStartRow){
                    CellRangeAddress region1 = new CellRangeAddress(
                            cellStartRow,
                            nowrow-1,
                            0,
                            0); //参数1：起始行 参数2：终止行 参数3：起始列 参数4：终止列
                    sheet.addMergedRegion(region1);
                }
            }


//输出Excel文件
            FileOutputStream output=new FileOutputStream(outputpath);
            wb.write(output);
            output.flush();



        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(conn!=null){
                conn.close();
            }
        }
    }


}
