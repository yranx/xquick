package com.ranx.chowder.study.designPatterns.facade_letter;

/**
 * @author ranx
 * @create 2019-04-26 11:13
 **/
public class client {
    public static void main(String[] args) {
        //创建一个处理信件的过程
//        ILetterProcess letterProcess = new LetterProcessImpl();
//        letterProcess.writeContext("Hello, It's me, I'd like to...");
//        letterProcess.fillEnvelope("Happy Road No.666");
//        letterProcess.sendLetter();

        //改为 ModenPostOffice以后
        ModenPostOffice postOffice = new ModenPostOffice();

        String context = "Hello, It's me, I'd like to...";
        String address = "Happy Road No.666";
        postOffice.sendLetter(context, address);
    }
}
