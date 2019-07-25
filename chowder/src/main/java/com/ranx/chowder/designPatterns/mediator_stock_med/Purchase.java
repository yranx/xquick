package com.ranx.chowder.designPatterns.mediator_stock_med;

/**
 * @author ranx
 * @create 2019-04-04 10:57
 **/
public class Purchase extends AbstractColleague {
    public Purchase(AbstractMediator mediator) {
        super(mediator);
    }

    //采购IBM电脑
    public void buyIBMcomputer(int number) {
       super.mediator.execute("purchase.buy", number);
    }

    //不在采购IBM电脑
    public void refuseBuyIBM() {
        System.out.println("不再采购IBM");
    }
}
