package com.ranx.chowder.designPatterns.adapter_user_extend;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户工作信息
 * @author ranx
 * @create 2019-04-12 15:18
 **/
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {
    @Override
    public Map getUserOfficeInfo() {
        Map officeInfo = new HashMap();
        officeInfo.put("jobPosition", "这个人的职位是Boss...");
        officeInfo.put("officeTelNumber", "员工的办公电话是...");
        return officeInfo;
    }
}
