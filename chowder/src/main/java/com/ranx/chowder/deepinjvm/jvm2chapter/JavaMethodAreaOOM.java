package com.ranx.chowder.deepinjvm.jvm2chapter;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
* @Description: 借助CGLib是方法区出现内存溢出异常
* @author ranx
* @date 2019年9月26日15:57:39
 */
public class JavaMethodAreaOOM {
	static class OOMObject{}
	
	/**
	 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
	 * 
	 */
	
	public static void main(String[] args) {
		while(true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				
				@Override
				public Object intercept(Object obj, Method method, Object[] args,
						MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			enhancer.create();
		}
	}
}
