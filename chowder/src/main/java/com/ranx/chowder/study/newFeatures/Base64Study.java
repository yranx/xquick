package com.ranx.chowder.study.newFeatures;

import java.util.Base64;
import java.util.UUID;

/**
 * @author ranx
 * @create 2018-08-30 23:40
 **/
public class Base64Study {

    public static void main(String args[]) {

        //使用基本编码
        try {
            String base64encodedString = Base64.getEncoder().encodeToString("ranx?java8".getBytes("utf-8"));
            System.out.println(base64encodedString);

            //解码
            byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
            System.out.println(new String(base64decodedBytes, "utf-8"));


            base64encodedString = Base64.getUrlEncoder().encodeToString("TutorialsPoint?java8".getBytes("utf-8"));
            System.out.println(base64encodedString);

            StringBuilder stringBuilder = new StringBuilder();
            for (int i=0; i<10; ++i) {
                stringBuilder.append(UUID.randomUUID().toString());
            }
            byte[] mimeBytes = stringBuilder.toString().getBytes("utf-8");
            String mimeEncodedString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("MIME:" + mimeEncodedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
