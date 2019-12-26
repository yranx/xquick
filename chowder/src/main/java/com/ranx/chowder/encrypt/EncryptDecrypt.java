package com.ranx.chowder.encrypt;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ranx
 * @create 2018-08-09 10:45
 **/
public class EncryptDecrypt {

    private static final String ENCODE = "UTF-8";
    //AES模式（CBC+PKCS5padding模式），CBC 需要一个AES_IV偏移量参数，而AES_KEY 是密钥。
    private static final String AES = "AES";
    private static final String AES_IV = "0304050607080910";
    private static final String AES_KEY = "1234567890123456";
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";

    /**
     * AES加密后再Base64编码，输出密文。注意AES加密的输入是二进制串，所以需要先将UTF-8明文转成二进制串
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes(), AES);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(AES_IV.getBytes()));
        //先获取二进制串，在进行AES模式加密
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        //将二进制串编码成BASE64串
        return new BASE64Encoder().encode(encrypted);
    }

    /**
     * Base64解码后再进行AES解密，最后对二进制明文串进行UTF-8编码输出明文串
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                return null;
            }

            SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes(ENCODE), AES);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(AES_IV.getBytes()));
            //先将BASE64密文串解码成二进制串
            byte[] encrypted = new BASE64Decoder().decodeBuffer(sSrc);
            try {
                //再将二进制密文串进行AES模式解密
                byte[] original = cipher.doFinal(encrypted);
                //最后将二进制的明文串以UTF-8格式编码成字符串后输出
                return  new String(original, ENCODE);
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }


    public static void main(String[] args) throws Exception {
        /*
         * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符，
         * 此处使用AES-128-CBC加密模式，key需要为16位。
         */
        String cKey = AES_KEY;
        // 需要加密的字串
        String cSrc = "mytestxxx";
        System.out.println("加密前的字串是：" + cSrc);
        // 加密
        String enString = Encrypt(cSrc, cKey);
        System.out.println("加密后的字串是：" + enString);
        // 解密
        String DeString = Decrypt(enString, cKey);
        System.out.println("解密后的字串是：" + DeString);

    }
}
