package cafe.service;

import java.util.List;

import cafe.vo.Cart;
import cafe.vo.Employee;
import cafe.vo.Menu;
import cafe.vo.Person;

public interface UserService {
	
	/* ------------------------------ findBy ------------------------------ */
	
	/**
	 * [결제카드 비밀번호 확인]<br>
	 * 파라메터로 입력된 결제카드 PW가 맞는지 확인합니다.<br>
	 * 초기화블럭으로 입력된 Person리스트에 저장된 결제카드 PW인지 확인합니다.<br>
	 * @param memberCardPW 멤버 결제카드 비밀번호
	 * @return members.get(i)
	 * Date : 2021-08-09
	 * @author 김동휘
	 */
	Person findCardPwBy(String pw);
	
	/**
	 * [ID 확인]<br>
	 * 파라메터로 입력된 멤버ID가 등록된 멤버ID가 맞는지 확인합니다.<br>
	 * 초기화블럭으로 입력된 멤버리스트에 저장된 ID인지 확인합니다.<br>
	 * @param memberID 멤버ID
	 * @return members.get(i)
	 */
	Person findPersonBy(String id);
	
	/**
	 * [사원 확인]<br>
	 * 파라메터로 입력되는 멤버ID가 사원ID가 맞는지 확인합니다.<br>
	 * ManagerServiceImpl에서 초기화블럭으로 입력된 사원리스트에 저장된 ID인지 확인합니다.<br>
	 * @param memberID 멤버ID
	 * @return employees.get(i)
	 */
	Employee findEmployeeBy(String id);
	
	/**
	 * [메뉴 확인]<br>
	 * 파라메터로 입력되는 메뉴코드가 메뉴리스트에 존재하는지 확인합니다.<br>
	 * Date: 2021-07-29
	 * @param menuCode 메뉴코드
	 * @return carts.get(i)
	 * @author 김동휘
	 */
	Menu findMenuBy(int menuCode);
	
	/**
	 * [장바구니 메뉴 확인]<br>
	 * 파라메터로 입력되는 메뉴코드가 장바구니에 담겨있는지 확인합니다.<br>
	 * Date: 2021-08-05
	 * @param menuCode
	 * @return
	 * @author 김동휘
	 */
	Cart findCartBy(int menuCode);
	
	/**
	 * [결제 카드번호 확인]<br>
	 * 주문완료 후 결제할 때<br>
	 * 등록된 카드번호와 입력한 카드번호가<br>
	 * 일치하는지 확인하는 기능<br>
	 * Date: 2021-08-08
	 * @author 김동휘
	 */
	Person findCardBy(String cardNum);
	
	
	/* ------------------------------ 로그인 ------------------------------ */
	
	/**
	 * [로그인하기]<br>
	 * 사내 카페의 Online Order Service를 통해 주문하려면 로그인을 해야 합니다.<br>
	 * 가입이 안된 경우 회원가입을 해야 합니다.<br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	void login();
	
	/**
	 * [멤버로그인]<br>
	 * 사원분들 중 회원가입을 통해 등록한 멤버의 로그인입니다.<br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	void personLogin();
	
	/**
	 * [회원로그인]<br>
	 * 사원이 아닌 분들 중 회원가입을 통해 등록한 회원의 로그인입니다.<br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
//	void userLogin();
	
	
	/* ------------------------------ 멤버등록 및 회원가입 ------------------------------ */
	
	/**
	 * [멤버등록 및 회원가입]<br>
	 * Online Order Service를 이용하려면<br>
	 * 사원은 멤버등록해야하며,<br>
	 * 비사원은 회원가입해야합니다.<br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	void addPerson();
	
	/**
	 * [멤버등록]<br>
	 * 사원이 Online Order Service를 이용하려면 멤버로 등록해야 합니다.<br>
	 * 사원ID를 조회하여 이름, 연락처, 부서호수를 불러올 수 있습니다.<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	void addMember();
	
	/**
	 * [회원가입]<br>
	 * 사원이 아닌 분들이 Online Order Service를 이용하려면 회원으로 가입합니다.<br>
	 * Date: 2021-07-29
	 * @author 윤인호,박인영,김동휘,주현준
	 */
	void addUser();
	
	// [결제카드 비밀번호 숫자 4자리 사용 확인]
	public String checkCardPw(String cardPw);
	
	/**
	 * [ID 적합여부 검사]<br>
	 * 회원가입시 아이디가 영어 소문자와 숫자로만 이루어져있는지 확인합니다.<br>
	 * Date: 2021-08-06
	 * @author 박인영
	 */
	String checkUserID(String userID);
	
	
	/* ------------------------------ 멤버 및 회원 메뉴 ------------------------------ */
	
	/**
	 * [멤버 및 회원 메뉴]<br>
	 * 멤버와 회원이 등록된 정보를 조회하고 수정합니다.<br>
	 * 또한 주문내역을 조회할 수 있습니다.<br>
	 * Date: 2021-07-31
	 * @author 윤인호
	 */
	void personMenu();
	
	/**
	 * [멤버 메뉴]<br>
	 * 멤버의 정보를 조회/수정하고 주문내역을 조회합니다.<br>
	 * 배달서비스가 가능한 멤버의 경우,<br>
	 * 연락처, 배달주소, 결제카드 정보를 조회/수정할 수 있으며,<br>
	 * 적립된 마일리지 또한 조회가 가능합니다.<br>
	 * Date: 2021-07-31, 2021-08-06
	 * @author 김동휘, 박인영
	 */
	void memeberMenu();
	
	/**
	 * [회원 메뉴]<br>
	 * 회원의 정보를 조회/수정하고 주문내역을 조회합니다.<br>
	 * KIKIO 사원이 아닌 회원의 경우,<br>
	 * 연락처, 결제카드 정보를 조회/수정할 수 있습니다.<br>
	 * Date: 2021-07-31, 2021-08-06
	 * @author 김동휘, 박인영
	 */
	void userMenu();
	
	/**
	 * [멤버 등록정보 조회]<br>
	 * 멤버의 등록된 정보를 조회합니다.<br>
	 * 조회 가능 정보: 멤버ID, 멤버이름, 멤버연락처, 배달호수, 결제카드정보<br>
	 * Date: 2021-08-01
	 * @author 김동휘
	 */
	void listMember();
	
	/**
	 * [회원 등록정보 조회]<br>
	 * 회원의 등록된 정보를 조회합니다.<br>
	 * 조회 가능 정보: 회원ID, 회원이름, 회원연락처, 결제카드정보<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	void listUser();
	
	/**
	 * [멤버 등록정보 수정]<br>
	 * 등록된 멤버의 정보를 수정합니다.<br>
	 * 수정 가능 정보: 멤버연락처, 배달호수, 결제카드정보<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	public void modifyMember();
	
	/**
	 * [회원 등록정보 수정]<br>
	 * 등록된 회원의 정보를 수정합니다.<br>
	 * 수정 가능 정보: 회원연락처, 결제카드정보<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	void modifyUser();
	
	/* ------------------------------ 주문하기 [1] 장바구니에 담기 ------------------------------ */
	
	/**
	 * [주문하기]<br>
	 * 메뉴조회 → 장바구니에 메뉴 담기 → 픽업/배달 선택<br>
	 *  →→ 배달 선택시 주소지와 배달예상시간 확인 → 결제 → 주문완료<br>
	 *  →→ 픽업 선택시 픽업가능시간 확인 → 결제 → 주문완료<br>
	 * Date: 2021-07-29
	 * @author 김동휘 
	 */
	void order();
	
	/**
	 * [장바구니 담기]<br>
	 * 주문 전 메뉴리스트를 보여줍니다.<br>
	 * 주문을 원하는 메뉴의 메뉴코드를 선택한 후 주문수량을 입력합니다.<br> 
	 * 하단에 총주문수량과 총 결제금액을 보여줍니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	void addCart();
	
	/**
	 * [주문수량 유효성 검사]
	 * 장바구니에 담는 메뉴의 주문수량이 주문가능수량을 초과하지 않는지
	 * 주문이 불가능한 음수값을 입력하는지 확인합니다.
	 * 또한 장바구니에 같은 메뉴를 나누어 담을수 있기 때문에
	 * 같은 메뉴를 주문하는 주문수량의 합이 주문가능수량을 초과하지 않는지 확인합니다.
	 */
	boolean checkOrderCount(int menuCode, int orderCount);
	
	/**
	 * [메뉴리스트 조회]<br>
	 * 장바구니에 제품을 담을 때 참고할 수 있는 메뉴 리스트입니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	void listMenu();
	
	/**
	 * [장바구니 조회]<br>
	 * 장바구니에 담긴 메뉴를 조회합니다.<br>
	 * 해당 메뉴는 장바구니에 메뉴를 담을 때마다 조회됩니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	void listCart();
	
	/**
	 * [장바구니 메뉴 삭제]<br>
	 * 장바구니에 담긴 메뉴 중 주문을 원하지 않는 메뉴를 삭제할 수 있습니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	void removeCart();
	
	
	/* ------------------------------ 주문하기 [2] 배달/픽업 선택 ------------------------------ */
	
	/**
	 * [멤버의 배달/픽업 선택]<br>
	 * 멤버는 KIKIO 본사 사무실에 한하여 배달이 가능하기 때문에<br>
	 * 배달이용할지 픽업을 할지 선택한다.<br>
	 * Date: 2021-08-05
	 * @author 김동휘
	 * @return 
	 */
	boolean deliveryCheck();
	
	/**
	 * [회원의 픽업시간 안내]<br>
	 * 회원의 주문은 배달이 불가능하며, 직접 카운터에서 음료를 픽업해야 한다.<br>
	 * 음료가 만들어지는 예상시간을 안내하여<br>
	 * 시간 맞춰 매장에 방문할 수 있도록 안내한다.<br>
	 * Date: 2021-08-05
	 * @author 김동휘
	 * @return 
	 */
	boolean takeOutCheck();
	
	
	/* ------------------------------ 결제하기 ------------------------------ */
	
	/**
	 * [멤버의 결제하기]<br>
	 * 총 결제금액을 안내 후 등록된 카드로 결제합니다.<br>
	 * 카드결제금액에서 몇%의 마일리지가 적립되며,<br>
	 * 적립된 마일리지를 사용해 결제할 수 있습니다.<br>
	 * Date: 2021-08-08
	 * @author 김동휘
	 */
	public void memberPay();
	
	/**
	 * [회원의 결제하기]<br>
	 * 총 결제금액을 안내 후 등록된 카드로 결제합니다.<br>
	 * Date: 2021-08-08
	 * @author 김동휘
	 */
	public void userPay();
	
	
	/* ------------------------------ 주문하기 [4] 주문완료 ------------------------------ */
	
	/**
	 * [주문메뉴리스트 만들기]<br>
	 * 장바구니에 담긴 메뉴를 주문수량과 함께<br>
	 * 주문리스트의 orderMenus 변수에 저장하기 위한 메서드입니다.<br>
	 * 메뉴명(메뉴수량개) (ex. 아메리카노ICE(2개))<br>
	 * 이 값은 주문 내역을 조회할 때 사용됩니다.<br>
	 * Date: 2021-08-09
	 * @return orderMenus
	 * @author 박인영
	 */
	String makeOrderMenus(List<Cart> cart);
	
	/**
	 * [주문리스트 생성]
	 * 결제가 완료되면 주문리스트가 생성됩니다.
	 * Date:2021-08-07
	 * @author 박인영
	 */
	public void compliteOrder();
	
	
	/* ------------------------------ 주문조회 ------------------------------ */
	
	/**
	 * [멤버 주문 조회]<br>
	 * 멤버의 주문내역을 조회합니다.<br>
	 * Date: 2021-07-29, 2021-08-07
	 * @author 김동휘, 박인영
	 */
	void listMemberOrder();
	
	/**
	 * [회원 주문 조회]<br>
	 * 회원의 주문내역을 조회합니다.<br>
	 * Date: 2021-07-29, 2021-08-07
	 * @author 김동휘, 박인영
	 */
	void listUserOrder();

}
