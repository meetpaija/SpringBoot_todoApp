package com.meetpaija.toDo.client;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ServiceLocator implements BeanFactoryAware {
	static DefaultListableBeanFactory applicationContext = null;
	
	public static Object getBean(String beanName)
	{
		return applicationContext.getBean(beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException
	{

		applicationContext = (DefaultListableBeanFactory) beanFactory;
	}


}
