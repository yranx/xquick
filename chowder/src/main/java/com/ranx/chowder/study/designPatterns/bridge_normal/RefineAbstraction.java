package com.ranx.chowder.study.designPatterns.bridge_normal;

/**
 * @author ranx
 * @create 2019-06-12 19:08
 **/
public class RefineAbstraction extends Abstraction {
    //复写构造函数
    public RefineAbstraction(Implementor imp) {
        super(imp);
    }

    //修正父类的行为
    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }
}
