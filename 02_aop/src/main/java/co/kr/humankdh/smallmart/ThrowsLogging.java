package co.kr.humankdh.smallmart;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsLogging implements ThrowsAdvice {
	public void afterThrowing(Throwable throwable) {
		System.out.println("예외 발생 로깅");
	}
}
