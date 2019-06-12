package com.ranx.chowder.study.designPatterns.bridge_nomal;


import com.ranx.chowder.study.designPatterns.bridge_corp.ClothesCorp;

/**
 * @author ranx
 * @create 2019-06-11 19:34
 **/
public class Client {
    public static void main(String[] args) {
        System.out.println("----------房地产公司运行-------------");
        House house = new House();
        HouseCorp houseCorp = new HouseCorp(house);
        houseCorp.makeMoney();
        System.out.println("----------服装公司运行-------------");
        ShanZhaiCorp shanZhaiCorp = new ShanZhaiCorp(new IPod());
        shanZhaiCorp.makeMoney();
    }
}
