package co.kr.humankdh.smallmart2;

public class SmallMartImpl implements SmallMart {

	@Override
	public String getProduct(String msg) throws Exception {
		System.out.println(msg);
		if(msg == null) throw new Exception("예외 발생됨");
		return null;
	}
	@Override
	public String getProduct2(String msg) throws Exception {
		System.out.println(msg);
		if(msg == null) throw new Exception("예외 발생됨");
		return null;
	}


	
}
