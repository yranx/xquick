package com.ranx.chowder.study.reflects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Description
 * @author ranx
 * @date 2018年12月10日 上午11:11:47
 *       结合https://www.cnblogs.com/tech-bird/p/3525336.html
 */
public class ReflectTest {

	private static final String CLASS_NAME = "com.ranx.reflects.Person";

	public static void testClass() {
		Class clazz = null;

		// 1.通过类名
		clazz = Person.class;

		// 2.通过对象名：用在传进来一个对象，却不知道对象类型的时候使用
		// 比如传进来一个Object类
		Object object = new Person();
		clazz = object.getClass();

		// 3.通过全类名(会抛出异常)
		// 一般框架开发中这种用的比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
		String className = CLASS_NAME;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testClassLoader() {
		// 1.获取一个系统的类加载器（可以获取，当前这个类ReflectTest就是它加载的
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader);

		// 2.获取系统类加载器的父类加载器(扩展类加载器，可以获取）
		classLoader = classLoader.getParent();
		System.out.println(classLoader);

		// 3.获取扩展类加载器的父类加载器（引导类加载器，不可获取）.
		classLoader = classLoader.getParent();
		System.out.println(classLoader);

		try {
			// 4.测试当前类由哪个类加载器进行加载（系统类加载器)
			classLoader = Class.forName("com.ranx.reflects.ReflectTest").getClassLoader();
			System.out.println(classLoader);

			// 5.测试JDK提供的Object类由哪个类加载器负责加载（引导类）
			classLoader = Class.forName("java.lang.Object").getClassLoader();
			System.out.println(classLoader);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/**
		 * 使用类加载器获取当前类目录下的文件
		 */
		try {
//			InputStream in = new FileInputStream("testReflect.txt");  //src目录下无法获取
//			//根目录下是可以的
//			System.out.println(in);

			/**
			 * 系统类加载器可以加载当前项目src目录下面的所有类，如果文件也放在src下面，也可以用类加载器来加载
			 * 
			 * 调用 getResourceAsStream 获取类路径下的文件对应的输入流
			 */
			// src目录下直接加载
			InputStream in1 = null;
			in1 = ReflectTest.class.getClassLoader().getResourceAsStream("testReflect.txt");
			System.out.println(in1);

			// 放在内部文件夹，要写全路径
			InputStream in2 = null;
			in2 = ReflectTest.class.getClassLoader().getResourceAsStream("com/ranx/reflects/testReflect.txt");
			System.out.println(in2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 把类对象和类方法名作为参数，执行方法
	 * 
	 * @param obj        方法执行的对象
	 * @param methodName 类的一个方法的方法名。该方法也可能是私有方法
	 * @param args       调用该方法需要传入的参数
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static Object invoke(Object obj, String methodName, Object... args) throws Exception {
		// 获取Method对象
		// 因为getMethod的参数为Class列表类型，所以要把参数args转化为对应的Class类型。
		Class[] parameterTypes = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			parameterTypes[i] = args[i].getClass();
			System.out.println(parameterTypes[i]);
		}

		Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
		return method.invoke(obj, args);
	}

	/**
	 * 把全类名和方法名作为参数，执行方法
	 * 
	 * @param className  某个类的全类名
	 * @param methodName 类的一个方法的方法名. 该方法也可能是私有方法.
	 * @param args       调用该方法需要传入的参数
	 * @return
	 */
	public static Object invoke(String className, String methodName, Object... args) {
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
			return invoke(obj, methodName, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void testConstructor() throws Exception {
		String className = CLASS_NAME;
		Class<Person> clazz = (Class<Person>) Class.forName(className);
		// 获取Constructor对象
		Constructor<Person>[] constructors = (Constructor<Person>[]) Class.forName(className).getConstructors();
		for (Constructor<Person> constructor : constructors) {
			System.out.println(constructor);
		}

		// 获取某一个，需要参数列表
		Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
		System.out.println(constructor);

		// 调用构造器的newInstance()方法创建对象
		Object obj = constructor.newInstance("ranx", 1);
	}

	//通过反射的方式为属性赋值，才能获取到注解
	public static void testAnnotation() throws Exception {
		Class clazz = Class.forName(CLASS_NAME);
		Object obj = clazz.newInstance();
		
		Method method = clazz.getDeclaredMethod("setAge", int.class);
		int val = 6;
		
		//获取指定名称的注解
		Annotation annotation = method.getAnnotation(AgeValidator.class);
		if (annotation != null) {
			if (annotation instanceof AgeValidator) {
				AgeValidator ageValidator = (AgeValidator) annotation;
				if (val < ageValidator.min() || val > ageValidator.max()) {
					throw new RuntimeException("年龄非法");
				}
			}
		}
		method.invoke(obj, 20);
		System.out.println(obj);
	}
	
	public static void testT() throws Exception{
	       PersonDao personDAO = new PersonDao();
	       Person entity = new Person();
	       //调用父类的save方法，同时也把Person这个“实参”传给了父类的T
	       personDAO.save(entity);       
	       //这句的本意是要返回一个Person类型的对象
	       Person result = personDAO.get(1); 
	       /**
	        * 这里的get方法是父类的get方法，对于父类而言，方法返回值是一个T类型，当T的值为Person时，本该返回一个Person类型，
	        * 但是必须用反射来创建这个对象（泛型方法返回一个对象），方法无非就是clazz.newInstance(); 
	        * 所以关键点就是根据T得到其对于的Class对象。
	        */
	       System.out.print(result);  //null
	    }
	
	public static void main(String[] args) {
//		testClass();
//		testClassLoader();
//		Object obj = new Person();
//		try {
//			invoke(obj, "test", "ranx", 1);
//			invoke("com.ranx.reflects.Person", 
//                    "test", "ranxx", 12);  
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		try {
//			testConstructor();
//			testAnnotation();
			testT();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
