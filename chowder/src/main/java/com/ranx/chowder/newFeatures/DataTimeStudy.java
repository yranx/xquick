package com.ranx.chowder.newFeatures;

import java.time.*;

/**
 * 新的时间
 * LocalDate - 日期函数
 * LocalTime - 时间函数
 * LocalDateTime - 日期 + 时间 函数
 * DateTimeFormatter - 日期时间格式化函数
 * @author ranx
 * @create 2018-08-30 10:22
 **/
public class DataTimeStudy {


//    public void testLocalDateTime() {
    public static void main(String args[]) {
        //获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间：" + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月：" + month + ",日：" + day + ",秒：" + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2018);
        System.out.println("date2: " + date2);

        //12 december 2018
        LocalDate date3 = LocalDate.of(2018, Month.AUGUST, 12);
        System.out.println("date3: " + date3);

        //22小时15分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        //解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);


        //获取当前时间日期
        ZonedDateTime date6 = ZonedDateTime.parse("2018-08-30T10:45:44+12:30[Asia/Shanghai]");
        System.out.println("date6:" + date6);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId:" + id);

        //获取当前时区
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当前时区：" + currentZone);
    }

}
