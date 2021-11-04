package co.kr.humankdh.ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderManagerApp {
	public static void main(String[] args) {

		// DL
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc2.xml");
		OrderManager orderManager = ctx.getBean("orderManager", OrderManager.class);
		orderManager.order();
	}
}
