package com.ranx.chowder.designPatterns.flyweight_thread_unsafe;

import java.util.HashMap;

/**
 * 带对象池的工厂类
 * @author ranx
 * @create 2019-05-25 21:29
 **/
public class SignInfoFactory {
    //池容器
    private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();

    //从池汇总获得对象
    public static SignInfo getSignInfo(String key) {
        //设置返回对象
        SignInfo result = null;
        //池中没有 该对象,则建立，并放入池中
        if (!pool.containsKey(key)) {
            result = new SignInfo();  //修改下外部状态
            pool.put(key, result);
        } else {
            result = pool.get(key);
        }
        return result;
    }
}
