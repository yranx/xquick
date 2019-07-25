package com.ranx.chowder.designPatterns.adapter_user;

/**
 * 场景类
 * @author ranx
 * @create 2019-04-12 9:32
 **/
public class client {
    public static void main(String[] args) {
//        IUserInfo youngGirl = new UserInfo();
        IUserInfo youngGirl = new OuterUserInfo();
        //从DB中查到101个
        for (int i=0; i<101; i++) {
            youngGirl.getMobileNumber();
        }
    }
}
