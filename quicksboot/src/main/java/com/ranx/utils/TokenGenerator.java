package com.ranx.utils;

import org.springframework.stereotype.Component;

/**
 * @author ranx
 * @create 2018-08-07 16:14
 **/
@Component
public interface TokenGenerator {
    public String generate(String... strings);
}
