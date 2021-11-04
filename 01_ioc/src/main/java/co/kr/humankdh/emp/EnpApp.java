package co.kr.humankdh.emp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EnpApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("emp.xml");
		Emp e = ctx.getBean("emp", Emp.class);
		e.work();
	}
}
