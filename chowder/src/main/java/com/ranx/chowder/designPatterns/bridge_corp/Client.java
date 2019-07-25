package com.ranx.chowder.designPatterns.bridge_corp;

/**
 * @author ranx
 * @create 2019-06-11 19:34
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("----------房地产公司运行-------------");
        HouseCorp houseCorp = new HouseCorp();
        houseCorp.makeMoney();
        System.out.println("----------服装公司运行-------------");
        ClothesCorp clothesCorp = new ClothesCorp();
        clothesCorp.makeMoney();
    }
}
