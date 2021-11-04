package co.kr.humankdh.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


import lombok.Data;

@Data
public class SimpleValueEx {
	private String name;
	private int age;
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("value.xml");
		SimpleValueEx ex = ctx.getBean("ex", SimpleValueEx.class);
		System.out.println(ex);
		SimpleValueEx ex1 = ctx.getBean("ex1", SimpleValueEx.class);
		System.out.println(ex1);
	}
}
