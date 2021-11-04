package co.kr.humankdh.smallmart2;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import co.kr.humankdh.smallmart.advicce.BeforeLogging;

//public class SmallMartEx {
//	public static void main(String[] args) {
//		SmallMart mart =new SmallMartImpl();
//		
//		ProxyFactory factory = new ProxyFactory();
//		
//		factory.addAdvisor(new DefaultPointcutAdvisor(new StaticMethodMatcherPointcut() {
//			@Override
//			public boolean matches(Method arg0, Class<?> arg1) {
//				return arg0.getName().endsWith("2");
//			}
////		}, new MethodBeforeAdviceInterceptor(fac)));
//	
//		
//		
//		factory.setTarget(mart);
		
//		SmallMart proxy = (SmallMart)factory.getProxy();
//		
//		try {
////			mart.getProduct("커피");
////			proxy.getProduct("커피");
//			
//			proxy.getProduct2("커피");
////			mart.getProduct(null);
////			proxy.getProduct(null);	
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//			
//	
//	}
//}
