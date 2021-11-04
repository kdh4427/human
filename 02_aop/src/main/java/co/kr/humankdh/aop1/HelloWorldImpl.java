package co.kr.humankdh.aop1;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public void sayHellow(String msg) {
		System.out.println("안녕 세상 ::" + msg );
		
	}

}
