package co.kr.humankdh.smallmart5;

import org.springframework.stereotype.Component;

import lombok.Setter;

@Setter
@Component
public class SmallMartImpl implements SmallMart {

	@Override
	public void getProduct(String msg)  {
		System.out.println(msg);
	
	}
	
	@Override
	public void getProduct2(String msg)  {
		System.out.println(msg);
	
	}


	
}
