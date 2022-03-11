package cafe.service;

import cafe.vo.Cart;
import cafe.vo.DeliveryTime;
import cafe.vo.Employee;
import cafe.vo.Member;
import cafe.vo.Menu;
import cafe.vo.Order;
import cafe.vo.Payment;
import cafe.vo.Person;
import cafe.vo.User;
import static cafe.util.CafeCommon.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
	
	private static List<Person> persons = new ArrayList<Person>();
	private List<Employee> employees = ManagerServiceImpl.getEmployees();
	private List<Menu> menus = ManagerServiceImpl.getMenus();
	private static List<Cart> cart = new ArrayList<Cart>();
	private static DeliveryTime deliveryTime = new DeliveryTime();
	private static Payment payment = new Payment();
	private static List<Order> orders = new ArrayList<Order>();
	Person person;
	
	
	/* ------------------------------ 초기화블럭 ------------------------------ */
	
	/**
	 * [임시 멤버 초기화 블럭]<br>
	 * 임시 멤버 등록을 초기화 블럭입니다.<br>
	 * 입력 가능한 정보 : 멤버ID, 멤버이름, 멤버연락처, 멤버비밀번호, 멤버카드, 멤버주소, 마일리지<br>
	 * Date: 2021-08-02
	 *  @author 박인영
	 */
	static {
		persons.add(new Member("K0001", "1111", "김연경", "010-1111-1111", "현대카드 1111-1111-1111-1111", "1111", "306", 10000));
		persons.add(new Member("K0002", "2222", "김정환", "010-2222-2222", "삼성카드 2222-2222-2222-2222", "2222", "402", 5000));
		persons.add(new Member("K0003", "3333", "신재환", "010-3333-3333", "국민카드 3333-3333-3333-3333", "3333", "501", 2000));
		persons.add(new Member("K0004", "4444", "강채영", "010-4444-4444", "신한카드 4444-4444-4444-4444", "4444", "603", 1000));
		persons.add(new Member("K0010", "1010", "이다빈", "010-1010-1010", "우리카드 5555-5555-5555-5555", "5555", "704", 500));
	}

	/**
	 * [임시 유저 초기화 블럭]<br>
	 * 임시 유저 등록을 위한 초기화 블럭입니다.<br>
	 * 입력 가능한 정보 : 유저ID, 유저이름, 유저연락처, 유저비밀번호, 유저카드, 유저주소<br>
	 * Date: 2021-08-02
	 * @author 박인영
	 */
	static {
		persons.add(new User("kjd", "0101", "김제덕", "010-0101-0101", "삼성카드 0101-0101-0101-0101", "0101"));
		persons.add(new User("ann", "0202", "안　산", "010-0202-0202", "신한카드 0202-0202-0202-0202", "0202"));
		persons.add(new User("kjh", "0303", "김준호", "010-0303-0303", "농협카드 0303-0303-0303-0303", "0303"));
		persons.add(new User("jmh", "0404", "장민희", "010-0404-0404", "현대카드 0404-0404-0404-0404", "0404"));
		persons.add(new User("kbg", "0505", "구본길", "010-0505-0505", "삼성카드 0505-0505-0505-0505", "0505"));
	}

	/**
	 * [임시 주문리스트 초기화 블럭]
	 * 멤버 및 회원의 주문내역 조회 및 관리자의 주문리스트, 매출리스트 조회를 위한 초기화블럭입니다.
	 * Date: 2021-08-10
	 * @author 박인영
	 */
	static {
		cart.add(new Cart(100, "아메리카노HOT", 3, 9000));
		cart.add(new Cart(200, "레몬에이드ICE", 2, 9000));
		deliveryTime = new DeliveryTime(cart, ((Member)persons.get(0)).getAdress(), true);
		payment = new Payment(cart, 2000);
		orders.add(new Order("202108061231130", persons.get(0), cart, deliveryTime, payment));
		cart.removeAll(cart);
		deliveryTime = new DeliveryTime();
		payment = new Payment();
		cart.add(new Cart(100, "아메리카노HOT", 3, 9000));
		cart.add(new Cart(201, "자몽에이드ICE", 2, 9000));
		payment = new Payment(cart, 0);
		deliveryTime = new DeliveryTime(cart, ((Member)persons.get(0)).getAdress(), false);
		orders.add(new Order("202108071225091", persons.get(0), 	cart, deliveryTime, payment));
		cart.removeAll(cart);
		deliveryTime = new DeliveryTime();
		payment = new Payment();
		cart.add(new Cart(101, "아메리카노ICE", 2, 6000));
		deliveryTime = new DeliveryTime(cart, ((Member)persons.get(1)).getAdress(), true);
		payment = new Payment(cart, 5000);
		orders.add(new Order("202108081245232", persons.get(1), cart, deliveryTime, payment));
		cart.removeAll(cart);
		deliveryTime = new DeliveryTime();
		payment = new Payment();
		cart.add(new Cart(203, "카모마일ICE", 2, 8000));
		cart.add(new Cart(103, "카페라떼ICE", 1, 3500));
		deliveryTime = new DeliveryTime(cart, ((Member)persons.get(2)).getAdress(), false);
		payment = new Payment(cart, 2000);
		orders.add(new Order("202108091237483", persons.get(2), cart, deliveryTime, payment));
		cart.removeAll(cart);
		deliveryTime = new DeliveryTime();
		payment = new Payment();
	}
	
	
	/* ------------------------------ 초기화블럭 getter ------------------------------ */
	
	public static List<Person> getPersons() {
		return persons;
	}
	
	public static List<Order> getOrders() {
		return orders;
	}
	
	
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
	@Override
	public Person findCardPwBy(String pw) {
		for(int i = 0; i < persons.size(); i++) {
			if(pw.equals(persons.get(i).getCardPw())) {
				return persons.get(i);
			}
		}
		return null;
	}

	/**
	 * [ID 확인]<br>
	 * 파라메터로 입력된 멤버ID가 등록된 멤버ID가 맞는지 확인합니다.<br>
	 * 초기화블럭으로 입력된 멤버리스트에 저장된 ID인지 확인합니다.<br>
	 * @param memberID 멤버ID
	 * @return members.get(i)
	 */
	@Override
	public Person findPersonBy(String id) {
		for (int i = 0; i < persons.size(); i++) {
			if (id.equals(persons.get(i).getId())) {
				return persons.get(i);
			}
		}
		return null;
	}


	/**
	 * [사원 확인]<br>
	 * 파라메터로 입력되는 멤버ID가 사원ID가 맞는지 확인합니다.<br>
	 * ManagerServiceImpl에서 초기화블럭으로 입력된 사원리스트에 저장된 ID인지 확인합니다.<br>
	 * @param memberID 멤버ID
	 * @return employees.get(i)
	 */
	@Override
	public Employee findEmployeeBy(String id) {
		for (int i = 0; i < employees.size(); i++) {
			if (id.equals(employees.get(i).getEmployeeID())) {
				return employees.get(i);
			}
		}
		return null;
	}

	/**
	 * [메뉴 확인]<br>
	 * 파라메터로 입력되는 메뉴코드가 메뉴리스트에 존재하는지 확인합니다.<br>
	 * Date: 2021-07-29
	 * @param menuCode 메뉴코드
	 * @return carts.get(i)
	 * @author 김동휘
	 */
	@Override
	public Menu findMenuBy(int menuCode) {
		for (int i = 0; i < menus.size(); i++) {
			if (menuCode == menus.get(i).getMenuCode()) {
				return menus.get(i);
			}
		}
		return null;
	}
	
	/**
	 * [장바구니 메뉴 확인]<br>
	 * 파라메터로 입력되는 메뉴코드가 장바구니에 담겨있는지 확인합니다.<br>
	 * Date: 2021-08-05
	 * @param menuCode
	 * @return
	 * @author 김동휘
	 */
	@Override
	public Cart findCartBy(int menuCode) {
		for (int i = 0; i < cart.size(); i++) {
			if (menuCode == cart.get(i).getMenuCode()) {
				return cart.get(i);
			}
		}
		return null;
	}

	/**
	 * [결제 카드번호 확인]<br>
	 * 주문완료 후 결제할 때<br>
	 * 등록된 카드번호와 입력한 카드번호가<br>
	 * 일치하는지 확인하는 기능<br>
	 * Date: 2021-08-08
	 * @author 김동휘
	 */
	@Override
	public Person findCardBy(String cardNum) {
		for(int i = 0; i < persons.size(); i++) {
			if (cardNum.equals(persons.get(i).getCardNum())) {
				return persons.get(i);
			}
		}
		return null;
	}
	
	
	/* ------------------------------ 로그인 ------------------------------ */
	
	/**
	 * [로그인하기]<br>
	 * Online Order Service를 통해 주문하려면 로그인을 해야 합니다.<br>
	 * 가입이 안된 경우 회원가입을 해야 합니다.<br>
	 * Date: 2021-08-04, 2021-08-10
	 * @author 박인영
	 */
	@Override
	public void login() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("CAFE KIKIO OOS를 이용하시려면 로그인 하셔야 합니다.");
		System.out.println("회원가입이 안되어 있으신 분들은 초기화면으로 돌아가 회원가입을 해주시기 바랍니다.");
		// [로그인메뉴]
		int loginInput = nextInt("--------------------------------------------------------------\n" + 
								 "1.로그인  2.초기화면 > ");
		switch (loginInput) {
		// [로그인]
		case 1:
			personLogin();
			break;
		// [초기화면]
		case 2:
			System.out.println("초기화면으로 돌아갑니다.");
			break;
		// [예외처리]
		default:
			System.out.println("입력이 올바르지 않습니다. 초기화면으로 돌아갑니다.");
			break;
		}
	}

	/**
	 * [로그인]<br>
	 * Date: 2021-08-04, 2021-08-10
	 * @author 박인영
	 */
	@Override
	public void personLogin() {
		System.out.println("--------------------------------------------------------------");
		String id = nextLine("ID를 입력하세요.  (임시 ID K0001) > ");
		// [가입여부 확인]
		if (findPersonBy(id) == null) {
			System.out.println("등록된 ID가 아닙니다. 초기화면으로 돌아갑니다.");
			return;
		}
		// [ID의 PW 일치여부 확인]
		String pw = nextLine("Password를 입력하세요. (임시 PW 1111) > ");
		if (pw.equals(findPersonBy(id).getPw())) {
			// [로그인 완료]
			System.out.println("--------------------------------------------------------------");
			System.out.println("[" + findPersonBy(id).getName() + "]님, 어서오세요. ");
			person = findPersonBy(id);
//			return;
		}
		// [로그인 실패]
		else if (!pw.equals(findPersonBy(id).getPw())) {
			System.out.println("비밀번호가 맞지 않습니다. 초기화면으로 돌아갑니다.");
			return;
		}
	}

	
	/* ------------------------------ 멤버등록 및 회원가입 ------------------------------ */

	/**
	 * [멤버등록 및 회원가입]<br>
	 * Online Order Service를 이용하려면<br>
	 * 사원은 멤버등록해야하며,<br>
	 * 비사원은 회원가입해야합니다.<br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	@Override
	public void addPerson() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Kikio 사원은 멤버등록을 이용해주세요.");
		System.out.println("Kikio 사원이 아니신 분들은 회원가입을 이용해주세요.");
		int input = nextInt("1.멤버등록  2.회원가입  0. 초기화면 > ");
		// [멤버가입]
		if (input == 1) {
			addMember();
			return;
		}
		// [회원가입]
		else if (input == 2) {
			addUser();
			return;
		} else if (input == 0) {
			System.out.println("가입을 종료하고 초기화면으로 돌아갑니다. ");
			return;
		} else {
			System.out.println("입력이 올바르지 않습니다. 초기화면으로 돌아갑니다.");
			return;
		}
	}

	/**
	 * [멤버등록]<br>
	 * 사원이 Online Order Service를 이용하려면 멤버로 등록해야 합니다.<br>
	 * 사원ID를 조회하여 이름, 연락처, 부서호수를 불러올 수 있습니다. <br>
	 * 추가로 비밀번호와 결제카드번호, 카드비밀번호를 입력합니다.<br>
	 * Date: 2021-08-01, 2021-08-04
	 * @author 김동휘, 박인영
	 */
	@Override
	public void addMember() {
		System.out.println("--------------------------------------------------------------");
		String id = nextLine("사원ID를 입력하세요. (임시 ID K0005) > ");
		// [멤버등록여부 확인]
		// 이미 Online Order Service에 등록된 사원인지 확인합니다.
		// 초기화블럭을 입력된 멤버리스트에 저장된 ID인지 확인합니다.
		if(!(findPersonBy(id) == null)) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("이미 멤버로 등록된 사원ID입니다.");
			System.out.println("멤버등록을 종료하고 초기화면으로 돌아갑니다.");
			return;
		}
		// [사원여부 확인]
		// 사원인지 아닌지 확인합니다.
		// ManagerServiceImpl에서 초기화블럭으로 입력된 사원리스트에 저장된 ID인지 확인합니다.
		if (findEmployeeBy(id) == null) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("사원으로 등록되지 않은 ID입니다.");
			System.out.println("사원ID가 맞는데 조회가 되지 않는다면, 인사팀에 문의해주시기 바랍니다.");
			System.out.println("신입사원이시라면 입사일 다음날부터 등록이 가능합니다.");
			System.out.print("초기화면으로 돌아갑니다.");
			return;
		}
		// [사원리스트 호출]
		// 인사팀 사원리스트에 등록된 사원의 정보를 확인합니다.
		System.out.println(findEmployeeBy(id).toString());
		// [비밀번호 설정]
		String pw = nextLine("비밀번호를 설정하세요. > ");
		// [결제카드번호 입력]
		String cardNum = nextLine("주문시 사용할 결제카드번호를 입력하세요.\n" + "(ex. 현대카드 0000-0000-0000-0000) > ");
		// [결제카드 비밀번호 입력]
		// 카드 비밀번호에 대한 유효성을 검사합니다.
		String cardPw ="";
		while(true) {
			cardPw = nextLine("결제시 사용할 결제카드 비밀번호 숫자 4자리를 입력하세요. > ");
			if(cardPw.length() == 4 && checkCardPw(cardPw) != null)
				break;
			System.out.println("입력이 올바르지 않습니다.");
		}
		// [멤버등록 확인]
		// 멤버등록 전 등록여부를 확인합니다.
		System.out.println("--------------------------------------------------------------");
		System.out.println("　　　　ID: " + findEmployeeBy(id).getEmployeeID());
		System.out.println("　　　　PW: " + pw);
		System.out.println("　　　이름: " + findEmployeeBy(id).getEmployeeName());
		System.out.println("　　연락처: " + findEmployeeBy(id).getEmployeePhoneNum());
		System.out.println("　부서호수: " + findEmployeeBy(id).getDepartmentAdress());
		System.out.println("　결제카드: " + cardNum);
		System.out.println("결제카드PW: " + cardPw);
		System.out.println("--------------------------------------------------------------");
		System.out.println("멤버ID와 이름를 제외한 정보는 등록 후 멤버정보변경에서 수정이 가능합니다.");
		int addMemberCheck = nextInt("위 정보로 멤버등록을 하시겠습니까?  1.예   2.아니요(초기화면으로 이동) > ");
		// [멤버등록 취소]
		if (addMemberCheck == 2) {
			System.out.println("멤버등록을 취소하고 초기화면으로 돌아갑니다.");
			return;
		}
		// [멤버등록 완료]
		else if (addMemberCheck == 1) {
			persons.add(new Member(findEmployeeBy(id).getEmployeeID()
								, pw
								, findEmployeeBy(id).getEmployeeName()
								, findEmployeeBy(id).getEmployeePhoneNum()
								, cardNum
								, cardPw
								, findEmployeeBy(id).getDepartmentAdress(), 0));
			System.out.println("멤버등록이 완료되었습니다. 초기화면으로 돌아갑니다.");
			return;
		} else {
			System.out.println("입력이 올바르지 않습니다. 멤버등록을 취소하고 초기화면으로 돌아갑니다.");
			return;
		}
	}

	// [결제카드 비밀번호 숫자 4자리 사용 확인]
	@Override
	public String checkCardPw(String cardPw) {
		for (int i = 0; i < cardPw.length(); i++) {
			if(!('0' <= cardPw.charAt(i) && cardPw.charAt(i) <= '9')) {
				return null;
			}
		}
		return cardPw;
	}
	
	/**
	 * [회원가입]<br>
	 * 사원이 아닌 분들이 Online Order Service를 이용하려면 회원으로 가입합니다.<br>
	 * Date: 2021-07-29, 2021-08-06
	 * @author 김동휘, 박인영
	 */
	@Override
	public void addUser() {
		System.out.println("--------------------------------------------------------------");
		System.out.print("사용하실 ID를 입력하세요. (영문 소문자와 숫자만 사용할 수 있습니다.)");
		String id;
		// [ID 적합여부 검사]
		// 멤버의 아이디가 영어 대문자로 시작하고,
		// 이 값으로 배달이 가능함을 파악해야 하기 때문에
		// 배달이 불가능한 회원아이디는 영어대문자가 들어가서는 안됩니다.
		// 수월한 관리를 위해 영어소문자와 숫자만 입력이 가능하도록 합니다. (기호도 사용불가)
		// 회원가입시 사용할 아이디의 적합성 검사와 중복검사를 진행하며
		// 실수했을 때 초기화 화면으로 넘어가는 것이 번거로움으로 while 반복문 사용
		while(true) {
			id = nextLine(" > ");
			if(!(checkUserID(id) == null)) {	// 아이디가 영문 소문자와 숫자로만 이루어져 있으면
				if (findPersonBy(id) == null)	{	// 아이디가 중복된 아이디가 아니면
					break;
				}
				System.out.print("이미 사용중인 ID입니다. 다른 ID를 입력해주세요.");
				continue;
			}	
			System.out.print("ID는 영문 소문자와 숫자만 사용할 수 있습니다. 다른 ID를 입력해주세요.");
		}
		String pw = nextLine("비밀번호를 입력하세요. > ");
		String name = nextLine("이름을 입력하세요. > ");
		String phone = nextLine("휴대전화번호를 입력하세요. > ");
		String cardNum = nextLine("결제할 카드번호를 입력하세요. > ");
		// 카드 비밀번호에 대한 유효성을 검사합니다.
		String cardPw ="";
		while(true) {
			cardPw = nextLine("결제시 사용할 결제카드 비밀번호 숫자 4자리를 입력하세요. > ");
			if(cardPw.length() == 4 && checkCardPw(cardPw) != null)
				break;
			System.out.println("입력이 올바르지 않습니다.");
		}
		persons.add(new User(id, pw, name, phone, cardNum, cardPw));
		System.out.println("회원가입이 완료되었습니다. 초기화면으로 돌아갑니다.");
	}

	/**
	 * [ID 적합여부 검사]<br>
	 * 회원가입시 아이디가 영어 소문자와 숫자로만 이루어져있는지 확인합니다.<br>
	 * Date: 2021-08-06
	 * @author 박인영
	 */
	@Override
	public String checkUserID(String userID) {
		for (int i = 0; i < userID.length(); i++) {
			if(!('a' <= userID.charAt(i) && userID.charAt(i) <= 'z' || '0' <= userID.charAt(i) && userID.charAt(i) <= '9')) {
				return null;
			}
		}
		return userID;
	}
	
	
	/* ------------------------------ 멤버 및 회원 메뉴 ------------------------------ */
	
	/**
	 * [멤버 및 회원 메뉴]<br>
	 * 멤버와 회원이 등록된 정보를 조회하고 수정합니다.<br>
	 * 또한 주문내역을 조회할 수 있습니다.<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	@Override
	public void personMenu() {
		// 주문하기를 통해 이미 로그인이 되어 있는 경우 항목 선택 생략
		if(person instanceof Member)
			// [멤버메뉴]
			memeberMenu();
		else if(person instanceof User)
			// [회원메뉴]
			userMenu();
		// 로그인이 안되어 있는 경우
		else if(person == null){
			login();
		}
	}
	
	/**
	 * [멤버 메뉴]<br>
	 * 멤버의 정보를 조회/수정하고 주문내역을 조회합니다.<br>
	 * 배달서비스가 가능한 멤버의 경우,<br>
	 * 연락처, 배달주소, 결제카드 정보를 조회/수정할 수 있으며,<br>
	 * 적립된 마일리지 또한 조회가 가능합니다.<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	@Override
	public void memeberMenu() {
		while(true) {
			int input = nextInt("원하시는 서비스를 숫자로 입력해주세요.\n" +
								"--------------------------------------------------------------\n" +
								"1.등록정보조회  2.등록정보수정  3.주문내역조회  0.초기화면 > ");
			switch (input) {
			// [등록정보조회]
			case 1:
				listMember();
				break;
			// [등록정보수정]
			case 2:
				modifyMember();
				break;	
			// [주문내역조회]
			case 3:
				listMemberOrder();
				break;	
			// [초기화면]	
			case 0:
				System.out.println("초기화면으로 돌아갑니다.");
				return;
			// [예외처리]	
			default:
				System.out.println("입력이 올바르지 않습니다.");
				break;
			}
		}
	}
	
	/**
	 * [회원 메뉴]<br>
	 * 회원의 정보를 조회/수정하고 주문내역을 조회합니다.<br>
	 * KIKIO 사원이 아닌 회원의 경우,<br>
	 * 연락처, 결제카드 정보를 조회/수정할 수 있습니다.<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	@Override
	public void userMenu() {
		while(true) {
			int input = nextInt("원하시는 서비스를 숫자로 입력해주세요.\n" +
								"--------------------------------------------------------------\n" +
								"1.등록정보조회  2.등록정보수정  3.주문내역조회  0.초기화면 > ");
			// [등록정보조회]
			switch (input) {
			case 1:
				listUser();
				break;
			// [등록정보수정]	
			case 2:
				modifyUser();
				break;	
			// [주문내역조회]	
			case 3:
				listUserOrder();
				break;
			// [초기화면]	
			case 0:
				System.out.println("초기화면으로 돌아갑니다.");
				return;
			// [예외처리]	
			default:
				System.out.println("입력이 올바르지 않습니다. 초기화면으로 돌아갑니다.");
				break;
			}
		}
	}
	
	/**
	 * [멤버 등록정보 조회]<br>
	 * 멤버의 등록된 정보를 조회합니다.<br>
	 * 조회 가능 정보: 멤버ID, 멤버이름, 멤버연락처, 배달호수, 결제카드정보<br>
	 * Date: 2021-08-01
	 * @author 김동휘
	 */
	@Override
	public void listMember() {
		System.out.println(((Member)person).toString());
	}

	/**
	 * [회원 등록정보 조회]<br>
	 * 회원의 등록된 정보를 조회합니다.<br>
	 * 조회 가능 정보: 회원ID, 회원이름, 회원연락처, 결제카드정보<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	@Override
	public void listUser() {
		System.out.println(((User)person).toString());
	}
	
	/**
	 * [멤버 등록정보 수정]<br>
	 * 등록된 멤버의 정보를 수정합니다.<br>
	 * 수정 가능 정보: 멤버연락처, 배달호수, 결제카드정보<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	public void modifyMember() {
		// 수정 결정 의사를 확실히 하기 위해 ID를 한번더 확인합니다.
		String id = nextLine("수정하시려면 멤버님의 ID를 입력하세요. > ");
		// 입력받는 아이디가 현재 로그인해있는 아이디와 동일한지 확인이 필요합니다.
		// 아이디가 동일하지 않으면 수정을 진행할 수 없습니다.	
		if(!(id.equals(person.getId()))) {
			System.out.println("로그인 하신 ID와 일치하지 않습니다.");
            System.out.println("초기화면으로 돌아갑니다.");
            return;
        }
		listMember();
		int select = nextInt("수정하실 항목을 숫자로 입력해주세요.\n" +
							 "---------------------------------------------------------------------------------\n" + 
							 "1.이름   2.전화번호   3.배달주소   4.결제카드번호   5.결제카드PW   6.이전화면 > ");
		if(select == 1) {
			person.setName(nextLine("수정하실 회원님의 성함을 입력하세요. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if (select == 2) {
			person.setPhone(nextLine("수성하실 회원님의 전화번호를 입력하세요. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if (select == 3) {
			((Member)person).setAdress(nextLine("수정하실 회원님의 배달 부서 호수를 입력하세요.\n" +
											"(ex. 401호는 \"401\"로 입력하셔야 합니다.) >  "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if(select == 4) {
			person.setCardNum(nextLine("수정하실 회원님의 카드결제번호를 입력하세요. >  "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if(select == 5) {
			person.setCardPw(nextLine("수정하실 회원님의 카드 비밀번호를 입력하세요. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		
		else if(select == 6) {
			System.out.println("이전화면으로 돌아갑니다.");
			return;
		}
		else {
			System.out.println("입력이 올바르지 않습니다. 이전화면으로 돌아갑니다.");
			return;
		}
	}
	
	/**
	 * [회원 등록정보 수정]<br>
	 * 등록된 회원의 정보를 수정합니다.<br>
	 * 수정 가능 정보: 회원연락처, 결제카드정보<br>
	 * Date: 2021-07-31
	 * @author 김동휘
	 */
	@Override
	public void modifyUser() {
		// 수정 결정 의사를 확실히 하기 위해 ID를 한번더 확인합니다.
		String id = nextLine("수정하시려면 회원님의 ID를 입력하세요. > ");
		// 입력받는 아이디가 현재 로그인해있는 아이디와 동일한지 확인이 필요합니다.
		// 아이디가 동일하지 않으면 수정을 진행할 수 없습니다.
		if(!(id.equals(person.getId()))) {
            System.out.println("로그인 하신 ID와 일치하지 않습니다.");
            System.out.println("초기화면으로 돌아갑니다.");
            return;
        }
		listUser();
		int select = nextInt("---------------------------------------------------------------------------\n" + 
							 "수정하실 항목을 숫자로 입력해주세요.\n" +
				 			 "1.이름    2.전화번호  3.결제카드번호   4.결제카드 PW   5.이전화면 > ");
		if(select == 1) {
			person.setName(nextLine("수정하실 회원님의 성함을 입력해주십시오. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if (select == 2) {
			person.setPhone(nextLine("수성하실 회원님의 전화번호를 입력해주십시오. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if (select == 3) {
			person.setCardNum(nextLine("수정하실 회원님의 결제 카드번호를 입력해주십시오. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		else if(select == 4) {
			person.setCardPw(nextLine("수정하실 회원님의 카드 비밀번호를 입력하세요. > "));
			System.out.println("수정을 완료했습니다. 이전화면으로 돌아갑니다.");
			return;
		}
		
		else if(select == 5) {
			System.out.println("이전화면으로 돌아갑니다.");
			return;
		}
		else {
			System.out.println("입력이 올바르지 않습니다. 이전화면으로 돌아갑니다.");
			return;
		}
	}
	
	
	/* ------------------------------ 주문하기 [1] 장바구니에 담기 ------------------------------ */
	
	/**
	 * [장바구니에 담기]
	 * 메뉴리스트를 조회하여 주문하려는 메뉴를 장바구니에 담습니다.
	 * Date: 2021-07-29
	 * @author 김동휘 
	 */
	public void order() {
		// [로그인 여부 확인]
		// [멤버 및 회원 메뉴]에서 로그인하고 오면 로그인 생략
		if(person == null) {
			login();
			// 로그인 중 예외처리되었을 때 주문하기로 넘어가지 않기 위해 로그인 상태 한번더 확인
			if(person == null)
				return;
		}		
		addCart();
		boolean exit = true;
		while(exit) {
			int cartMenu = nextInt("--------------------------------------------------------------\n" +
								   "1.추가　　　2.삭제　　　3.장바구니 담기 완료　　　4.주문취소 > ");
			switch(cartMenu) {
			case 1:
				addCart();
				break;
			case 2:
				removeCart();
				break;			
			case 3:
				if(person instanceof Member)
					exit = deliveryCheck();
				else if(person instanceof User)
					exit = takeOutCheck();
				break;
			case 4:
				cart.removeAll(cart);
				return;
			default:
				System.out.println("올바른 입력이 아닙니다. 다시 입력해주세요.");
			}
		}
	}
	
	/**
	 * [장바구니 담기]<br>
	 * 주문 전 메뉴리스트를 보여줍니다.<br>
	 * 주문을 원하는 메뉴의 메뉴코드를 선택한 후 주문수량을 입력합니다.<br> 
	 * 하단에 총주문수량과 총 결제금액을 보여줍니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	@Override
	public void addCart() {
		listMenu();
		while (true) { // 장바구니에 계속 메뉴를 담기위해 while 추가
			int menuCode = nextInt("장바구니에 담을 메뉴의 메뉴코드를 입력하세요. > ");
				if (findMenuBy(menuCode) == null) {
					System.out.println("메뉴 코드가 일치하지 않습니다.");
					return;
				}	
			int orderCount = nextInt("몇 개를 담을까요? > ");
			if(checkOrderCount(menuCode, orderCount)) {
				cart.add(new Cart(menuCode, orderCount));
				listCart();
				break;
			}
		}
	}
	
	/**
	 * [주문수량 유효성 검사]
	 * 장바구니에 담는 메뉴의 주문수량이 주문가능수량을 초과하지 않는지
	 * 주문이 불가능한 음수값을 입력하는지 확인합니다.
	 * 또한 장바구니에 같은 메뉴를 나누어 담을수 있기 때문에
	 * 같은 메뉴를 주문하는 주문수량의 합이 주문가능수량을 초과하지 않는지 확인합니다.
	 */
	@Override
	public boolean checkOrderCount(int menuCode, int orderCount) {
		if (0 >= orderCount || orderCount > findMenuBy(menuCode).getOrderableCount()) {
			System.out.println("주문가능수량 내에서 장바구니에 담을 수 있습니다.");
			System.out.println("다시 입력해주세요.");
			return false;
		}
		else {
			int count = 0;
			for (int i = 0; i < cart.size(); i++) {
				if (menuCode == cart.get(i).getMenuCode()) {
					count += cart.get(i).getOrderCount();
				}
			}
			if(orderCount + count > findMenuBy(menuCode).getOrderableCount()) {
				System.out.println("장바구니에 담긴 같은 메뉴의 주문수량으로 인해");
				System.out.println("주문가능수량을 초과합니다. 다시 입력해주세요.");
				return false;
			}
			return true;
		}
	}
	
	
	/**
	 * [메뉴리스트 조회]<br>
	 * 장바구니에 메뉴를 담을 때 참고할 수 있는 메뉴리스트입니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	@Override
	public void listMenu() {
		System.out.println("==============================================================");
		System.out.println("　메뉴코드　\t　메 뉴 명　\t　가　　격　\t주문가능수량");
		System.out.println("==============================================================");
		for (int i = 0; i < menus.size(); i++) {
			System.out.printf("%8d\t%8s\t%8d\t%8d%n"
							, menus.get(i).getMenuCode()
							, menus.get(i).getMenuName()
							, menus.get(i).getMenuPrice()
							, menus.get(i).getOrderableCount());
		}
		System.out.println("==============================================================");
	}

	/**
	 * [장바구니 조회]<br>
	 * 장바구니에 담긴 메뉴를 조회합니다.<br>
	 * 해당 메뉴는 장바구니에 메뉴를 담을 때마다 조회됩니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	@Override
	public void listCart() {
		System.out.println("==============================================================");
		System.out.println("　메뉴코드　\t　메 뉴 명　\t　주문수량　\t　결제금액");
		System.out.println("==============================================================");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%8d\t%8s\t%8d\t　%8d%n"
							, cart.get(i).getMenuCode()
							, cart.get(i).getMenuName()
							, cart.get(i).getOrderCount()
							, cart.get(i).getPaymentPrice());
		}
		System.out.println("==============================================================");
	}
	
	/**
	 * [장바구니 메뉴 삭제]<br>
	 * 장바구니에 담긴 메뉴 중 주문을 원하지 않는 메뉴를 삭제할 수 있습니다.<br>
	 * Date: 2021-07-29
	 * @author 김동휘
	 */
	@Override
	public void removeCart() {
		listCart();
		int removeMenu = nextInt("삭제 하실 메뉴의 코드를 입력하십시오 > ");
		;
		if (findCartBy(removeMenu) == null) {
			System.out.println("메뉴 코드가 일치하지 않습니다.");
			return;
		}
		cart.remove(findCartBy(removeMenu));
		listCart();
	}
	
	
	/* ------------------------------ 주문하기 [2] 배달/픽업 선택 ------------------------------ */
	
	/**
	 * [멤버의 배달/픽업 선택]<br>
	 * 멤버는 KIKIO 본사 사무실에 한하여 배달이 가능하기 때문에<br>
	 * 배달이용할지 픽업을 할지 선택한다.<br>
	 * Date: 2021-08-05
	 * @author 김동휘
	 * @return 
	 */
	@Override
	public boolean deliveryCheck() {
		while(true) {
			int check = nextInt("1.배달하기　　　2.픽업하기 > ");
			if (check == 1) {
				deliveryTime.setDeliveryCheck(true);	// 배달여부 true로 변경
				// [배달예상시간 안내]
				// 제조시간 = 기본제조시간(3분) + (총주문수량 * 음료제조시간(2분)
				// 예상배달시간 = 제조시간 + 배달셋팅시간(5분) + 층수별배달시간
				String adress = ((Member)person).getAdress();
				System.out.println("--------------------------------------------------------------");
				System.out.println("멤버님의 사무실 [" + adress + "호]까지의 배달 예상 시간은");
				System.out.println("결제완료 후부터 ["+ deliveryTime.calculateDeliveryTime(cart, adress) + "분] 예정입니다." );
				break;
			} else if (check == 2) {
				// [픽업가능시간 안내]
				// 제조시간 = 기본제조시간(3분) + (총주문수량 * 음료제조시간(2분)
				System.out.println("--------------------------------------------------------------");
				System.out.println("픽업 예상 시간은 결제완료 후부터 [" + deliveryTime.calculateMakingTime(cart) + "분] 예정입니다." );
				break;
			}
			// [예외처리]
			else
				System.out.println("올바른 입력이 아닙니다. 다시 입력해주세요.");
		}		
		System.out.println("결제단계로 넘어갑니다.");
		memberPay();
		return false;
	}
	/**
	 * [회원의 픽업시간 안내]<br>
	 * 회원의 주문은 배달이 불가능하며, 직접 카운터에서 음료를 픽업해야 한다.<br>
	 * 음료가 만들어지는 예상시간을 안내하여<br>
	 * 시간 맞춰 매장에 방문할 수 있도록 안내한다.<br>
	 * Date: 2021-08-05
	 * @author 김동휘
	 * @return 
	 */
	@Override
	public boolean takeOutCheck() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("픽업 예상 시간은 결제완료 후부터 [" + deliveryTime.calculateMakingTime(cart) + "분] 예정입니다." );
		System.out.println("결제단계로 넘어갑니다.");
		userPay();
		return false;
	}
	
	
	/* ------------------------------ 주문하기 [3] 결제하기 ------------------------------ */
	
	/**
	 * [멤버의 결제하기]<br>
	 * 총 결제금액을 안내 후 등록된 카드로 결제합니다.<br>
	 * 카드결제금액에서 몇%의 마일리지가 적립되며,<br>
	 * 적립된 마일리지를 사용해 결제할 수 있습니다.<br>
	 * Date: 2021-08-08, 2021-08-08
	 * @author 김동휘, 박인영
	 */
	@Override
	public void memberPay() {
		payment.setTotalPayment(payment.calculateTotalPayment(cart));
		int useMileage = 0;
		int useableMileage = ((Member)person).getMileage();
		if (useableMileage != 0) {
			System.out.println("--------------------------------------------------------------");
			System.out.printf(" 주문하신 총 금액: %10d 원%n", payment.getTotalPayment());
			System.out.printf("사용가능 마일리지: %10d 원%n", useableMileage);
			System.out.println("--------------------------------------------------------------");
			// [마일리지 사용 금액 제한]
			// 마일리지는 적립되어 있는 만큼만 쓸 수 있으며
			// 결제해야할 금액보다 클 수 없습니다.
			while(true) {
				useMileage = nextInt("사용할 마일리지 금액을 입력하세요.\n" +
									 "사용을 원하지 않으시면 0을 입력하세요. > ");
				if(0 <= useMileage && useMileage <= useableMileage && useMileage <= payment.getTotalPayment())
					break;
				System.out.println("마일리지는 사용가능한 금액내에서 사용할 수 있으며, \n주문하신 총 금액보다 클 수 없습니다.");
			}
			payment.setMileagePayment(useMileage);
			payment.setCardPayment(payment.getTotalPayment() - useMileage);
			System.out.println("--------------------------------------------------------------");
			System.out.printf(" 주문하신 총 금액: %10d 원%n", payment.getTotalPayment());
			System.out.printf("  사용한 마일리지: %10d 원%n", useMileage);
			System.out.printf("　　최종 결제금액: %10d 원%n", payment.getCardPayment()); 
			System.out.println("--------------------------------------------------------------");
		}
		// 마일리지가 없다면 마일리지 입력없이 바로 결제로 넘어갑니다.
		if (useableMileage == 0) {
			payment.setCardPayment(payment.calculateTotalPayment(cart));
			System.out.println("--------------------------------------------------------------");
			System.out.printf("　　최종 결제금액: %10d 원%n", payment.getCardPayment()); 
			System.out.println("--------------------------------------------------------------"); 
			System.out.println("등록된 결제카드 [" + person.getCardNum().substring(0,2) + "카드]로 결제됩니다.");
		}
		System.out.println("[개인정보 수집 및 이용 처리]와 \n[결제대행 서비스 이용 약관]에 동의 하십니까?");
		// 결제까지 왔는데 실수로 인해 다시 처음으로 돌아가는 건 번거로워
		// while 문에 가두었습니다.
		while(true) {
			int agree = nextInt("1.동의하고 결제하기  2. 비동의하고 초기화면으로 돌아가기 > ");
			String cardPw = nextLine("결제를 진행하시려면 등록된 결제 카드 비밀번호를 입력해 주세요. (임시 PW 1111) > ");
			if(!cardPw.equals(person.getCardPw())) {
				System.out.println("비밀번호가 일치하지 않습니다.");
				System.out.println("다시 입력해 주십시오.");
				return ;
			}
			if (agree == 1) {
				System.out.println("--------------------------------------------------------------");
				System.out.println("결제가 완료되고 [" + payment.calculateSaveMileage() + "원]의 마일리지가 적립되었습니다.");
				// [멤버의 마일리지 set]
				// 결제에 사용된 마일리지 차감 및 발생한 마일리지 적립
				((Member)person).setMileage(useableMileage - useMileage + payment.getSaveMileage());
				compliteOrder();
				break;
			}
			// [결제취소]
			// 장바구니가 비워지고 결제관련 정보도 비워집니다.
			// 비우지 않으면 초기화면으로 갔다가 다시 주문할 때 이전 정보 때문에 값이 맞지 않게 됩니다.
			if (agree == 2) {
				System.out.println("결제를 취소하고 초기화면으로 돌아갑니다.");
				cart.removeAll(cart);
				payment = new Payment();
				deliveryTime = new DeliveryTime();
				return;
			}
			// [에외처리]
			System.out.println("입력이 올바르지 않습니다.");
		}
	}

	/**
	 * [회원의 결제하기]<br>
	 * 총 결제금액을 안내 후 등록된 카드로 결제합니다.<br>
	 * Date: 2021-08-08
	 * @author 김동휘
	 */
	@Override
	public void userPay() {
		payment.setCardPayment(payment.calculateTotalPayment(cart));
		System.out.println("--------------------------------------------------------------");
		System.out.printf("　　최종 결제금액: %10d 원%n", payment.getCardPayment()); 
		System.out.println("--------------------------------------------------------------");
		System.out.println("등록된 결제카드 [" + person.getCardNum().substring(0,2) + "카드]로 결제됩니다.");
		System.out.println("[개인정보 수집 및 이용 처리]와 \n[결제대행 서비스 이용 약관]에 동의 하십니까?");
		// 결제까지 왔는데 실수로 인해 다시 처음으로 돌아가는 건 번거로워
		// while 문에 가두었습니다.
		while(true) {
			int agree = nextInt("1.동의하고 결제하기  2. 비동의하고 초기화면으로 돌아가기 > ");
			if (agree == 1) {
				String cardPW = nextLine("등록된 결제카드 비밀번호를 입력하여 결제를 진행해 주십시오. (임시 PW 0101) > ");
				if(!cardPW.equals(person.getCardPw())) {
					System.out.println("비밀번호가 일치하지 않습니다.");
					System.out.println("다시 입력해 주십시오.");
					return ;
				}
				System.out.println("--------------------------------------------------------------");
				System.out.println("결제가 완료되었습니다.");
				compliteOrder();
				break;
			}
			// [결제취소]
			// 장바구니가 비워지고 결제관련 정보도 비워집니다.
			// 비우지 않으면 초기화면으로 갔다가 다시 주문할 때 이전 정보 때문에 값이 맞지 않게 됩니다.
			if (agree == 2) {
				System.out.println("결제를 취소하고 초기화면으로 돌아갑니다.");
				cart.removeAll(cart);
				payment = new Payment();
				deliveryTime = new DeliveryTime();
				return;
			}
			// [에외처리]
			System.out.println("입력이 올바르지 않습니다.");
		}
	}	
	
	
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
	@Override
	public String makeOrderMenus(List<Cart> cart) {
		String orderMenus ="";
		for (int i = 0; i < cart.size(); i++) {
			if (i != cart.size()-1)
				orderMenus += cart.get(i).getMenuName() + " (" + cart.get(i).getOrderCount() + "개)\n\t　　　";
			else
				orderMenus += cart.get(i).getMenuName() + " (" + cart.get(i).getOrderCount() + "개)";
		}
		return orderMenus;
	}
	
	/**
	 * [주문리스트 생성]
	 * 결제가 완료되면 주문리스트가 생성됩니다.
	 * Date:2021-08-07, 2021-08-10
	 * @author 박인영
	 */
	@Override
	public void compliteOrder() {
		// [주문가능수량 수정]
		// 주문이 완료된 메뉴는 메뉴별 판매량을 증가시키고  그로인해 주문가능수량이 줄어듭니다.
		for (int i = 0; i < cart.size(); i++) {
			for (int j = 0; j < menus.size(); j++) {
				if(cart.get(i).getMenuCode() == menus.get(j).getMenuCode())
					menus.get(j).putDemand(cart.get(i).getOrderCount());
			}
		}
		// [주문리스트 생성]
		if(person instanceof Member) {
			orders.add(new Order(person, cart, deliveryTime, payment, makeOrderMenus(cart)));
			compliteOrderMessage();
		}
		else if (person instanceof User) {
			orders.add(new Order(person, cart, deliveryTime, payment, makeOrderMenus(cart)));
			compliteOrderMessage();
		}
	}
	
	/**
	 * [결제완료]
	 * 장바구니가 비워지고 결제관련 정보도 비워집니다.
	 * 비우지 않으면 초기화면으로 갔다가 다시 주문할 때 이전 정보 때문에 값이 맞지 않게 됩니다.
	 * Date:2021-08-07
	 * @author 박인영
	 */
	public void compliteOrderMessage() {
		cart.removeAll(cart);
		deliveryTime = new DeliveryTime();
		payment = new Payment();
		System.out.println("주문이 완료되었습니다.");
		System.out.println("주문내역은 초기화면의 [멤버 및 회원 메뉴]에서 확인하실 수 있습니다.");
		System.out.println("초기화면으로 돌아갑니다.");
		return;
	}
	
	
	/* ------------------------------ 주문조회 ------------------------------ */
	
	/**
	 * [멤버 주문 조회]<br>
	 * 멤버의 주문내역을 조회합니다.<br>
	 * Date: 2021-07-29, 2021-08-07
	 * @author 김동휘, 박인영
	 */
	@Override
	public void listMemberOrder() {
		int count = 0; // 주문횟수
		for (int j = 0; j < orders.size(); j++) {
			if(person.getId() == orders.get(j).getPersonInfo().getId()) {
				System.out.println(orders.get(j).toString());
				count++;
			}
		}
		if(count != 0) { 
			System.out.println("[" + count + "건]의 주문내역을 조회하였습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		}
		else {
			System.out.println("주문내역이 없습니다. 초기화면으로 돌아갑니다.");
			return;
		}

	}
	
	/**
	 * [회원 주문 조회]<br>
	 * 회원의 주문내역을 조회합니다.<br>
	 * Date: 2021-07-29, 2021-08-07
	 * @author 김동휘, 박인영
	 */
	@Override
	public void listUserOrder() {
		int count = 0; // 주문횟수
		for (int j = 0; j < orders.size(); j++) {
			if(person.getId() == orders.get(j).getPersonInfo().getId()) {
				System.out.println(orders.get(j).toString());
				count++;
			}
		}
		if(count != 0) { 
			System.out.println("[" + count + "건]의 주문내역을 조회하였습니다.");
			System.out.println("초기화면으로 돌아갑니다.");
			return;
		}
		else {
			System.out.println("주문내역이 없습니다. 초기화면으로 돌아갑니다.");
			return;
		}
	}
}
