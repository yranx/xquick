package com.ranx.chowder.study.designPatterns.template_method_2;

/**
 * @author ranx
 * @create 2019-02-18 21:47
 **/
public class Client {
    public static void main(String[] args) {
        HummerModel h1 = new HummerH1Model();
        h1.run();
    }
}
