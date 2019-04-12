package com.ranx.chowder.study.designPatterns.adapter_user;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranx
 * @create 2019-04-11 18:48
 **/
public class OuterUser implements IOuterUser {
    //用户的基本信息
    @Override
    public Map getUserbaseInfo() {
        Map baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "这个员工叫水手.....");
        baseInfoMap.put("mobileNumber", "这个员工的电话是....");
        return baseInfoMap;
    }

    //员工的工作信息
    @Override
    public Map getUserOfficeInfo() {
        Map officeInfo = new HashMap();
        officeInfo.put("jobPosition", "这个人的职位是Boss...");
        officeInfo.put("officeTelNumber", "员工的办公电话是...");
        return officeInfo;
    }

    //员工的家庭信息
    @Override
    public Map getUserHomeInfo() {
        Map homeInfo = new HashMap();
        homeInfo.put("homeTelNumber", "员工的家庭电话是....");
        homeInfo.put("homeAddress", "员工的家庭地址是...");
        return homeInfo;
    }
}
