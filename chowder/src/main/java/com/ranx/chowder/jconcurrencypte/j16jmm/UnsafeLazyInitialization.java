package com.ranx.chowder.jconcurrencypte.j16jmm;

import javax.annotation.Resource;

/**
 * 不安全的延迟初始化--不要这么做
 * @author ranx
 * @create 2019-07-11 19:43
 **/
//@NotThreadSafe
public class UnsafeLazyInitialization {
    private static Resource resource;

//    public static Resource geInstance() {}
}
