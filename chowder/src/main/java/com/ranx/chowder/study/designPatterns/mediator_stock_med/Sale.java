package com.ranx.chowder.study.designPatterns.mediator_stock_med;

import com.ranx.chowder.study.designPatterns.mediator_stock.Purchase;
import com.ranx.chowder.study.designPatterns.mediator_stock.Stock;

import java.util.Random;

/**
 * 销售管理
 * @author ranx
 * @create 2019-04-04 9:48
 **/
public class Sale extends AbstractColleague {
    public Sale(AbstractMediator mediator) {
        super(mediator);
    }

    //销售IBM电脑
    public void sellIBMComputer(int number) {
        super.mediator.execute("sale.sell", number);
        System.out.println("销售IBM电脑" + number + "台");
    }

    //反馈销售情况，0-100之间变化，0表示无人问津，100表示非常畅销抢手
    public int getSaleStatus() {
        Random random = new Random(System.currentTimeMillis());
        int saleStatus = random.nextInt(100);
        System.out.println("IBM电脑的销售情况为：" + saleStatus);
        return saleStatus;
    }

    //折价处理
    public void offSale() {
        super.mediator.execute("sale.offSell");
    }
}

