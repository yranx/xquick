package com.ranx.chowder.cusannotation;

/**
 * @author ranx
 * @create 2019-06-09 19:59
 **/
public class AnnoOut {
    @CusAnnotation(hello = "Hello, ShangHai", world = "Hello, World")
    public void output() {
        System.out.println("method output id running");
    }
}
