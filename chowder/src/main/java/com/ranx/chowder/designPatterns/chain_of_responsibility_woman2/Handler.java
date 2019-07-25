package com.ranx.chowder.designPatterns.chain_of_responsibility_woman2;

/**
 * 有处理权的人员接口
 * @author ranx
 * @create 2019-04-08 14:30
 **/
public abstract class Handler {
    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEL_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;

    //能处理的级别
    private int level = 0;

    //责任传递，下一个责任人是谁
    private Handler nextHandler;

    //每个类都要说明一下自己能处理那些请求
    public Handler(int level) {
        this.level = level;
    }
    //女性的请求，需要处理下
    public final void handleMessage(IWomen women) {
        if (women.getType() ==  this.level) {
            this.response(women);
        } else {
            if (this.nextHandler != null) { //有后续环节，才将请求向后递送
                this.nextHandler.handleMessage(women);
            } else { //无后续处理人，不用处理了
                System.out.println("----没地方请示了，按不同意处理----");
            }
        }
    }

    //不属于你处理的请求，要去找下一个环节的人
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    //请示的回应
    protected abstract void response(IWomen women);
}
