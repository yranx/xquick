package com.ranx.chowder.study.designPatterns.flyweight_sign_pool;

/**
 * 带对象池的报考信息
 * @author ranx
 * @create 2019-05-25 21:38
 **/
public class SignInfo4Pool extends SignInfo{
    //定义一个对象池提取的KEY值
    private String key;

    public SignInfo4Pool(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
