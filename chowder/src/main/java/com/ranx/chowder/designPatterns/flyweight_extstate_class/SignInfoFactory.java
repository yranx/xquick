package com.ranx.chowder.designPatterns.flyweight_extstate_class;


import java.util.HashMap;

/**
 * 带对象池的工厂类
 * @author ranx
 * @create 2019-05-25 21:29
 **/
public class SignInfoFactory {
    //池容器
    private static HashMap<ExtrinsicState, SignInfo> pool = new HashMap<ExtrinsicState, SignInfo>();
/*    //报名信息的对象工厂
    @Deprecated
    public static SignInfo() {
        return new SignInfo();
    }*/

    //从池汇总获得对象
    public static SignInfo getSignInfo(ExtrinsicState key) {
        //设置返回对象
        SignInfo result = null;
        //池中没有 该对象,则建立，并放入池中
        if (!pool.containsKey(key)) {
            result = new SignInfo();
            pool.put(key, result);
        } else {
            result = pool.get(key);
        }
        return result;
    }
}
