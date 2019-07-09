package com.yucong.spring.beanfactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.yucong.spring.applicationcontext.MyBeanPostProcessor;
import com.yucong.spring.applicationcontext.UserService;


/**
 * 
 * 演示BeanFactory容器中bean的生命周期
 * 
 * @author 王庆丰
 * @version 2017年9月28日 下午3:52:08
 */
@SuppressWarnings("deprecation")
public class Step06 {


	public static void main(String[] args) {
		System.out.println("start init ioc container");

		ConfigurableListableBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		System.out.println("end loading xml");
		beanFactory.addBeanPostProcessor(new MyBeanPostProcessor());
		UserService userService = (UserService) beanFactory.getBean("userService");
		System.out.println(userService);
		System.out.println("close container");
		beanFactory.destroySingletons();
	}
}
