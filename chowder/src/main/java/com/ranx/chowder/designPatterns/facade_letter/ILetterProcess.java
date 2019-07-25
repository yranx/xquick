package com.ranx.chowder.designPatterns.facade_letter;

/**
 * 写信过程接口
 * @author ranx
 * @create 2019-04-26 11:05
 **/
public interface ILetterProcess {
    //写信内容
    public void writeContext(String context);
    //写信封
    public void fillEnvelope(String address);
    //把信放入信封
    public void letterIntoEnvelope();
    //邮寄
    public void sendLetter();
}
