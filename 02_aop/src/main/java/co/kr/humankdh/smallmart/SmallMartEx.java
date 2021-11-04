package co.kr.humankdh.smallmart;

import org.springframework.aop.framework.ProxyFactory;

public class SmallMartEx {
	public static void main(String[] args) {
		SmallMart mart =new SmallMartImpl();
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new BeforeLogging());
		factory.addAdvice(new BeforeLogging());
		factory.addAdvice(new AfterLogging());
		factory.addAdvice(new AroundLogging());
		factory.addAdvice(new ThrowsLogging());
		
		
		factory.setTarget(mart);
		
		SmallMart proxy = (SmallMart)factory.getProxy();
		
		try {
//			mart.getProduct("커피");
//			proxy.getProduct("커피");
//			mart.getProduct(null);
			proxy.getProduct(null);	
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
	
	}
}
