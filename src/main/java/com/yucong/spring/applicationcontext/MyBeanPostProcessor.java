package com.yucong.spring.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("9.MyBeanPostProcessor的postProcessAfterInitialization被调用, beanName : "+ beanName);
		return bean;
	}

	/**
	 *  实例化、依赖注入完毕，在调用显式的初始化之前完成一些定制的初始化任务
	 */
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("6.MyBeanPostProcessor的postProcessBeforeInitialization被调用, beanName : "+ beanName);
		return bean;
	}

}