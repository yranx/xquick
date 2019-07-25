package com.ranx.chowder.designPatterns.facade_letter;

/**
 * 扩展：现代化邮局
 * @author ranx
 * @create 2019-04-26 11:23
 **/
public class ModenPostOffice {
    private ILetterProcess letterProcess = new LetterProcessImpl();
    private Police letterPolice = new Police();

    public void sendLetter(String context, String address) {
        letterProcess.writeContext(context);
        letterProcess.fillEnvelope(address);

        //检查
        letterPolice.checkLetter(letterProcess);

        letterProcess.letterIntoEnvelope();
        letterProcess.sendLetter();
    }
}
