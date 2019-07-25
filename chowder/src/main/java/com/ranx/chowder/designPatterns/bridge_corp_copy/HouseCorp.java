package com.ranx.chowder.designPatterns.bridge_corp_copy;

/**
 * @author ranx
 * @create 2019-06-11 19:23
 **/
public class HouseCorp extends Corp {

    public HouseCorp(House house) {
        super(house);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("房地产公司赚钱...");

    }
}
