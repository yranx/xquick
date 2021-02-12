package com.ranx.chowder.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 加签 验签
 * @author ranx
 * @Date 2021年1月11日13:19:45
 * SHA-256作 摘要算法   RS作 签名验签算法
 */
public class SignatureAddCheck {

    //公钥字符串
    private static final String PUBLIC_KEY_STR = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDaJzVjC5K6kbS2YE2fiDs6H8pB\n" +
            "JFDGEYqqJJC9I3E0Ebr5FsofdImV5eWdBSeADwcR9ppNbpORdZmcX6SipogKx9PX\n" +
            "5aAO4GPesroVeOs91xrLEGt/arteW8iSD+ZaGDUVV3+wcEdci/eCvFlc5PUuZJou\n" +
            "M2XZaDK4Fg2IRTfDXQIDAQAB";

    //私钥字符串
    private static final String PRIVATE_KEY_STR = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANonNWMLkrqRtLZg\n" +
            "TZ+IOzofykEkUMYRiqokkL0jcTQRuvkWyh90iZXl5Z0FJ4APBxH2mk1uk5F1mZxf\n" +
            "pKKmiArH09floA7gY96yuhV46z3XGssQa39qu15byJIP5loYNRVXf7BwR1yL94K8\n" +
            "WVzk9S5kmi4zZdloMrgWDYhFN8NdAgMBAAECgYA9bz1Bn0i68b2KfqRdgOfs/nbe\n" +
            "0XNN1DLQp2t7WDfRCg01iI1zPkZgyFVZWtI85f5/uIrLs5ArLosL1oNuqqc0nNne\n" +
            "CvJK+ZxvA98Hx3ZqYTzDnleR054YhofL5awbhSciYVic204DOG1rhSsYWMqtX7J7\n" +
            "3geoWL7TYdMfYXcCAQJBAPMMKsz6ZJh98EeQ1tDG5gpAGWFQkYNrxZDelP/LjeO0\n" +
            "TP3XkQnIpcaZoCs7V/rRGRGMWwQ2BUdc/01in89ZZ5ECQQDlx2oBc1CtOAm2UAhN\n" +
            "1xWrPkZWENQ53wTrwXO4qbTGDfBKon0AehLlGCSqxQ71aufLkNO7ZlX0IHTAlnk1\n" +
            "TvENAkAGSEQ69CXxgx/Y2beTwfBkR2/gghKg0QJUUkyLqBlMz3ZGAXJwTE1sqr/n\n" +
            "HiuSAiGhwH0ByNuuEotO1sPGukrhAkAMK26a2w+nzPL+u+hkrwKPykGRZ1zGH+Cz\n" +
            "19AYNKzFXJGgclCqiMydY5T1knBDYUEbj/UW1Mmyn1FvrciHoUG1AkAEMEIuDauz\n" +
            "JabEAU08YmZw6OoDGsukRWaPfjOEiVhH88p00veM1R37nwhoDMGyEGXVeVzNPvk7\n" +
            "cELg28MSRzCK";


    /**
     * 根据私钥字符串生成私钥对象
     * @param privateKeyStr
     * @return
     */
    private static PrivateKey getPriveteKey(String privateKeyStr) {
        PrivateKey privateKey = null;
        PKCS8EncodedKeySpec priPKCS8;
        try {
            priPKCS8 = new PKCS8EncodedKeySpec(new BASE64Decoder().decodeBuffer(privateKeyStr));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(priPKCS8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    /**
     * 获取公钥
     * @param publicKeyStr
     * @return
     * @throws Exception
     */
    private static PublicKey getPublicKey(String publicKeyStr) throws Exception {
        PublicKey publicKey = null;
        X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(publicKeyStr)
        );

        //RSA 对称加密算法
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        //生成公钥对象
        publicKey = keyFactory.generatePublic(bobPubKeySpec);

        return publicKey;
    }
    /**
     * 加签方法
     * @param plain
     * @return
     * @throws Exception
     */
    private static byte[] sign(String plain) throws Exception {
        //根据对应算法，获取签名对象实例
        Signature signature = Signature.getInstance("SHA256WithRSA");
        //获取私钥，加签用的是私钥，私钥一般在配置文件里读取，
        //根据私钥字符串生成私钥对象
        PrivateKey privateKey = getPriveteKey(PRIVATE_KEY_STR);
        //初始化签名对象
        signature.initSign(privateKey);
        //把原始报文更新到对象
        signature.update(plain.getBytes("UTF-8"));
        //加签
        return signature.sign();

    }


    /**
     * 验签
     * @param plain
     * @param signatureByte
     * @return
     * @throws Exception
     */
    private static boolean verify(String plain, byte[] signatureByte) throws Exception {
        //获取公钥
        PublicKey publicKey = getPublicKey(PUBLIC_KEY_STR);
        //根据对应算法，获取签名对象实例
        Signature signature = Signature.getInstance("SHA256WithRSA");
        //初始化签名对象
        signature.initVerify(publicKey);
        signature.update(plain.getBytes("UTF-8"));
        //进行验签
        return signature.verify(signatureByte);
    }

    public static void main(String[] args) throws Exception {
        //原始报文
        String plain = "Helle Signature";
        //加签
        byte[] signatureByte = sign(plain);
        System.out.println("原始报文是：" + plain);
        System.out.println("加签结果是：" + new BASE64Encoder().encode(signatureByte));

        //验签
        boolean verifyResult = verify(plain, signatureByte);
        System.out.println("验签结果：" + verifyResult);
    }

}
