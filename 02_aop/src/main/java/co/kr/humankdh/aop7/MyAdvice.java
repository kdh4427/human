package co.kr.humankdh.aop7;

import java.lang.reflect.Method;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component @Aspect
public class MyAdvice {
	@Pointcut("execution(* *(..)) && args(value)")
	public void myPc(int value) {}
	
	
//	@AfterReturning("execution(* *(..)) and args(value)")
	@Before("myPc(value)")
	public void simple (JoinPoint jp, int value) {
		if(value > 5000) {
			System.out.println("advice access!!!");
		}
			
	}
	
	@Around("execution(* good*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("pre around!!!");
		Object obj = pjp.proceed();
		System.out.println("suf around!!!");
		return obj;
	}
	
}
