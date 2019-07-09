package com.yucong.spring.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 该类实现了BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean, DisposableBean五个接口，
 * 并且在applicationContext.xml文件中配置了该Bean的id为userService,并且配置了init-method和destroy-method,为
 * 该Bean配置了属性name为userSercie的值，然后定义了一个名为MyBeanPostProcessor的bean, 该bean定义类实现了
 * BeanPostProcessor接口
 * 
 * @author Administrator
 * 
 */
public class UserService implements BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;

	public UserService() {
		System.out.println("1.UserService 被实例化，UserService()构造方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("2.注入属性，setName() 被调用");
	}


	public void setBeanName(String beanName) {
		System.out.println("3.注入beanName，BeanNameAware接口的setBeanName被调用, beanName : " + beanName);

	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out
				.println("4.注入beanFactory，BeanFactoryAware接口的setBeanFactory被调用, beanFactory : " + beanFactory);
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("5.注入applicationContext，ApplicationContextAware接口的setApplicationContext() 被调用, applicationContext : " + applicationContext);

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("7.InitializingBean接口afterPropertiesSet() 被调用");

	}


	public void myInit() {
		System.out.println("8.init-method配置的myInit() 被调用");
	}


	public void destroy() throws Exception {
		System.out.println("10.DisposableBean接口的destroy() 被调用");

	}

	public void myDestroy() {
		System.out.println("11.destroy-method配置的myDestroy() 被调用");
	}

	public String toString() {
		return "UserService[name=" + name + "]";
	}
}