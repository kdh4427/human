package co.kr.humankdh.smallmart5;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import co.kr.humankdh.smallmart.advicce.BeforeLogging;

public class SmallMartEx {
	public static void main(String[] args) throws Exception  {
		// AolicationContext
		// getProduct2 xml aop
		
		// proxyFactoryBean
		// Advice
		// PointCut
		// Advisor
			
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("mart3.xml");
		
		SmallMart mart = ctx.getBean("smallMartImpl", SmallMart.class);
		
		mart.getProduct("식빵");
		System.out.println("============================");
		mart.getProduct2("smallmart2");
		
		
	}
}
