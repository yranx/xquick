package com.ranx.chowder.study.cusannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 调用反射机制来调用注解中的内容
 * @author ranx
 * @create 2019-06-09 20:02
 **/
public class AnnoReflection {
    public static void main(String[] args) throws Exception{
        Class<AnnoOut> annoOutClass = AnnoOut.class;
        Method method = annoOutClass.getMethod("output", new Class[]{});
        if (method.isAnnotationPresent(CusAnnotation.class)) {
            CusAnnotation annoOut = method.getAnnotation(CusAnnotation.class);
            System.out.println(annoOut.hello());
            System.out.println(annoOut.world());
        }

        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType().getName());
        }
    }
}
