package com.meetpaija.toDo.concurrent;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.meetpaija.toDo.client.ServiceLocator;
import com.meetpaija.toDo.common.DelegateService;
//import com.meetpaija.toDo.context.ThreadContext;

public class DelegatingContextRunnable implements Runnable {

	private final Runnable delegate;
	
	DelegateService delegateService;
	
	public DelegatingContextRunnable(Runnable delegate) {
		this.delegate = delegate;
		this.delegateService =  (DelegateService) ServiceLocator.getBean("delegateService");
	}
	
	@Override
	public void run() {
		delegateService.start(delegate);
	}
	
	@SuppressWarnings("deprecation")
	public static Runnable create(Runnable delegate) {
		return new DelegatingContextRunnable(delegate);
	}
}
