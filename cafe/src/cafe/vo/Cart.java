package cafe.vo;

import java.util.List;

import cafe.service.ManagerServiceImpl;

/**
 * [장바구니 클래스]<br>
 * 주문하려는 상품과 그 갯수를 담는 장바구니 클래스 입니다.<br>
 * Date: 2021-07-28
 * @author 윤인호
 */
public class Cart {
	
	private List<Menu> menus = ManagerServiceImpl.getMenus();
	
	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [메뉴코드]<br>
	 * 장바구니에 담는 메뉴의 고유 코드입니다.<br>
	 * 이 번호는 메뉴리스트에 담긴 메뉴의 코드와 일치합니다.<br>
	 * Date: 2021-07-28
	 * @author 윤인호
	 */
	private int menuCode;
	
	/**
	 * [메뉴이름]<br>
	 * 장바구니에 담는 메뉴의 이름입니다.<br>
	 * 이 이름은 메뉴리스트에 담긴 메뉴의 이름과 일치합니다.<br>
	 * Date: 2021-08-03
	 * @author 박인영
	 */
	private String menuName;
	
	/**
	 * [주문수량]<br>
	 * 장바구니에 담는 메뉴별 갯수입니다.<br>
	 * 이 갯수는 주문가능수량을 초과할 수 없습니다.<br>
	 * Date: 2021-07-28
	 * @author 윤인호
	 */
	private int orderCount;
	
	/**
	 * [결제금액]<br>
	 * 장바구니에 담는 메뉴별 주문수량이 반영된 금액입니다.<br>
	 * 결제금액 = 메뉴의 가격 * 주문수량<br>
	 * Date: 2021-08-08
	 * @author 박인영
	 */
	private int paymentPrice;

	
	/* ------------------------------ 생성자 ------------------------------ */	
	
	/**
	 * 장바구니 클래스의 기본 생성자<br>
	 * Date: 2021-07-28
	 * @author 윤인호
	 */
	public Cart() {}
	
	/**
	 * 장바구니 클래스 생성자<br>
	 * Date: 2021-08-08
	 * @param menuCode 메뉴코드
	 * @param orderCount
	 * @author 박인영
	 */
	public Cart(int menuCode, int orderCount) {
		this.menuCode = menuCode;
		for (int i = 0; i < menus.size(); i++) {
			if(menuCode == menus.get(i).getMenuCode())
				this.menuName = menus.get(i).getMenuName();
		}
		this.orderCount = orderCount;
		for (int i = 0; i < menus.size(); i++) {
			if(menuCode == menus.get(i).getMenuCode())
				this.paymentPrice = menus.get(i).getMenuPrice() * orderCount;
		}
	}
	
	public Cart(int menuCode, String menuName, int orderCount, int paymentPrice) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.orderCount = orderCount;
		this.paymentPrice = paymentPrice;
	}
	

	/* ------------------------------ getter & setter ------------------------------ */
	
	/**
	 * 메뉴코드 반환하기<br>
	 * Date: 2021-07-28 
	 * @return menuCode 메뉴코드
	 * @author 윤인호
	 */
	public int getMenuCode() {
		return menuCode;
	}
	
	/**
	 * 메뉴코드 입력하기<br>
	 * Date: 2021-07-28
	 * @param menuCode 메뉴코드
	 * @author 윤인호
	 */
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * 메뉴이름 반환하기<br>
	 * Date: 2021-08-03 
	 * @return menuName 메뉴이름
	 * @author 박인영
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * 메뉴이름 입력하기<br>
	 * Date: 2021-08-03
	 * @param menuName 메뉴이름
	 * @author 박인영
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	/**
	 * 주문수량 반환하기<br>
	 * Date: 2021-07-28
	 * @return orderCount 주문수량
	 * @author 윤인호
	 */
	public int getOrderCount() {
		return orderCount;
	}

	/**
	 * 주문수량 입력하기<br>
	 * Date: 2021-07-28
	 * @param orderCount 주문수량
	 * @author 윤인호
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	/**
	 * 결제금액 반환하기<br>
	 * Date: 2021-08-08 
	 * @return paymentPrice 결제금액
	 * @author 박인영
	 */
	public int getPaymentPrice() {
		return paymentPrice;
	}

	/**
	 * 결제금액 입력하기<br>
	 * Date: 2021-08-08 
	 * @param paymentPrice 결제금액
	 * @author 박인영
	 */
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	
}
