package com.SpringPractice.learnspringframework.instance1;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2HelloWorldSpring {
	public static void main(String[] args) {
		try (var contrext = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			System.out.println(contrext.getBean("name"));//by name of the bean
			System.out.println(contrext.getBean("age"));
			System.out.println(contrext.getBean("person"));
			System.out.println(contrext.getBean("person2MethodCall"));
			System.out.println(contrext.getBean("person2Parameters"));
			System.out.println(contrext.getBean("address2"));//by name of the bean
			System.out.println(contrext.getBean(Address.class));//by type of the bean
			
			Arrays.stream(contrext.getBeanDefinitionNames()).forEach(System.out::println);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
