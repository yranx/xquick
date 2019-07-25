package com.ranx.chowder.designPatterns.observer_spy;

/**
 * 间谍
 * @author ranx
 * @create 2019-04-25 15:10
 **/
public class Spy extends Thread {
    private HanFeiZi hanFeiZi;
    private LiSi lisi;
    private String type;

    public Spy(HanFeiZi hanFeiZi, LiSi lisi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.lisi = lisi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
            if (this.type.equals("breakfast")) {
                if (this.hanFeiZi.isHavingBreakfast()) {
                    this.lisi.update("韩非子在吃饭");
                    //重置状态，继续监控
                    this.hanFeiZi.setHavingBreakfast(false);
                }
            } else {
                if (this.hanFeiZi.isHavingFun()) {
                    this.lisi.update("韩非子在娱乐");
                    this.hanFeiZi.setHavingFun(false);
                }
            }
        }
    }
}
