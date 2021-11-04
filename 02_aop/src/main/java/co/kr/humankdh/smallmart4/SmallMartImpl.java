package co.kr.humankdh.smallmart4;

import lombok.Setter;

@Setter
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
