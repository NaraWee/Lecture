package com.greedy.section02.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 리플렉션이란?
		 * 
		 * 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법으로 반사, 투영이라는 의미를 가진다.
		 * 리플렉션은 JVM에서 실행되는 애플리케이션의 런타임 동작을 검사하거나 수정할 수 있는 기능의 필요한 경우 사용한다.
		 * 스프링프레임워크, 마이바티스, 하이버네이트, jackson 등의 라이브러리에서 사용한다.
		 * Reflection을 사용해서 스프링에서는 런타임 시에 개발자가 등록한 빈을 애플리케이션 내에서 사용할 수 있게 하는 것이다.
		 * 
		 * reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
		 * 주의사항
		 * 1. 오버헤드 발생 : 성능저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션에는 사용하지 않는다.
		 * 2. 캡슐화 삭제 : private로 설정한 member에 접근 가능하기 때문에 코드 기능이 저하되며 여러 가지 문제를 발생시킬 수 있다.
		 * 
		 * 리플렉션이 사용되는 경우
		 * 1. IoC 컨테이너
		 * 2. AOP
		 * 3. Mybatis Mapper
		 * 4. log4jdbc
		 */
		
		/*
		 * .class 문법을 이용하여 Class 타입의 인스턴스를 생성할 수 있다.
		 * Class타입의 인스턴스는 해당 클래스의 메타정보를 가지고 있는 클래스이다.
		 */
		Class class1 = Account.class;
		System.out.println("class1 : " + class1);
		
		/* Object 클래스의 getClass() 메소드를 이용하면 Class 타입으로 리턴받아 이용할 수 있다. */
		Class class2 = new Account().getClass();
		System.out.println("class2 : " + class2);
		
		/* Class.forName() 메소드를 이용하여 런타임시 로딩을 하고 그 클래스 메타정보를 Class타입을 반환 받을 수 있다. */
		try {
			
			Class class3 = Class.forName("com.greedy.section02.reflection.Account");
			System.out.println("class3 : " + class3);
			
			/* Double자료형 배열을 로드할 수 있따. */
			Class class4 = Class.forName("[D");
			Class class5 = double[].class;
			System.out.println("class4 : " + class4);
			System.out.println("class5 : " + class5);
			
			/* String 자료형 배열을 로드할 수 있다. */
			Class class6 = Class.forName("[Ljava.lang.String;");
			Class class7 = String[].class;
			System.out.println("class6 : " + class6);
			System.out.println("class7 : " + class7);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
//		double d = 1.0;					// 기본 자료형이라 class로 안됨? -> 원시자료형?
//		Class class8 = d.getClass();
		
		// TYPE 필드를 이용하면 원시형 클래스를 반환받을 수 있따.
		Class class8 = Double.TYPE;
		System.out.println("class8 : " + class8);
		
		Class class9 = Void.TYPE;
		System.out.println("class9 : " + class9);
		
		Class superClass = class1.getSuperclass();
		System.out.println("superClass : " + superClass);
		
		// 필드 정보
		Field[] fields = Account.class.getDeclaredFields();
		for(Field field : fields) {
			System.out.println("modifiers : " + Modifier.toString(field.getModifiers()) + ", type : " + field.getType() + ", name : " + field.getName());
		}
		
		// 생성자 정보
		Constructor[] constructors = Account.class.getConstructors();
		for(Constructor con : constructors) {
			System.out.println("name : " + con.getName());
			
			Class[] params = con.getParameterTypes();
			for(Class param : params) {
				System.out.println("paramType : " + param.getTypeName());
			}
		}
		
		// 생성자를 이용하여 인스턴스를 생성할 수 있다.
		Account acc;
		try {
			acc = (Account) constructors[0].newInstance("20","110-123-123123","1234",10000);
			System.out.println(acc.getBalance());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		Method[] methods = Account.class.getMethods();
		Method getBalanceMethod = null;
		
		for(Method method : methods) {
			System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getSimpleName() + " " + method.getName());
			
			if("getBalance".contentEquals(method.getName())) {
				getBalanceMethod = method;
			}
		}
		
		try {
			System.out.println(getBalanceMethod.invoke(((Account) constructors[2].newInstance()), null));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
		}
	}
}

