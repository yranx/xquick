package com.ranx.chowder.study.designPatterns.proxy_dynamic_normal_com;

/**
 * 通知实现
 * @author ranx
 * @create 2019-03-26 9:05
 **/
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("前置通知，我被执行了！");
    }
}
