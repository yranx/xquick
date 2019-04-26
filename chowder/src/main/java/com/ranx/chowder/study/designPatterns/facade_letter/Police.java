package com.ranx.chowder.study.designPatterns.facade_letter;

/**
 * 再次扩展：信件检查类
 * @author ranx
 * @create 2019-04-26 14:08
 **/
public class Police {
    public void checkLetter(ILetterProcess letterProcess) {
        System.out.println(letterProcess + "信件已经检查过了.....");
    }
}
