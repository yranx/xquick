package com.ranx.chowder.reflects;

/**
 * @Description
 * @author ranx
 * @date 2018年12月10日 上午11:16:47
 *
 */
public class Person {
	String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@AgeValidator(min=18,max=35)
	public void setAge(int age) {
		this.age = age;
	}

	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void test(String name,Integer age){
        System.out.println("调用成功");
        System.out.println(name + ":" + age);
    }
}
