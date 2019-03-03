package com.ranx.chowder.study.reflects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 定义一个Annotation
 * @author ranx
 * @date 2018年12月10日 下午3:50:54
    *     该注解只能用于方法上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value= {ElementType.METHOD})
public @interface AgeValidator {
	public int min();
    public int max();
}
