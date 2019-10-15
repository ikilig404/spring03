package com.dgut.spring.aop.proxy;

public class JDKDynamicTest {
	public static void main(String[] args) {
		//创建代理对象
		JDKDynamicProxy jdkProxy = new JDKDynamicProxy();
		//创建目标对象
		UserDao testDao = new UserDaoImpl();
		//从代理对象中获取增强后的目标对象，该对象是一个被代理的对象，它会进入代理的逻辑方法invoke里
		UserDao proxy = (UserDao)jdkProxy.createUserDaoProxy(testDao);
		//执行方法
		proxy.save();
		System.out.println("==============");
		proxy.modify();
		System.out.println("==============");
		proxy.delete();
		System.out.println("==============");

	}
}
