package com.ranx.chowder.study.designPatterns.flyweight_sign_pool;


/**
 * @author ranx
 * @create 2019-05-25 21:31
 **/
public class Client {
    public static void main(String[] args) {
        //初始化对象池
        for (int i=0; i<4; i++) {
            String subject = "科目" + i;
            //初始化地址
            for (int j=0; j<30; j++) {
                String key = subject + "考试地点" + j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");

        StringMethod();
    }

    public static void StringMethod() {
        String key1 = "科目1上海";
        String key2 = "科目1上海";
        SignInfoFactory.getSignInfo(key1);
        //计算执行100万需要的时间
        long curentTime = System.currentTimeMillis();
        for (int i=0; i<100*10000; i++) {
            SignInfoFactory.getSignInfo(key2);
        }
        long tailTime = System.currentTimeMillis();;
        System.out.println("执行时间:" + (tailTime - curentTime)/1000 + 's');
    }
}
