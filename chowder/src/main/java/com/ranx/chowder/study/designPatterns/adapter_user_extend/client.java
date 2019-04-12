package com.ranx.chowder.study.designPatterns.adapter_user_extend;

/**
 * @author ranx
 * @create 2019-04-12 15:40
 **/
public class client {
    public static void main(String[] args) {
        //外系统的人员信息
        IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
        IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
        //传递三个对象
        IUserInfo youngGirl = new OuterUserInfo(baseInfo, homeInfo, officeInfo);
        for (int i=0; i<101; i++) {
            youngGirl.getMobileNumber();
        }
    }
}
