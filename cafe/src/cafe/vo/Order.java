package cafe.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * [주문 클래스]<br>
 * 주문에는 주문코드(주문날짜), 주문자(멤버/회원), 장바구니, 배달, 결제 각각의 내역들을 저장합니다.<br>
 * Date: 2021-08-02
 * @author 박인영
 */
public class Order {
	
	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [주문코드]<br>
	 * 주문의 고유 코드입니다.<br>
	 * 주문이 완료되는 시점의 시간으로 자동으로 만들어지는 코드로써 유일한 값을 가집니다.<br>
	 * Date: 2021-08-02
	 * @author 박인영
	 */
	private String orderCode;
	
	/**
	 * < Person > 프로그램 이용자<br>
	 * ├ Member : 멤버 (마일리지 적립/사용, 배달 /픽업 가능)<br>
	 * ├ User : 회원 (픽업만 가능)<br>
	 * └ Manager : 관리자
	 */
	private Person personInfo = new Member();
	
	/**
	 * [장바구니정보]<br>
	 * 장바구니에 담았던 메뉴와 수량이 저장합니다.<br>
	 * 조회가능 정보: 메뉴코드, 메뉴명, 주문수량<br>
	 * Date: 2021-08-07
	 * @author 박인영
	 */
	private List<Cart> cartInfo = new ArrayList<Cart>();
	
	/**
	 * [주문메뉴리스트]
	 * 장바구니에 담긴 메뉴를 주문수량과 함께 저장하는 변수입니다.<br>
	 * 메뉴명(메뉴수량개) (ex. 아메리카노ICE(2개))<br>
	 * 이 값은 주문 내역을 조회할 때 사용됩니다.<br>
	 * Date: 2021-08-09
	 * @author 박인영
	 */
	private String orderMenus;
	
	/**
	 * [배달정보]<br>
	 * 배달 또는 픽업과 관련된 정보가 저장됩니다.<br>
	 * 조회가능 정보: 총주문수량, 배달예상시간<br>
	 * Date: 2021-08-07
	 * @author 박인영
	 */
	private DeliveryTime deliveryInfo = new DeliveryTime();
	
	/**
	 * [결제정보]<br>
	 * 결제 관련된 정보가 저장됩니다.<br>
	 * 조회가능 정보: 총결제금액, 카드결제금액, 마일리지결제금액, 적립마일리지<br>
	 * Date: 2021-08-07
	 * @author 박인영
	 */
	private Payment paymentInfo = new Payment();
	

	/* ------------------------------ 생성자 ------------------------------ */
	
	public Order() {}

	public Order(Person personInfo, List<Cart> cartInfo
				, DeliveryTime deliveryInfo, Payment paymentInfo, String orderMenus) {
		// [주문코드 생성]
		// 결제 후 주문리스트가 생성되면서 주문코드가 생성됩니다.
		// 현재날짜와 현재시간으로 이루어진 문자열 타입의 코드입니다.
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmss");
		this.orderCode = "" + sdf.format(today);
		this.personInfo = personInfo;
		this.cartInfo = cartInfo;
		this.deliveryInfo = deliveryInfo;
		this.paymentInfo = paymentInfo;
		this.orderMenus = orderMenus;
	}
	
	public Order(String orderCode, Person personInfo, List<Cart> cartInfo, DeliveryTime deliveryInfo,
			Payment paymentInfo) {
		String orderMenus ="";
		for (int i = 0; i < cartInfo.size(); i++) {
			if (i != cartInfo.size()-1)
				orderMenus += cartInfo.get(i).getMenuName() + " (" + cartInfo.get(i).getOrderCount() + "개), ";
			else
				orderMenus += cartInfo.get(i).getMenuName() + " (" + cartInfo.get(i).getOrderCount() + "개)";
		}
		this.orderCode = orderCode;
		this.personInfo = personInfo;
		this.cartInfo = cartInfo;
		this.orderMenus = orderMenus;
		this.deliveryInfo = deliveryInfo;
		this.paymentInfo = paymentInfo;
	}
	
	
	/* ------------------------------ getter&setter ------------------------------ */
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Person getPersonInfo() {
		return personInfo;
	}
	public void setPersonInfo(Person personInfo) {
		this.personInfo = personInfo;
	}
	public List<Cart> getCartInfo() {
		return cartInfo;
	}
	public void setCartInfo(List<Cart> cartInfo) {
		this.cartInfo = cartInfo;
	}
	public String getOrderMenus() {
		return orderMenus;
	}
	public void setOrderMenus(String orderMenus) {
		this.orderMenus = orderMenus;
	}
	public DeliveryTime getDeliveryInfo() {
		return deliveryInfo;
	}
	public void setDeliveryInfo(DeliveryTime deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}
	public Payment getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(Payment paymentInfo) {
		this.paymentInfo = paymentInfo;
	}


	
	/* ------------------------------ toString ------------------------------ */
	
	/**
	 * [주문내역 toString]<br>
	 * 주문내역 조회를 위한 toSring입니다.<br>
	 * Date: 2021-08-07 , 20201-08-09
	 * @author 박인영
	 */
	@Override
	public String toString() {
		String deliveryCheck;
		int time;
		if (deliveryInfo.isDeliveryCheck() == true) {
			deliveryCheck = "배달\r\n　　배달주소: " + ((Member)personInfo).getAdress()  + "호";
			time = deliveryInfo.getDeliveryTime();
		}	
		else {
			deliveryCheck = "픽업";
			time = deliveryInfo.getOrderMakingTime();
		}
		return "==============================================================\r\n" +
			   "　　주문코드: " + getOrderCode() + "\r\n" +
			   "　　주문메뉴: " + getOrderMenus() +"\r\n" + 
			   "　　주문방식: " + deliveryCheck + "\r\n" +
			   deliveryCheck.substring(0,2) + "소요시간: " + time + "분\r\n" +
			   "　총결제금액: " + paymentInfo.getTotalPayment() + "원\r\n" +
			   "==============================================================";
	}


	
}
