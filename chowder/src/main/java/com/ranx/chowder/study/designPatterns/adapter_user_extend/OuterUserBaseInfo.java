package com.ranx.chowder.study.designPatterns.adapter_user_extend;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ranx
 * @create 2019-04-12 15:15
 **/
public class OuterUserBaseInfo implements IOuterUserBaseInfo{
    @Override
    public Map getUserBaseInfo() {
        Map baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "这个员工叫水手.....");
        baseInfoMap.put("mobileNumber", "这个员工的电话是....");
        return baseInfoMap;
    }
}
