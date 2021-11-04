package co.kr.humankdh.value1;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Getter @Component @ToString
public class Person {
	private String name = "홍길동";
	private int age = 20;
	

}
