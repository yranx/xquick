package com.ranx.chowder.study.reflects;

/**
 * @Description 定义一个泛型类
 * @author ranx
 * @date 2018年12月10日 下午4:08:15
 *
 */
public class DAO<T> {
	//根据id获取一个对象
	T get(Integer id) {
		return null;
	}
	
	//保存一个对象
	void save(T entity) {}
	
	//改造后
	private Class<T> clazz;
}
