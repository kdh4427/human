package cafe.vo;

import java.util.List;

public class Payment {

/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [총결제금액] (단위: 원)<br>
	 * 주문자가 결제할 금액입니다.<br>
	 * 카드로도 결제할 수 있고, 마일리지로도 결제할 수 있기 때문에,<br>
	 * 총결제금액이라는 용어를 씁니다.<br>
	 * 이 값은 장바구니에 담긴 메뉴별 menuPrice를 합한 값입니다.<br>
	 */
	private int totalPayment;
	
	/**
	 * [카드결제금액] (단위: 원)<br>
	 * 총결제금액 중 카드로 결제한 금액입니다.<br>
	 * 마일리지로 결제하지 않는 경우,<br>
	 * 총결제금액과 카드결제금액은 일치합니다.<br>
	 */
	private int cardPayment;
	
	/**
	 * [마일리지결제금액] (단위: 원)<br>
	 * 총결제금액 중 마일리지로 결제한 금액입니다.<br>
	 * 총결제금액에서 마일리지결제금액을 뺀 금액이 카드결제금액이 됩니다.<br>
	 * 마일리지결제금액 만큼이 멤버의 기존 마일리지에서 차감되어야 합니다.
	 */
	private int mileagePayment;
	
	/**
	 * [마일리지적립%] (단위: %)<br>
	 * 카드결제금액 중 마일리지로 적립되는 %입니다.<br>
	 */
	private int savePercent = 10;
	
	/**
	 * [적립마일리지] (단위: 원)<br>
	 * 적립되는 마일리지입니다.<br>
	 * 적립마일리지 = 카드결제금액 * 적립%<br>
	 * 적립마일리지는 멤버의 기존 마일리지에 더해집니다.
	 */
	private int saveMileage;
	
	
	/* ------------------------------ 생성자 ------------------------------ */	
	
	/**
	 * 결제 클래스 기본 생성자
	 */
	public Payment() {}
	
	public Payment(List<Cart> cart, int mileagePayment) {
		this.totalPayment = calculateTotalPayment(cart);
		this.cardPayment = totalPayment - mileagePayment;
		this.mileagePayment = mileagePayment;
		this.saveMileage = calculateSaveMileage();
	}
	
	/* ------------------------------ getter&setter ------------------------------ */	

	/**
	 * [총결제금액 반환하기]<br>
	 * 총결제금액(단위: 원)이란 주문자가 결제할 금액입니다.<br>
	 * 카드로도 결제할 수 있고, 마일리지로도 결제할 수 있기 때문에,<br>
	 * 총결제금액이라는 용어를 씁니다.<br>
	 * 이 값은 장바구니에 담긴 메뉴별 menuPrice를 합한 값입니다.<br>
	 * @return totalPayment 총결제금액
	 */
	public int getTotalPayment() {
		return totalPayment;
	}

	/**
	 * [총결제금액 입력하기]<br>
	 * 총결제금액(단위: 원)이란 주문자가 결제할 금액입니다.<br>
	 * 카드로도 결제할 수 있고, 마일리지로도 결제할 수 있기 때문에,<br>
	 * 총결제금액이라는 용어를 씁니다.<br>
	 * 이 값은 장바구니에 담긴 메뉴별 menuPrice를 합한 값입니다.<br>
	 * @param totalPayment 총결제금액
	 */
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	
	/**
	 * [카드결제금액 반환하기]<br>
	 * 카드결제금액(단위: 원)이란 총결제금액 중 카드로 결제한 금액입니다.<br>
	 * 마일리지로 결제하지 않는 경우,<br>
	 * 총결제금액과 카드결제금액은 일치합니다.<br>
	 * @return cardPayment 카드결제금액
	 */
	public int getCardPayment() {
		return cardPayment;
	}

	/**
	 * [카드결제금액 입력하기]<br>
	 * 카드결제금액(단위: 원)이란 총결제금액 중 카드로 결제한 금액입니다.<br>
	 * 마일리지로 결제하지 않는 경우,<br>
	 * 총결제금액과 카드결제금액은 일치합니다.<br>
	 * @param cardPayment 카드결제금액
	 */
	public void setCardPayment(int cardPayment) {
		this.cardPayment = cardPayment;
	}

	/**
	 * [마일리지결제금액 반환하기]<br>
	 * 마일리지결제금액(단위: 원)이란 총결제금액 중 마일리지로 결제한 금액입니다.<br>
	 * 총결제금액에서 마일리지결제금액을 뺀 금액이 카드결제금액이 됩니다.<br>
	 * 마일리지결제금액 만큼이 멤버의 기존 마일리지에서 차감되어야 합니다.
	 * @return mileagePayment 마일리지결제금액
	 */
	public int getMileagePayment() {
		return mileagePayment;
	}

	/**
	 * [마일리지결제금액 입력하기]<br>
	 * 마일리지결제금액(단위: 원)이란 총결제금액 중 마일리지로 결제한 금액입니다.<br>
	 * 총결제금액에서 마일리지결제금액을 뺀 금액이 카드결제금액이 됩니다.<br>
	 * 마일리지결제금액 만큼이 멤버의 기존 마일리지에서 차감되어야 합니다.
	 * @param mileagePayment 마일리지결제금액
	 */
	public void setMileagePayment(int mileagePayment) {
		this.mileagePayment = mileagePayment;
	}

	/**
	 * [마일리지적립% 반환하기]<br>
	 * 마일리지적립%는 카드결제금액 중 마일리지로 적립되는 %입니다.<br>
	 * @return savePercent 마일리지적립%
	 */
	public int getSavePercent() {
		return savePercent;
	}

	/**
	 * [마일리지적립% 반환하기]<br>
	 * 마일리지적립%는 카드결제금액 중 마일리지로 적립되는 %입니다.<br>
	 * @param savePercent 마일리지적립%
	 */
	public void setSavePercent(int savePercent) {
		this.savePercent = savePercent;
	}

	/**
	 * [적립마일리지 반환하기]<br>
	 * 적립마일리지(단위: 원)란 적립되는 마일리지입니다.<br>
	 * 적립마일리지 = 카드결제금액 * 적립%<br>
	 * 적립마일리지는 멤버의 기존 마일리지에 더해집니다.
	 * @return saveMileage 적립마일리지
	 */
	public int getSaveMileage() {
		return saveMileage;
	}

	/**
	 * [적립마일리지 입력하기]<br>
	 * 적립마일리지(단위: 원)란 적립되는 마일리지입니다.<br>
	 * 적립마일리지 = 카드결제금액 * 적립%<br>
	 * 적립마일리지는 멤버의 기존 마일리지에 더해집니다.
	 * @param saveMileage 적립마일리지
	 */
	public void setSaveMileage(int saveMileage) {
		this.saveMileage = saveMileage;
	}
	
	
	/* ------------------------------ 메서드 ------------------------------ */
	
	/**
	 * [총결제금액 계산하기]<br>
	 * 총결제금액(단위: 원)이란 주문자가 결제할 금액을 계산합니다.<br>
	 * 장바구니에 있는 메뉴별 결제금액을 총결제금액에 더합니다.<br>
	 * 멤버의 경우 이 값을 일부 마일리로 결제하고 나머지 금액을 카드로 결제해야 하지만<br>
	 * 회원의 경우 이 값을 전부 카드로 결제해야 합니다.
	 * @param cart 장바구니리스트
	 * @return totalPayment 총결제금액
	 */
	public int calculateTotalPayment(List<Cart> cart) {
		for (int i = 0; i < cart.size(); i++) {
			totalPayment += cart.get(i).getPaymentPrice();
		}
		return totalPayment;
	}

	/**
	 * [적립마일리지 계산하기]<br>
	 * 적립될 마일리지를 계산합니다.<br>
	 * 카드결제금액에 마일리지 적립% 만큼을 곱해줍니다.
	 * @return saveMileage 적립마일리지
	 */
	public int calculateSaveMileage() {
		saveMileage = getCardPayment() / getSavePercent();
		return saveMileage;
	}
	
}
