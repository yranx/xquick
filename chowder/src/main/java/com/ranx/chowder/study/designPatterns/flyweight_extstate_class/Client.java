package com.ranx.chowder.study.designPatterns.flyweight_extstate_class;


/**
 * @author ranx
 * @create 2019-05-25 21:31
 **/
public class Client {
    public static void main(String[] args) {
        ExtrinsicMethod();
    }

    public static void ExtrinsicMethod() {
        ExtrinsicState state = new ExtrinsicState();
        state.setSubject("科目1");
        state.setLocation("上海");
        SignInfoFactory.getSignInfo(state);
        ExtrinsicState state2 = new ExtrinsicState();
        state2.setSubject("科目1");
        state2.setLocation("上海");
        //计算执行100万需要的时间
        long curentTime = System.currentTimeMillis();
        for (int i=0; i<100*10000; i++) {
            SignInfoFactory.getSignInfo(state2);
        }
       long tailTime = System.currentTimeMillis();;
       System.out.println("执行时间:" + (tailTime - curentTime)/1000 + 's');
    }


}
