package com.ranx.chowder.designPatterns.memento_mulstamem;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author ranx
 * @create 2019-04-28 19:09
 **/
public class BeanUtils {
    //将bean的所有属性及数值放入HashMap中
    public static HashMap<String, Object> backupProp(Object bean) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获取属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            //遍历所有属性
            for (PropertyDescriptor des : descriptors) {
                //属性名
                String filedName = des.getName();
                //读取属性的方法
                Method method = des.getReadMethod();
                //读取属性值
                Object filedValue = method.invoke(bean, new Object[]{});
                if (!filedName.equalsIgnoreCase("class")) {
                    result.put(filedName, filedValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //把HashMap的值返回到bean中
    public static void restoreProp(Object bean, HashMap<String, Object> propMap) {
        try {
            //获得Bean描述
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获得属性描述
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            //遍历所有属性
            for (PropertyDescriptor des : descriptors) {
                //属性名称
                String filedName = des.getName();
                //如果有该属性
                if (propMap.containsKey(filedName)) {
                    //写属性的方法
                    Method method = des.getWriteMethod();
                    method.invoke(bean, new Object[]{ propMap.get(filedName)});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
