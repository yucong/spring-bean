package com.yucong.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yucong.spring.applicationcontext.UserService;


/**
 * 
 * Spring容器并不是只有一个。Spring自带了多个容器实现，可以归为两种不同的类型。两种容器的的bean生命周期略有不同
 * ---->1:bean工厂（由org.springframework.beans.factory.BeanFactory接口定义）是最简单的容器，
 * -------提供基本的DI 支持。<br/>
 * ---->2:应用上下文（由org.springframework.context.ApplicationContext接口定义）<br/>
 * -------基于BeanFactory构建， 并提供应用框架级别的服务，例如 从属性文件解析文本信息以及发布应用事件给感兴趣的事件监听者。<br/>
 * 
 * ApplicationContext　Bean生命周期:<br/>
 * ---->1．Spring对bean进行实例化；<br/>
 * ---->2．Spring将值和bean的引用注入到bean对应的属性中；<br/>
 * ---->3．如果bean实现了BeanNameAware接口，Spring将bean的ID传递给setBean-Name()方法；<br/>
 * ---->4．如果bean实现了BeanFactoryAware接口，Spring将调用setBeanFactory()方法，
 * -------将BeanFactory容器实例传入；<br/>
 * ---->5．如果bean实现了ApplicationContextAware接口，Spring将调用setApplicationContext()方法，
 * -------将bean所在的应用上下文的引用传入进来；<br/>
 * ---->6．如果上下文中存在实现了BeanPostProcessor接口的bean，Spring将调用它们的post-
 * -------ProcessBeforeInitialization()方法；<br/>
 * ---->7．如果bean实现了InitializingBean接口，Spring将调用它们的after-PropertiesSet()方法。类似地，
 * ---->8．如果bean使用init-method声明了初始化方法，该方法也会被调用；<br/>
 * ---->9．如果上下文中存在实现了BeanPostProcessor接口的bean，Spring将调用它们的post-
 * -------ProcessAfterInitialization()方法；<br/>
 * -------经过以上过程之后，就可以正式使用该Bean了，对于scope为singleton的Bean,
 * -------，它们将一直驻留在应用上下文中，直到该应用上下文被销毁;而对于scope为prototype的Bean,
 * -------每次被调用都回new一个对象，而且生命周期也交给调用方管理了，不再是Spring容器进行管理了。<br/>
 * ---->10. 容器关闭后，如果Bean实现了DisposableBean接口，则会调用该接口的destroy()方法。<br/>
 * ---->11. 如果Bean配置了destroy-method方法，则会执行destroy-method配置的方法，至此，整个Bean生命周期结束。<br/>
 * 
 * BeanFactory　Bean生命周期：<br/>
 * 与ApplicationContext相比，有如下几点不同：<br/>
 * 
 * ---->1.
 * BeanFactory容器中，不会调用ApplicationContextAware接口的setApplicationContext()方法。<br/>
 * 
 * ---->2.
 * BeanPostProcessor接口的postProcessBeforeInitialization方法和postProcessAfterInitialization方法不会自动调用
 * ，必须自己通过代码手动注册
 * 
 * ---->3. BeanFactory容器启动的时候，不会去实例化所有bean，包括所有scope为singleton且非延迟加载的bean也是一样，
 * 而是在调用的时候去实例化。<br/>
 * 
 * 
 * @author 王庆丰
 * @version 2017年9月28日 下午3:52:08
 */
public class Step06 {


	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		@SuppressWarnings("unused")
		UserService userService = (UserService) applicationContext.getBean("userService");

		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
