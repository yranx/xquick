package com.ranx.chowder.designPatterns.adapter_user;

/**
 * 员工信息接口
 * @author ranx
 * @create 2019-04-11 18:32
 **/
public interface IUserInfo {
    //获得用户姓名
    public String getUserName();

    //获得家庭地址
    public String getHomeAddress();

    public String getMobileNumber();
    //办公电话
    public String getOfficeTelNumber();
    //职位
    public String getJobPosition();
    //家庭电话
    public String getHomeTelNumber();
}
