package com.ranx.chowder.designPatterns.bridge_corp_copy;

/**
 * @author ranx
 * @create 2019-06-11 19:23
 **/
public class ShanZhaiCorp extends Corp {

    public ShanZhaiCorp(Product product) {
        super(product);
    }

    @Override
    public void makeMoney() {
        super.makeMoney();
        System.out.println("公司赚钱...");

    }
}
