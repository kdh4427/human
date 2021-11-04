package co.kr.humankdh.smallmart3;

import java.lang.reflect.Method;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

public class MyAdvice {
	public void simple (Joinpoint jp, int value) {
		if(value > 5000) {
			System.out.println("advice access!!!");
		}
			
	}
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("pre around!!!");
		Object obj = pjp.proceed();
		System.out.println("suf around!!!");
		return obj;
	}
	public void before(Joinpoint jp) {
		System.out.println("before");
	}
}
