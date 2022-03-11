package cafe.vo;

/**
 * 메뉴 클래스<br><br>
 * Date: 2021-07-30
 * @author 박인영
 */
public class Menu {

	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [메뉴코드]<br>
	 * 메뉴의 고유번호 입니다.<br><br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	private int menuCode;
	
	/**
	 * [메뉴명]<br>
	 * 메뉴의 이름입니다.<br><br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	private String menuName;
	
	/**
	 * [가격] (단위: 원)<br>
	 * 음료의 가격입니다.<br><br>
	 * Date: 2021-07-31
	 * @author 박인영
	 */
	private int menuPrice;
	
	/**
	 * [공급량] (단위: 개)<br>
	 * 카페에서 제조 가능한 메뉴의 갯수입니다.<br>
	 * 공급량은 초기화되는 일일 제조 가능 갯수가 아닌,<br>
	 * 재료를 공급받을 때마다 이전의 공급량에<br>
	 * 추가된 제조 가능한 갯수를 합산하는 누적값입니다.<br><br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	private int supply;
	
	/**
	 * [판매량] (단위: 개)<br>
	 * 메뉴가 판매된 수량의 합입니다.<br>
	 * 판매량은 일일 판매량이 아닌,<br>
	 * 메뉴가 처음 추가되었을 때부터 현재까지 누적된 판매량입니다.<br>
	 * 이 값을 이용해 어떤 메뉴가 인기가 있는지,<br>
	 * 어떤 메뉴가 판매가 저조한지 파악하여 메뉴 개선을 할 수 있습니다.<br><br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	private int demand;
	
	/**
	 * [주문가능수량] (단위: 개)<br>
	 * 공급량에서 판매량을 뺀 주문이 가능한 수량입니다.<br>
	 * 메뉴를 주문할 때 주문가능수량을 초과하여 주문할 수 없습니다.<br><br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	private int orderableCount;
	
	
	/* ------------------------------ 생성자 ------------------------------ */
	
	/**
	 * 메뉴 클래스의 기본 생성자<br><br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	public Menu() {}

	/**
	 * 메뉴 클래스의 생성자<br><br>
	 * Date: 2021-07-30
	 * @param menuCode 메뉴코드
	 * @param menuName 메뉴명
	 * @param menuPrice 가격
	 * @param supply 공급량 (단위: 개)
	 * @author 박인영
	 */
	public Menu(int menuCode, String menuName, int menuPrice, int supply) {
		this.menuCode = menuCode;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.supply = supply;
		this.orderableCount += supply;
	}


	/* ------------------------------ getter & setter ------------------------------ */
	
	/**
	 * 메뉴코드 반환하기<br><br>
	 * Date: 2021-07-30
	 * @return menuCode 메뉴코드
	 * @author 박인영
	 */
	public int getMenuCode() {
		return menuCode;
	}

	/**
	 * 메뉴코드 입력하기<br><br>
	 * Date: 2021-07-30
	 * @param menuCode 메뉴코드
	 * @author 박인영
	 */
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	/**
	 * 메뉴명 반환하기<br><br>
	 * Date: 2021-07-30
	 * @return menuName 메뉴명
	 * @author 박인영
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * 메뉴명 입력하기<br><br>
	 * Date: 2021-07-30
	 * @param menuName 메뉴명
	 * @author 박인영
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * 가격 반환하기<br><br>
	 * Date: 2021-07-30
	 * @return menuPrice 가격
	 * @author 박인영
	 */
	public int getMenuPrice() {
		return menuPrice;
	}
	
	/**
	 * 가격 입력하기<br><br>
	 * Date: 2021-07-31
	 * @param menuPrice 가격
	 * @author 박인영
	 */
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	/**
	 * 공급량 반환하기<br><br>
	 * Date: 2021-07-30
	 * @return supply 공급량
	 * @author 박인영
	 */
	public int getSupply() {
		return supply;
	}

	/**
	 * 공급량 입력하기<br><br>
	 * Date: 2021-07-30
	 * @param supply 공급량
	 * @author 박인영
	 */
	public void setSupply(int supply) {
		this.supply = supply;
	}

	/**
	 * 판매량 반환하기<br><br>
	 * Date: 2021-07-30
	 * @return demand 판매량
	 * @author 박인영
	 */
	public int getDmand() {
		return demand;
	}

	/**
	 * 판매량 입력하기<br><br>
	 *Date: 2021-07-30
	 * @param demand 판매량
	 * @author 박인영
	 */
	public void setDemand(int demand) {
		this.demand = demand;
		this.orderableCount -= demand;
	}
	
	/**
	 * 주문가능수량 반환하기<br><br>
	 * Date: 2021-07-30
	 * @return orderableCount 주문가능수량
	 * @author 박인영
	 */
	public int getOrderableCount() {
		return orderableCount;
	}

	/**
	 * 주문가능수량 입력하기<br><br>
	 * Date: 2021-07-31
	 * @param orderableCount 주문가능수량
	 * @author 박인영
	 */
	public void setOrderableCount(int orderableCount) {
		this.orderableCount = orderableCount;
	}
	
	
	/* ------------------------------ 메서드 ------------------------------ */
	
	public void putSupply(int supply) {
		this.supply += supply;
		this.orderableCount += supply;
	}
	
	public void putDemand(int demand) {
		this.demand += demand;
		this.orderableCount -= demand;
	}	
	
}
