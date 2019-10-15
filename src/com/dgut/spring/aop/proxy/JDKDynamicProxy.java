package com.dgut.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy implements InvocationHandler {

	private UserDao dao;
	public UserDao createUserDaoProxy(UserDao userDao) {
		this.dao = userDao;
		ClassLoader loader = JDKDynamicProxy.class.getClassLoader();
		Class[] interfaces = dao.getClass().getInterfaces();
		return (UserDao)Proxy.newProxyInstance(loader , interfaces, this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MyAspect aspect = new MyAspect();
		aspect.log();
		aspect.check();
		aspect.except();
		Object result = method.invoke(dao, args);
		aspect.monitor();
		return result;
	}

}
