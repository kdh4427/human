package cafe.vo;

import java.util.List;

public class DeliveryTime {

	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [기본제조시간] (단위: 분)<br>
	 * 음료를 제조하기 전에 기본적인 업무로 인하여 필요한 시간입니다.<br>
	 * 기본적인 업무라 함은 주문확인, 메뉴파악, 배달/픽업 확인 등이 있습니다.<br>
	 * 기본제조시간은 3분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	private int basicMakingTime = 3;

	/**
	 * [총주문수량] (단위: 개)<br>
	 * 장바구니에 담긴 메뉴들의 총 수량입니다.<br>
	 * 총주문수량 = 메뉴1 주문수량 + 메뉴2 주문수량 + ...<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @author 박인영 
	 */
	private int totalOrderCount;
	
	/**
	 * [음료제조시간] (단위: 분)<br>
	 * 한 개의 음료를 제조하는데 걸리는 평균시간입니다.<br>
	 * 음료제조시간은 2분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	private int menuMakingTime = 2;
	
	/**
	 * [주문제조시간]<br>
	 * 주문 한 건의 모든 음료를 제조하는데 걸리는 시간입니다.<br>
	 * 이 값은 픽업가능시간이기도 하며,<br>
	 * 예상배달시간을 계산하는데 사용됩니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층수별배달시간<br>
	 * Date: 2021-08-09
	 * @author 박인영
	 */
	private int orderMakingTime;
	
	/**
	 * [배달셋팅시간] (단위: 분)<br>
	 * 한 건의 배달을 준비하는데 걸리는 시간입니다.<br>
	 * 배달 준비 과정에는 포장 및 배달직원의 준비 등이 있습니다.<br>
	 * 배달셋팅시간은 5분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 예상배달시간을 계산합니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층수별배달시간<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	private int deliveryTimeSetting = 5;
	
	/**
	 * [층별배달시간] (단위: 분)<br>
	 * 주문자가 멤버인 경우 사무실로 배달이 가능하며,<br>
	 * 높은 층수의 사무실일수록 배달시간이 더 길어져야 합니다.<br>
	 * 배달주소가 1~3층이면 1분, 4~6층이면 2분, 7~9층이면 3분의 시간이 필요합니다.<br>
	 * 위과 같은 기준으로 층별배달시간을 계산하고<br>
	 * 이 값을 이용해 예상배달시간을 계산합니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	private int deliveryTimeFloor;
	
	/**
	 * [예상배달시간] (단위: 분)<br>
	 * 멤버가 배달 방식을 주문하는 경우,<br>
	 * 결제완료 후 부터 배달이 완료되기 까지의 예상 시간입니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-09
	 * @author 박인영
	 */
	private int deliveryTime;
	
	/**
	 * [배달 여부]<br>
	 * 주문자가 멤버인 경우 배달과 픽업을 선택할 수 있으며,<br>
	 * 그 선택이 해당 멤버변수에 저장됩니다.<br>
	 * 이 값은 주문내역 조회시 배달주문건이었는지 픽업주문건이었는지 확인하는데 사용됩니다.<br>
	 * 저장되는 기본값 false는 픽업주문 건이며, true가 저장된 경우 배달주문건입니다.<br>
	 * Date: 2021-08-07
	 * @author 박인영
	 */
	private boolean deliveryCheck;
	
	
	/* ------------------------------ 생성자 ------------------------------ */
	
	/**
	 * 배달시간 클래스의 기본 생성자<br><br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	public DeliveryTime() {}
	
	public DeliveryTime(List<Cart> cart, String adress, boolean deliveryCheck) {
		this.totalOrderCount = calculateMakingTime(cart);
		this.orderMakingTime = basicMakingTime + totalOrderCount * menuMakingTime;
		this.deliveryTime = calculateDeliveryTime(cart, adress);
		this.deliveryCheck = deliveryCheck;
	}
	
	/* ------------------------------ getter&setter ------------------------------ */
	
	/**
	 * [기본제조시간 반환하기]<br>
	 * 기본제조시간은 음료를 제조하기 전에 기본적인 업무로 인하여 필요한 시간입니다.<br>
	 * 기본적인 업무라 함은 주문확인, 메뉴파악, 배달/픽업 확인 등이 있습니다.<br>
	 * 기본제조시간은 3분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	public int getBasicMakingTime() {
		return basicMakingTime;
	}
	
	/**
	 * [기본제조시간 입력하기]<br>
	 * 기본제조시간은 음료를 제조하기 전에 기본적인 업무로 인하여 필요한 시간입니다.<br>
	 * 기본적인 업무라 함은 주문확인, 메뉴파악, 배달/픽업 확인 등이 있습니다.<br>
	 * 기본제조시간은 3분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @param basicMakingTime 기본제조시간
	 * @author 박인영
	 */
	public void setBasicMakingTime(int basicMakingTime) {
		this.basicMakingTime = basicMakingTime;
	}
	
	/**
	 * [총주문수량 반환하기] (단위: 개)<br>
	 * 총주문수량은 장바구니에 담긴 메뉴들의 총 수량입니다.<br>
	 * 총주문수량 = 메뉴1 주문수량 + 메뉴2 주문수량 + ...<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @return totalOrderCount 총주문수량
	 * @author 박인영
	 */
	public int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	/**
	 * [총주문수량 입력하기] (단위: 개)<br>
	 * 총주문수량은 장바구니에 담긴 메뉴들의 총 수량입니다.<br>
	 * 총주문수량 = 메뉴1 주문수량 + 메뉴2 주문수량 + ...<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @param totalOrderCount 총주문수량
	 * @author 박인영 
	 */
	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}
	
	/**
	 * [음료제조시간 반환하기] (단위: 분)<br>
	 * 음료제조시간은 한 개의 음료를 제조하는데 걸리는 평균시간입니다.<br>
	 * 음료제조시간은 2분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @return MenuMakingTime 음료제조시간
	 * @author 박인영
	 */
	public int getMenuMakingTime() {
		return menuMakingTime;
	}
	
	/**
	 * [음료제조시간 입력하기] (단위: 분)<br>
	 * 음료제조시간은 한 개의 음료를 제조하는데 걸리는 평균시간입니다.<br>
	 * 음료제조시간은 2분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 제조시간을 계산합니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @param MenuMakingTime 음료제조시간
	 * @author 박인영
	 */
	public void setMenuMakingTime(int MenuMakingTime) {
		this.menuMakingTime = MenuMakingTime;
	}
	
	/**
	 * [주문제조시간 반환하기]<br>
	 * 주문제조시간이란 주문 한 건의 모든 음료를 제조하는데 걸리는 시간입니다.<br>
	 * 이 값은 픽업가능시간이기도 하며,<br>
	 * 예상배달시간을 계산하는데 사용됩니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층수별배달시간<br>
	 * Date: 2021-08-09
	 * @return orderMakingTime 주문제조시간
	 * @author 박인영
	 */
	public int getOrderMakingTime() {
		return orderMakingTime;
	}

	/**
	 * 	/**
	 * [주문제조시간 입력하기]<br>
	 * 주문제조시간이란 주문 한 건의 모든 음료를 제조하는데 걸리는 시간입니다.<br>
	 * 이 값은 픽업가능시간이기도 하며,<br>
	 * 예상배달시간을 계산하는데 사용됩니다.<br>
	 * 주문제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층수별배달시간<br>
	 * Date: 2021-08-09
	 * @param orderMakingTime 주문제조시간
	 * @author 박인영
	 */
	public void setOrderMakingTime(int orderMakingTime) {
		this.orderMakingTime = orderMakingTime;
	}

	/**
	 * [배달셋팅시간 반환하기] (단위: 분)<br>
	 * 배달셋팅시간은 한 건의 배달을 준비하는데 걸리는 시간입니다.<br>
	 * 배달 준비 과정에는 포장 및 배달직원의 준비 등이 있습니다.<br>
	 * 배달셋팅시간은 5분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 예상배달시간을 계산합니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층수별배달시간<br>
	 * Date: 2021-08-05
	 * @return deliverySettingTime 배달셋팅시간
	 * @author 박인영
	 */
	public int getDeliveryTimeSetting() {
		return deliveryTimeSetting;
	}
	
	/**
	 * [배달셋팅시간 입력하기] (단위: 분)<br>
	 * 배달셋팅시간은 한 건의 배달을 준비하는데 걸리는 시간입니다.<br>
	 * 배달 준비 과정에는 포장 및 배달직원의 준비 등이 있습니다.<br>
	 * 배달셋팅시간은 5분이 초기값으로 저장되어 있습니다.<br>
	 * 이 값을 이용해 예상배달시간을 계산합니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층수별배달시간<br>
	 * Date: 2021-08-05
	 * @param deliverySettingTime 배달셋팅시간
	 * @author 박인영
	 */
	public void setDeliveryTimeSetting(int deliverySettingTime) {
		this.deliveryTimeSetting = deliverySettingTime;
	}
	
	/**
	 * [층별배달시간 반환하기] (단위: 분)<br>
	 * 주문자가 멤버인 경우 사무실로 배달이 가능하며,<br>
	 * 높은 층수의 사무실일수록 배달시간이 더 길어져야 합니다.<br>
	 * 배달주소가 1~3층이면 1분, 4~6층이면 2분, 7~9층이면 3분의 시간이 필요합니다.<br>
	 * 위과 같은 기준으로 층별배달시간을 계산하고<br>
	 * 이 값을 이용해 예상배달시간을 계산합니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-05
	 * @return eliveryfloorTime 배달층수
	 * @author 박인영
	 */
	public int getDeliveryTimeFloor() {
		return deliveryTimeFloor;
	}
	
	/**
	 * [층별배달시간 입력하기] (단위: 분)<br>
	 * 주문자가 멤버인 경우 사무실로 배달이 가능하며,<br>
	 * 높은 층수의 사무실일수록 배달시간이 더 길어져야 합니다.<br>
	 * 배달주소가 1~3층이면 1분, 4~6층이면 2분, 7~9층이면 3분의 시간이 필요합니다.<br>
	 * 위과 같은 기준으로 층별배달시간을 계산하고<br>
	 * 이 값을 이용해 예상배달시간을 계산합니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-05
	 * @param floorDeliveryTime 배달층수
	 * @author 박인영
	 */
	public void setDeliveryTimeFloor(int deliveryTimeFloor) {
		this.deliveryTimeFloor = deliveryTimeFloor;
	}
	
	/**
	 * [예상배달시간 반환하기]<br>
	 * 예상배달시간(단위: 분)이란 멤버가 배달 방식을 주문하는 경우,<br>
	 * 결제완료 후 부터 배달이 완료되기 까지의 예상 시간입니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-09
	 * @return deliveryTime 예상배달시간
	 * @author 박인영
	 */
	public int getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * [예상배달시간 입력하기]<br>
	 * 예상배달시간(단위: 분)이란 멤버가 배달 방식을 주문하는 경우,<br>
	 * 결제완료 후 부터 배달이 완료되기 까지의 예상 시간입니다.<br>
	 * 예상배달시간 = 주문제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-09
	 * @param deliveryTime 예상배달시간
	 * @author 박인영
	 */
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	/**
	 * [배달여부 반환하기]<br>
	 * 주문자가 멤버인 경우 배달과 픽업을 선택할 수 있으며,<br>
	 * 그 선택이 해당 멤버변수에 저장됩니다.<br>
	 * 이 값은 주문내역 조회시 배달주문건이었는지 픽업주문건이었는지 확인하는데 사용됩니다.<br>
	 * 저장되는 기본값 false는 픽업주문 건이며, true가 저장된 경우 배달주문건입니다.<br>
	 * Date: 2021-08-07
	 * @return deliveryCheck
	 * @author 박인영
	 */
	public boolean isDeliveryCheck() {
		return deliveryCheck;
	}

	/**
	 * [배달여부 입력하기]<br>
	 * 주문자가 멤버인 경우 배달과 픽업을 선택할 수 있으며,<br>
	 * 그 선택이 해당 멤버변수에 저장됩니다.<br>
	 * 이 값은 주문내역 조회시 배달주문건이었는지 픽업주문건이었는지 확인하는데 사용됩니다.<br>
	 * 저장되는 기본값 false는 픽업주문 건이며, true가 저장된 경우 배달주문건입니다.<br>
	 * Date: 2021-08-07
	 * @param deliveryCheck
	 * @author 박인영
	 */
	public void setDeliveryCheck(boolean deliveryCheck) {
		this.deliveryCheck = deliveryCheck;
	}

	
	/* ------------------------------ 메서드 ------------------------------ */

	/**
	 * [주문제조시간] (단위: 분)<br>
	 * 한 건의 주문에 있는 메뉴를 완성하는데 걸리는 시간입니다.<br>
	 * 배달주문이 아닌 픽업주문인 경우,<br>
	 * 제조시간이 곧 픽업가능시간이 됩니다.<br>
	 * 제조시간 = 기본제조시간 + (총주문수량 * 음료제조시간)<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	public int calculateMakingTime(List<Cart> cart) {
		for (int i = 0; i < cart.size(); i++)
			totalOrderCount += cart.get(i).getOrderCount();
		setOrderMakingTime(basicMakingTime + totalOrderCount * menuMakingTime);
		return getOrderMakingTime();
	}
	
	/**
	 * [예상배달시간]<br>
	 * 주문시점부터 배달 완료될 때까지의 예상시간입니다.<br>
	 * 층별배달시간: 배달주소가 1~3층이면 1분, 4~6층이면 2분,<br>
	 * 　　　　　　　7~9층이면 3분의 시간이 필요합니다.<br>
	 * 예상배달시간 = 제조시간 + 배달셋팅시간 + 층별배달시간<br>
	 * Date: 2021-08-05
	 * @author 박인영
	 */
	public int calculateDeliveryTime(List<Cart> cart, String adress) {
		char floor = adress.charAt(0);
		if('1' <= floor && floor <= '3')
			deliveryTimeFloor = 1;
		else if('4' <= floor && floor <= '6')
			deliveryTimeFloor = 2;
		else if('7' <= floor && floor <= '9')
			deliveryTimeFloor = 3;
		setDeliveryTime(calculateMakingTime(cart) + deliveryTimeSetting + deliveryTimeFloor);
		return getDeliveryTime();
	}
	
}
