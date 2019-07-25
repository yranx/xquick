package com.ranx.chowder.designPatterns.strategy_marry;

/**
 * 吴国太开绿灯
 * @author ranx
 * @create 2019-04-11 9:24
 **/
public class GivenGreenLight implements IStrategy{
    @Override
    public void operate() {
        System.out.println("求吴国太开绿灯，放行！");
    }
}
