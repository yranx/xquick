package com.ranx.chowder.study.designPatterns.visitor_normal;

/**
 * @author ranx
 * @create 2019-05-08 19:20
 **/
public class Client {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            //获取元素对象
            Element el = ObjectStruture.createElement();
            //接收访问者访问
            el.accept(new Visitor());
        }
    }
}
