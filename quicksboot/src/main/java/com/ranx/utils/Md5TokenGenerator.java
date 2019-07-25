package com.ranx.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * token生成
 * @author ranx
 * @create 2018-08-07 16:14
 **/
@Component
public class Md5TokenGenerator implements TokenGenerator {
    @Override
    public String generate(String... strings) {
        Long timestamp = System.currentTimeMillis();
        String tokenMeta = "";
        for (String s : strings) {
            tokenMeta = tokenMeta + s;
        }
        tokenMeta = tokenMeta + timestamp;
        String token = DigestUtils.md5DigestAsHex(tokenMeta.getBytes());
        return token;
    }
}
