package cafe.service;

import cafe.vo.*;

import static cafe.util.CafeCommon.nextInt;
import static cafe.util.CafeCommon.nextLine;

import java.util.ArrayList;
import java.util.List;;

public class ManagerServiceImpl implements ManagerService {
	
	private static List<Person> persons = UserServiceImpl.getPersons();
	private static Cafe cafe = new Cafe();
	private static List<Menu> menus = new ArrayList<Menu>();
	private static List<Employee> employees = new ArrayList<Employee>();
	private List<Order> orders = UserServiceImpl.getOrders();

	/* ------------------------------ 초기화블럭 ------------------------------ */	
	
	/**
	 * [기본 관리자 초기화 블럭]<br>
	 * 기본 관리자 등록을 위한 초기화 블럭입니다.<br>
	 * 입력 가능한 정보: 관리자ID, 관리자PW, 관리자이름<br>
	 * Date: 2021-07-31
	 * @author 박인영
	 */
	static {
		persons.add(new Manager("admin", "1234", "홍길동"));
		persons.add(new Manager("admin1", "5678", "박길동"));
	}

	/**
	 * [기본 카페정보 초기화 블럭]<br>
	 * 기본 카페정보를 입력하기 위한 초기화 블럭입니다.<br>
	 * 입력 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처, <br>
	 * 　　　　　　　　　카페주소, 최소배달시간, 최대배달시간<br>
	 * Date: 2021-07-29
	 * @author 박인영
	 */
	static {
		cafe.setCafeName("Kikio Cafe");
		cafe.setOpenTime("08:00");
		cafe.setCloseTime("19:00");
		cafe.setHoliday("주말, 공휴일");
		cafe.setPhoneNumber("064-0604-0604");
		cafe.setCafeAddress("제주특별자치도 제주시 첨단로 242 1F");
		cafe.setDeliveryTimeMin(10);
		cafe.setDeliveryTimeMax(50);
	}
	
	/**
	 * [기본 메뉴 초기화 블럭]<br>
	 * 기본 카페정보를 입력하기 위한 초기화 블럭입니다.<br>
	 * 입력 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일,<br>
	 * 　　　　　　　　　카페연락처, 카페주소, 최소배달시간, 최대배달시간<br>
	 * Date: 2021-07-29
	 * @author 박인영
	 */
	static {
		menus.add(new Menu(100, "아메리카노HOT", 3000, 10));
		menus.add(new Menu(101, "아메리카노ICE", 3000, 10));
		menus.add(new Menu(102, "카페라떼HOT", 3500, 10));
		menus.add(new Menu(103, "카페라떼ICE", 3500, 10));
		menus.add(new Menu(200, "레몬에이드ICE", 4500, 10));
		menus.add(new Menu(201, "자몽에이드ICE", 4500, 10));
		menus.add(new Menu(202, "카모마일HOT", 4000, 10));
		menus.add(new Menu(203, "카모마일ICE", 4000, 10));
	}
	
	/**
	 * [사원리스트 초기화 블럭]<br>
	 * 인사팀에서 넘어오는 사원리스트 초기화 블럭입니다.<br>
	 * 사원리스트에 사원ID가 등록되어 있어서 멤버로 등록이 가능합니다.<br>
	 * 조회 가능한 정보: 사원ID, 이름, 핸드폰번호, 소속부서, 부서호수
	 */
	static {
		employees.add(new Employee("K0001", "김연경", "010-1111-1111", "경리부", "301"));
		employees.add(new Employee("K0002", "김정환", "010-2222-2222", "기술지원부", "402"));
		employees.add(new Employee("K0003", "신재환", "010-3333-3333", "기획부", "503"));
		employees.add(new Employee("K0004", "강채영", "010-4444-4444", "마케팅부", "604"));
		employees.add(new Employee("K0005", "오상욱", "010-5555-5555", "영업부", "705"));
		employees.add(new Employee("K0006", "오진혁", "010-6666-6666", "인사부", "801"));
		employees.add(new Employee("K0007", "김우진", "010-7777-7777", "총무부", "902"));
		employees.add(new Employee("K0008", "신재환", "010-8888-8888", "홍보부", "903"));
		employees.add(new Employee("K0009", "김민정", "010-9999-9999", "경리부", "302"));
	}
	
	
	/* ------------------------------ 초기화블럭 getter ------------------------------ */	
	
	/**
	 * [메뉴리스트 반환하기]<br>
	 * ManagerServiceImpl에서 초기화블럭으로 입력된 메뉴리스트를 반환합니다.<br>
	 * Date: 2021-08-03
	 * @return menu 메뉴리스트
	 * @author 박인영
	 */
	public static List<Menu> getMenus() {
		return menus;
	}
	
	/**
	 * [사원리스트 반환하기]<br>
	 * ManagerServiceImpl에서 초기화블럭으로 입력된 사원리스트를 반환합니다.<br>
	 * Date: 2021-08-04
	 * @return employee 사원리스트
	 * @author 박인영
	 */
	public static List<Employee> getEmployees() {
		return employees;
	}

	
	/* ------------------------------ findBy ------------------------------ */
	
	/**
	 * [메뉴 확인]<br>
	 * 파라메터로 입력되는 메뉴코드가 메뉴리스트에 존재하는지 확인합니다.
	 * @param menuCode 메뉴코드
	 * @return menus.get(i)
	 * @author 박인영
	 */
	@Override
	public Menu findMenuBy(int menuCode) {
		for (int i = 0; i < menus.size(); i++) {
			if(menuCode == menus.get(i).getMenuCode()) {
				return menus.get(i);
			}
		}
		return null;
	}
	
	/**
	 * [ID 확인]<br>
	 * 입력된 ID가 등록된 ID가 맞는지 확인합니다.<br>
	 * @param id
	 * @return persons.get(i)
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
	
	
	/* ------------------------------ 관리자 로그인 ------------------------------ */

	/**
	 * [관리자 로그인]<br>
	 * 관리자 메뉴 진입 전 로그인을 합니다.<br>
	 * 관리자로 등록된 ID와 PW가 아니면 관리자메뉴로 진입할 수 없습니다.<br>
	 * Date: 2021-07-31
	 * @author 박인영
	 */
	@Override
	public void login() {
		System.out.println("--------------------------------------------------------------");
		String id = nextLine("관리자ID를 입력하세요. (임시 ID admin) > ");
		// [관리자ID 확인]
		// 초기화블럭을 입력된 관리자리스트에 저장된 ID인지 확인합니다.
		if (findPersonBy(id) == null || !(findPersonBy(id) instanceof Manager)) {
			System.out.println("등록된 ID가 아닙니다. 초기화면으로 돌아갑니다.");
			return;
		}
		// [관리자ID의 PW 일치여부 확인]
		String pw = nextLine("비밀번호를 입력하세요.  (임시 PW 1234) > ");
		if (!(pw.equals(findPersonBy(id).getPw()))) {
			System.out.println("비밀번호가 맞지 않습니다. 초기화면으로 돌아갑니다.");
			return;
		}
		// [로그인 완료]
		System.out.println("--------------------------------------------------------------");
		System.out.print("관리자 [" + findPersonBy(id).getName() + "]님, 어서오세요. ");
		managerMenu();
	}
	
	
	/* ------------------------------ 관리자 메뉴 ------------------------------ */

	@Override
	public void managerMenu() {
		// 관리자 메뉴에서 관리를 마치거나 예외가 처리될 때
		// 초기화면으로 돌아가면 로그인이 번거로우므로,
		// 관리자 메뉴로 돌아오게 하기 위해 while문을 추가하였습니다.
		// Date: 2021-07-31
		// @author 박인영
		while (true) {
			// [관리자메뉴 항목 선택]
			// 관리항목: 카페정보, 메뉴, 주문리스트, 매출, 멤버리스트, 유저리스트
			int mnagementNum = nextInt("원하시는 메뉴를 숫자로 입력하세요.\n" +
									   "--------------------------------------------------------------\n" +
									   "1.카페정보　관리　　2.메　뉴  관　리　　3.멤버/회원 조회\n" +
									   "4.주문리스트조회　　5.매출리스트조회　　0.초　기  화　면 > ");
			switch (mnagementNum) {
			// [카페정보관리 항목 선택]
			// 관리항목: 정보추가, 정보수정
			case 1:
				manageCafeInfo();
				break;
			// [메뉴관리 항목 선택]
			// 관리 항목: 메뉴조회, 메뉴추가, 메뉴수정, 메뉴삭제
			case 2:
				manageMenu();
				break;
			// [맴버/회원 조회하기]
			// Online Order Service에 등록된 멤버와 회원을 조회합니다.
			// 조회 가능한 정보: ID, 이름, 연락처, 멤버/회원여부, 소속호수, 재직여부
			case 3:
				listPersons();
				break;
			// [주문리스트 조회]
			// Online Order Service를 이용하여 요청된 주문리스트를 확인합니다.	
			case 4:
				listOrders();
				break;		
			// [매출리스트 조회]
			// Online Order Service를 통하여 발생된 매출을 확인합니다. 	
			case 5:
				listSales();
				break;
			// [초기화면]
			case 0:
				System.out.println("관리자메뉴를 종료하고 초기화면으로 돌아갑니다.");
				return;
			// [예외처리]
			default:
				System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
				break;
			}
		}
	}
	
	
	/* ------------------------------ 카페정보 관리 ------------------------------ */

	/**
	 * [카페정보 관리하기]<br>
	 * 카페정보를 관리합니다.<br>
	 * 관리항목: 카페정보추가, 카페정보수정<br>
	 * Date: 2021-07-29
	 * @author 박인영
	 */
	@Override
	public void manageCafeInfo() {
		// [관리항목 선택]
		int input = nextInt("카페정보관리입니다. 원하시는 메뉴를 숫자로 입력하세요.\n" +
							"--------------------------------------------------------------\n" +
							"1.카페정보추가  2.카페정보수정  0.이 전 화 면 > ");
		// [카페정보입력]
		// 입력 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처,
		// 　　　　　　　 　 카페주소, 최소배달시간, 최대배달시간
		if (input == 1) {
			setCafeInfo();
			return;
		}
		// [카페정보수정]
		// 수정 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처,
		// 　　　　　　　 　 카페주소, 최소배달시간, 최대배달시간
		else if (input == 2) {
			modifyCafeInfo();
			return;
		} else if (input == 0) {
			System.out.println("카페정보관리를 종료하고 관리자메뉴로 돌아갑니다.");
			return;
		}
		System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
		return;
	}
	
	/**
	 * [카페정보 입력하기]<br>
	 * 카페에대한 정보를 입력합니다.<br>
	 * 입력 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처,<br>
	 * 　　　　　　　 　  카페주소, 최소배달시간, 최대배달시간<br>
	 * Date: 2021-07-29
	 * @author 박인영
	 */
	@Override
	public void setCafeInfo() {
		cafe.setCafeName(nextLine("상호명을 입력하세요. > "));
		cafe.setOpenTime(nextLine("오픈시간을 입력하세요.(ex. 08:00) > "));
		cafe.setCloseTime(nextLine("마감시간을 입력하세요.(ex. 20:00) > "));
		cafe.setHoliday(nextLine("휴무일을 입력하세요. > "));
		cafe.setPhoneNumber(nextLine("카페연락처를 입력하세요.\n특수기호(-)를 포함하여 입력하세요. > "));
		cafe.setCafeAddress(nextLine("카페주소를 입력하세요. > "));
		cafe.setDeliveryTimeMin(nextInt("최소배달시간을 입력하세요.\n(숫자만 입력하세요. 단위: 분) > "));
		cafe.setDeliveryTimeMax(nextInt("최대배달시간을 입력하세요.\n(숫자만 입력하세요. 단위: 분) > "));
		listCafeInfo();
		System.out.print("카페정보가 위와 같이 입력되었습니다.");
		System.out.println("관리자메뉴로 돌아갑니다. ");
	}

	/**
	 * [카페정보 조회하기]
	 * 입력된 카페정보를 조회합니다.
	 * 조회 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처,
	 * 　　　　　　　　　카페주소, 최소배달시간, 최대배달시간
	 * Date: 2021-07-29
	 * @author 박인영
	 */
	@Override
	public void listCafeInfo() {
		System.out.println(cafe.toString());
	}

	/**
	 * [카페정보 수정하기]
	 * 입력된 카페정보를 개별적으로 수정합니다.
	 * 수정 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처,
	 * 　　　　　　　 　  카페주소, 최소배달시간, 최대배달시간
	 * Date: 2021-07-29
	 * @author 박인영
	 */
	@Override
	public void modifyCafeInfo() {
		System.out.println("카페정보수정입니다.");
		System.out.println("--------------------------------------------------------------");
		System.out.println("1.상   호   명　　　2.오 픈  시 간　　　3.마 감  시 간");
		System.out.println("4.휴   무   일　　　5.카 페 연락처　　　6.카 페  주 소");
		System.out.println("7.최소배달시간　　　8.최대배달시간　　　0.이 전  화 면");
		System.out.println("--------------------------------------------------------------");
		int kind = nextInt("수정하려는 항목을 숫자로 입력하세요. > ");
		switch (kind) {
		case 1:	// 상호명 수정
			cafe.setCafeName(nextLine("상호명을 입력하세요. > "));
			completeModifyInfo();
			break;
		case 2:	// 오픈시간 수정
			cafe.setOpenTime(nextLine("오픈시간을 입력하세요.(ex. 08:00) > "));
			completeModifyInfo();
			break;
		case 3:	// 마감시간 수정
			cafe.setCloseTime(nextLine("마감시간을 입력하세요.(ex. 20:00) > "));
			completeModifyInfo();
			break;
		case 4:	// 휴무일 수정
			cafe.setHoliday(nextLine("휴무일을 입력하세요. > "));
			completeModifyInfo();
			break;
		case 5:	// 카페연락처 수정
			System.out.println("카페연락처를 입력하세요.");
			cafe.setPhoneNumber(nextLine("특수기호(-)를 포함하세요. > "));
			completeModifyInfo();
			break;
		case 6:	// 카페주소 수정
			cafe.setCafeAddress(nextLine("카페주소를 입력하세요. > "));
			completeModifyInfo();
			break;
		case 7:	// 최소배달시간 수정
			cafe.setDeliveryTimeMin(nextInt("최소배달시간을 입력하세요.\n" + 
										    "(숫자만 입력하세요. 단위: 분) > "));
			completeModifyInfo();
			break;
		case 8:	// 최대배달시간 수정
			cafe.setDeliveryTimeMax(nextInt("최대배달시간을 입력하세요.\n" +
											"(숫자만 입력하세요. 단위: 분) > "));
			completeModifyInfo();
			break;
		case 0:	// 이전화면
			System.out.println("수정을 종료하고 관리자메뉴로 돌아갑니다.");
			break;
		default:
			System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
			break;
		}
	}

	/**
	 * [카페정보 수정 완료]<br>
	 * 카페정보가 수정이 완료되었을 때 수정된 카페정보를 조회하고<br>
	 * "카페정보가 아래와 같이 수정되었습니다." 등의 메세지를 띄웁니다.<br>
	 * Date: 2021-08-01
	 * @author 박인영
	 */
	@Override
	public void completeModifyInfo() {
		System.out.println(cafe.toString());
		System.out.println("카페정보가 위와 같이 수정되었습니다.");
		System.out.println("관리자메뉴로 돌아갑니다.");
	}
	
	
	/* ------------------------------ 메뉴 관리 ------------------------------ */

	/**
	 * [메뉴 관리하기]<br>
	 * 관리 항목: 메뉴조회, 메뉴추가, 메뉴수정, 메뉴삭제<br>
	 * Date: 2021-08-01
	 * @author 박인영
	 */
	@Override
	public void manageMenu() {
		int input = nextInt("메뉴관리입니다. 원하시는 메뉴를 숫자로 입력하세요.\n" +
									 "--------------------------------------------------------------\n" +
				 					 "1.메뉴조회   2.메뉴추가   3.메뉴수정   4.메뉴삭제   0.이전화면 > ");
		// [메뉴조회]
		// 입력된 메뉴들을 조회합니다.
		// 조회 가능한 정보: 메뉴코드, 메뉴명, 가격,
		// 　　　　　　　 　 공급량, 판매량, 주문가능수량
		if (input == 1) {
			listMenus();
			return;
		}
		// [메뉴추가]
		// 메뉴리스트에 신규 메뉴를 추가합니다.
		// 메뉴 추가시 함께 입력해야할 정보: 메뉴코드, 메뉴명, 가격, 공급량
		else if (input == 2) {
			addMenu();
			return;
		}
		// [메뉴수정]
		// 입력된 메뉴를 수정합니다.
		// 수정 가능한 정보: 메뉴명, 가격, 공급량
		else if (input == 3) {
			modifyMenu();
			return;
		}
		// [메뉴삭제]
		// 잘 못 입력된 메뉴나 더이상 판매하지 않는 메뉴를 삭제합니다.
		else if (input == 4) {
			removeMenu();
			return;
		} else if (input == 0) {
			System.out.println("메뉴관리를 종료하고 관리자메뉴로 돌아갑니다. ");
			return;
		}
		System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
		return;
	}
	
	/**
	 * [메뉴 추가하기]<br>
	 * 메뉴리스트에 신규 메뉴를 추가합니다.<br>
	 * 메뉴 추가시 함께 입력해야할 정보: 메뉴코드, 메뉴명, 가격, 공급량<br>
	 * Date: 2021-08-01
	 * @author 박인영
	 */
	@Override
	public void addMenu() {
		int menuCode = nextInt("--------------------------------------------------------------\n" +
							   "추가하려는 메뉴의 메뉴코드를 입력하세요.\n" + 
							   "(이전화면으로 가시려면 0을 입력하세요.) > ");
		if(menuCode == 0) {
			System.out.println("메뉴추가를 종료하고 관리자메뉴로 돌아갑니다.");
			return;
		}
		if (findMenuBy(menuCode) != null) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("해당 메뉴코드는 이미 등록된 [" + findMenuBy(menuCode).getMenuName() + "]의 메뉴코드입니다.");
			System.out.println("메뉴코드를 확인하세요. 관리자메뉴로 돌아갑니다. ");
			return;
		}
		menus.add(new Menu(menuCode
						 , nextLine("메뉴명을 입력하세요. > ")
						 , nextInt("메뉴의 가격을 입력하세요. > ")
						 , nextInt("메뉴의 공급량을 입력하세요. (단위: 개) > ")));
		System.out.println("메뉴가 추가되었습니다.");
		int input2 = nextInt("추가된 메뉴를 조회하시려면 1을, 관리자메뉴로 돌아가려면 2를 입력하세요. > ");
		if(input2 == 1) {
			listMenu(findMenuBy(menuCode));
			return;
		}
		else if(input2 == 2){
			System.out.println("메뉴추가를 종료하고 관리자메뉴로 돌아갑니다.");
			return;
		}
		else {
			System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
			return;
		}
	}
	
	/**
	 * [메뉴조회 타이틀]<br>
	 * Date: 2021-08-10
	 * @author 박인영
	 */
	@Override
	public void printMenuTitle() {
		System.out.println("==============================================================");
		System.out.println(" 메뉴 　　　　　 　 　　　　　　　　　 　　 　　 　 주　문 ");
		System.out.println(" 코드 　　　메 뉴 명　　가 격　　공급량　판매량　　가능수량");
		System.out.println("==============================================================");
	}
	
	/**
	 * [메뉴 조회하기]<br>
	 * 메뉴 수정전에 수령하려는 메뉴의 저장 정보를 확인하기 위해  해당 메뉴를 조회합니다.<br>
	 * 조회 가능한 정보: 메뉴코드, 메뉴명, 가격, 공급량, 판매량, 주문가능수량<br>
	 * Date: 2021-08-06
	 * @author 박인영
	 */
	@Override
	public void listMenu(Menu menu) {
		System.out.println("해당 메뉴코드는 [" + menu.getMenuName() + "]의 메뉴코드입니다.");
		printMenuTitle();
		System.out.printf("%6d　　%8s\t　%5d　　%4d　　%4d　　　%4d%n"
						, menu.getMenuCode(), menu.getMenuName()
						, menu.getMenuPrice(), menu.getSupply()
						, menu.getDmand(), menu.getOrderableCount());
		System.out.println("==============================================================");
	}
	
	/**
	 * [메뉴리스트 조회하기]<br>
	 * 입력된 메뉴들을  조회합니다.<br>
	 * 조회 가능한 정보: 메뉴코드, 메뉴명, 가격, 공급량, 판매량, 주문가능수량<br>
	 * Date: 2021-07-31
	 * @author 박인영
	 */
	@Override
	public void listMenus() {
		printMenuTitle();
		for(int i = 0 ; i < menus.size() ; i++) {
			System.out.printf("%6d　　%8s\t　%5d　　%4d　　%4d　　　%4d%n"
					, menus.get(i).getMenuCode(), menus.get(i).getMenuName()
					, menus.get(i).getMenuPrice(), menus.get(i).getSupply()
					, menus.get(i).getDmand(), menus.get(i).getOrderableCount());
		}
		System.out.println("==============================================================");
	}
		
	/**
	 * [메뉴 수정하기]<br>
	 * 입력된 메뉴를 수정합니다.<br>
	 * 수정 가능한 정보: 메뉴명, 가격, 공급량<br>
	 * Date: 2021-08-03
	 * @author 박인영
	 */
	@Override
	public void modifyMenu() {
		int modifyMenuCode = nextInt("수정하시려는 메뉴의 메뉴코드를 입력하세요.\n" +
									"(이전화면으로 가시려면 0을 입력하세요.) > ");
		if(modifyMenuCode == 0) {
			System.out.print("메뉴수정를 종료하고 관리자메뉴로 돌아갑니다. ");
			return;
		}
		// [메뉴코드 등록확인]
		// 수정하려는 메뉴가 메뉴리스트에 존재하는지 확인합니다.
		// 메뉴리스트에 없으면 메뉴수정을 종료합니다.
		if(findMenuBy(modifyMenuCode) == null) {
			System.out.println("입력하신 숫자와 일치하는 메뉴코드가 없습니다.");
			System.out.println("메뉴수정을 종료하고 관리자메뉴로 돌아갑니다. ");
			return;
		}
		// [수정메뉴 확인]
		// 메뉴 수정 전 해당 메뉴의 정보를 확인합니다.
		listMenu(findMenuBy(modifyMenuCode));
		// [수정항목 선택]
		int kind = nextInt("수정하려는 항목을 입력하세요.\n" + 
						   "--------------------------------------------------------------\n" +
						   "1.메뉴명 수정　　2.가격 수정　　3.공급량 추가　　0.관리자 화면 > ");
		switch (kind) {
		// [메뉴명 수정]
		// 메뉴명을 수정합니다.
		case 1:	
			findMenuBy(modifyMenuCode).setMenuName(nextLine("메뉴명을 입력하세요. > "));
			completeModifyMenu(findMenuBy(modifyMenuCode));
			break;
		// [가격 수정]
		// 메뉴의 가격을 수정합니다.
		case 2:	
			findMenuBy(modifyMenuCode).setMenuPrice(nextInt("가격을 입력하세요. (단위: 원) > "));
			completeModifyMenu(findMenuBy(modifyMenuCode));
			break;
		// [공급량 추가]
		// 메뉴의 공급량을 추가합니다. 
		case 3:
			findMenuBy(modifyMenuCode).setSupply(nextInt("추가될 공급량을 입력하세요. (단위: 개) > "));
			completeModifyMenu(findMenuBy(modifyMenuCode));
			break;
		case 0:
			System.out.println("메뉴수정을 종료하고 관리자메뉴로 돌아갑니다.");
			break;
		default:
			System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
			break;
		}
	}
	
	/**
	 * [수정한 메뉴 확인]<br>
	 * 메뉴 수정 후 잘 반영되었는지 확인할 수 있도록 <br>
	 * 해당 메뉴를 조회합니다.<br>
	 * Date: 2021-08-03
	 * @author 박인영
	 */
	@Override
	public void completeModifyMenu(Menu menu) {
		listMenu(menu);
		System.out.println("메뉴가 위와 같이 수정되었습니다.");
		System.out.println("메뉴수정을 종료하고 관리자메뉴로 돌아갑니다.");
	}

	/**
	 * [메뉴 삭제하기]<br>
	 * 잘못 입력된 메뉴나 더이상 판매하지 않는 메뉴를 삭제합니다.<br>
	 * 판매를 중지하는 경우, 메뉴를 삭제하는 것보다는<br>
	 * 공급량을 수정하여 주문가능수량이 0이 되도록 하여,<br>
	 * 지난 공급량과 판매량 정보를 잃지 않는 것이 좋습니다.<br>
	 * Date: 2021-08-03
	 * @author 박인영
	 */
	@Override
	public void removeMenu() {
		int removeMenuCode = nextInt("삭제하시려는 메뉴의 메뉴코드를 입력하세요.\n" +
									"(이전화면으로 가시려면 0을 입력하세요.) > ");
		if(removeMenuCode == 0) {
			System.out.println("메뉴삭제를 종료하고 관리자메뉴로 돌아갑니다. ");
			return;
		}
		// [메뉴코드 등록확인]
		// 삭제하려는 메뉴가 메뉴리스트에 존재하는지 확인합니다.
		// 메뉴리스트에 없으면 메뉴삭제를 종료합니다.
		if(findMenuBy(removeMenuCode) == null) {
			System.out.println("입력하신 숫자와 일치하는 메뉴코드가 없습니다.");
			System.out.println("메뉴삭제를 종료하고 관리자메뉴로 돌아갑니다. ");
			return;
		}
		// [메뉴삭제 재확인]
		// 메뉴코드에 해당되는 메뉴를 안내하고 삭제 여부를 확인한다.
		System.out.println("--------------------------------------------------------------");
		System.out.println("[" + findMenuBy(removeMenuCode).getMenuName() + "] 메뉴를 삭제하시겠습니까?");
		int removeCheck = nextInt("1.해당메뉴삭제  2.메뉴삭제취소 > ");
		if(removeCheck == 1) {
			menus.remove(findMenuBy(removeMenuCode));
			System.out.println("메뉴가 삭제되었습니다. 관리자메뉴로 돌아갑니다.");
			return;
		}
		else if(removeCheck == 2) {
			System.out.println("메뉴삭제를 취소하고 관리자메뉴로 돌아갑니다.");
			return;
		}
		else {
			System.out.println("입력이 올바르지 않습니다. 관리자메뉴로 돌아갑니다.");
			return;
		}
	}
	
	
	/* ------------------------------ 멤버 조회 ------------------------------ */

	/**
	 * [맴버/회원 조회하기]<br>
	 * 멤버는 구분에 "멤버"가 기록되며 재직중인 경우 "(재직중)"이 함께 표시됩니다.<br>
	 * 회원은 구분에 "회원"이 기록됩니다.<br>
	 * Date: 2021-08-04, 2021-08-09
	 * @author 박인영
	 */
	@Override
	public void listPersons() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("Online Order Service에 가입한 [" + persons.size() + "명]의 멤버 및 회원을 조회합니다.");
		System.out.println("멤버는 구분에 \"멤버\"와 소속호수가 기록되며");
		System.out.println("멤버가 재직중인 경우 재직여부에 \"V\"가 표시됩니다.");
		System.out.println("회원은 구분에 \"회원\"이 기록됩니다.");
		System.out.println("==============================================================");
		System.out.println("　 ID　　 이 름　　　　연락처　　　구분　 소속호수　 재직여부");
		System.out.println("==============================================================");
		// [재직여부 확인]
		// 퇴사자는 마일리지 적립혜택을 받을 수 없기 때문에
		// 멤버의 재직여부 확인이 필요합니다.
		// 반복문을 이용하여 멤버ID와 일치하는 사원ID가 사원리스트에 있는지 확인합니다.
		for (int i = 0; i < persons.size(); i++) {
			String workCheck = "";
			for (int j = 0; j < employees.size(); j++) {
				if(persons.get(i).getId() == employees.get(j).getEmployeeID()) {
					workCheck = "V" ;
					break;
				}
			}
			String str = "";
			if (persons.get(i) instanceof Member) {
				str = "멤버　　 " + ((Member)persons.get(i)).getAdress() + "호";
			}
			else if (persons.get(i) instanceof User) {
				str = "회원";
			}
			else {
				str = "관리자";
			}
			System.out.printf("%6s　%4s　%15s　 %s　　　%s %n"
							, persons.get(i).getId()
							, persons.get(i).getName()
							, persons.get(i).getPhone()
							, str
							, workCheck);
		}
		System.out.println("--------------------------------------------------------------");
		System.out.print("관리자메뉴로 돌아갑니다.");
	}
	
	
	/* ------------------------------ 주문 관리 ------------------------------ */

	/**
	 * [주문리스트 조회하기]<br>
	 * 주문 들어온 정보를 조회합니다.<br>
	 * 조회 가능한 정보: 오더코드, 주문자ID, 주문자명, 주문자연락처, 배달주소,<br>
	 * 　　　　　 　 장바구니주문수량합, 제조예상시간, 배달예상시간, 배달시간,<br>
	 * 　　　　　 　 장바구니코드, 결제금액, 결제방법, 메뉴, 메뉴수량 <br>
	 * Date: 2021-07-29
	 * @author 윤인호,박인영,김동휘,주현준
	 */
	@Override
	public void listOrders() {
		System.out.println("=======================================================================");
		System.out.println("　 주문코드 　 주문자명　주문방식　　　　　　　소요시간　　주문목록　　");
		System.out.println("=======================================================================");
		for (int i = 0; i < orders.size(); i++) {
			String str = "";
			String adress = "";
			String time = "";
			if(orders.get(i).getDeliveryInfo().isDeliveryCheck() == true) {
				str = "배달";
				adress = "(배달주소: " + ((Member)orders.get(i).getPersonInfo()).getAdress() + "호)";
				time = orders.get(i).getDeliveryInfo().getDeliveryTime() + "분";
			}
			else {
				str = "픽업　　　　";
				time = orders.get(i).getDeliveryInfo().getOrderMakingTime() + "분";
			}
			System.out.printf("%14s　%3s　%2s%9s　 %4s　　　%s %n"
							, orders.get(i).getOrderCode()
							, orders.get(i).getPersonInfo().getName()
							, str
							, adress
							, time
							, orders.get(i).getOrderMenus()
			);
		}
		System.out.println("=======================================================================");
		System.out.println("총 [" + orders.size() + "]건의 주문내역을 조회하였습니다.");
		System.out.println("관리자메뉴로 돌아갑니다.");
	}

	
	/* ------------------------------ 매출 관리 ------------------------------ */

	/**
	 * [매출 조회하기]<br>
	 * 매출을 조회합니다.<br>
	 * 조회 가능한 정보: 카드결제매출, 현금결제매출, 마일리지결제매출<br>
	 * Date: 2021-07-30
	 * @author 박인영
	 */
	@Override
	public void listSales() {
		System.out.println("--------------------------------------------------------------");
		System.out.println("=======================================================================");
		System.out.println("　 주문코드 　　　총결제금액　　카드결제금액　　마일리지결제금액");
		System.out.println("=======================================================================");
		int sumTotalPayment = 0;
		int sumCardPayment = 0;
		int sumtMileagePayment = 0;
		for (int i = 0; i < orders.size(); i++) {
			sumTotalPayment += orders.get(i).getPaymentInfo().getTotalPayment();
			sumCardPayment += orders.get(i).getPaymentInfo().getCardPayment();
			sumtMileagePayment += orders.get(i).getPaymentInfo().getMileagePayment();
			System.out.printf("%14s　%10d　　%10d　　　%10d %n"
							, orders.get(i).getOrderCode()
							, orders.get(i).getPaymentInfo().getTotalPayment()
							, orders.get(i).getPaymentInfo().getCardPayment()
							, orders.get(i).getPaymentInfo().getMileagePayment()
			);
		}
		System.out.println("=======================================================================");
		System.out.printf("　 합　　계 　　 %10d　　%10d　　　%10d %n"
						, sumTotalPayment
						, sumCardPayment
						, sumtMileagePayment
		);
		System.out.println("=======================================================================");
		System.out.println("총 [" + orders.size() + "]건의 매출내역을 조회하였습니다.");
		System.out.println("관리자메뉴로 돌아갑니다.");
	}

}