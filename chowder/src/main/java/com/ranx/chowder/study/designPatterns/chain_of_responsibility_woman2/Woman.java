package com.ranx.chowder.study.designPatterns.chain_of_responsibility_woman2;

/**
 * 古代妇女
 * @author ranx
 * @create 2019-04-08 14:15
 **/
public class Woman implements IWomen {
    /**
     * 通过一个int 类型参数描述妇女个人情况
     * 1-未婚 2.已婚 3.独居
     */
    private int type = 0;
    //请示
    private String request = "";
    //构造函数传递过来的请求

    public Woman(int type, String request) {
        this.type = type;
        switch (this.type) {
            case 1:
                this.request = "女儿的请求是：" + request;
                break;
            case 2:
                this.request = "妻子的请求是：" + request;
                break;
            case 3:
                this.request = "母亲的询问是：" + request;
                break;
        }
    }

    //获得自己的状况
    @Override
    public int getType() {
        return this.type;
    }

    //获得妇女的请求
    @Override
    public String getRequest() {
        return this.request;
    }
}
