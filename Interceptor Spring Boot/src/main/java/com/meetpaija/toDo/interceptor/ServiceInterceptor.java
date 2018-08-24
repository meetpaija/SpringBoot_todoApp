package com.meetpaija.toDo.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ServiceInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Invoke service start");
		Object res=invocation.proceed();
		System.out.println("Invoke service stop");
		return res;
	}

}
