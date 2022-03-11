package cafe.ex;

import static cafe.util.CafeCommon.*;
import cafe.service.ManagerServiceImpl;
import cafe.service.UserServiceImpl;

/**
 * [CafeEx 클래스]<br>
 * 대기업 KIKIO 본사 1층에 있는 사내 카페의 Online Order Service입니다.<br>
 * KIKIO 사원분들의 경우 서비스 등록을 해야만 주문이 가능하며,<br>
 * 결제금액의 10%가 마일리지로 적립되어 현금처럼 사용이 가능합니다.<br>
 * 또한 KIKIO 본사는 배달이 가능합니다.<br>
 * KIKIO 사원이 아니더라도 일반 유저의 회원가입 및 주문이 가능하나,<br>
 * 픽업만 가능할 뿐 배달은 KIKIO 본사라도 불가능합니다.
 */
public class CafeEx {
	public static void main(String[] args) {
		
		ManagerServiceImpl ms = new ManagerServiceImpl();
		UserServiceImpl us = new UserServiceImpl();
		
		System.out.println("======================= CAFE KIKIO OOS =======================");
		System.out.println("어서오세요, KIKIO 사내 카페입니다.");
		System.out.println("Online Order Service를 방문해주셔서 감사합니다.");
		System.out.println("OOS로 미리 주문하신 뒤 매장으로 오시면");
		System.out.println("대기없이 음료를 받으실 수 있습니다.");
		System.out.println("등록된 KIKIO 사원분들의 주문에 한하여");
		System.out.println("KIKIO 본사만 배달이 가능한 점 참고해주시기 바랍니다.");
		System.out.println("==============================================================");
		
		while (true) {
			// System.out.println으로 메세지를 나눠서 입력하면
			// 숫자가 아닌 영어 입력시 예외처리 되면서 nextInt 내부 메세지만 반복되므로
			// System.out.println으로 분리하지 않고 결합연산자(+)를 이용하여 문장을 작성하였습니다.
			int input = nextInt("원하시는 서비스를 숫자로 입력해주세요.\r\n" +
								"--------------------------------------------------------------\r\n" +
								"1.카페정보 조회　　　　2.로그인 & 주문하기　　3.회원가입\r\n" +
								"4.멤버 및 회원 메뉴　　5.관리자 메뉴　　　　　0.서비스종료 > ");
			switch (input) {
			
			// [카페정보 조회하기]
			// 카페의 기본정보를 조회합니다.
			// 입력 가능한 정보: 상호명, 오픈시간, 마감시간, 휴무일, 카페연락처, 
			// 　　　　　　　　　카페주소, 최소배달시간, 최대배달시간
			case 1:
				ms.listCafeInfo();
				break;
				
			// [주문하기]
			// 메뉴조회 → 장바구니에 메뉴 담기 → 픽업/배달 선택
			// →→ 배달 선택시 주소지와 배달예상시간 확인 → 결제 → 주문완료
			// →→ 픽업 선택시 픽업가능시간 확인 → 결제 → 주문완료
			case 2:
				us.order();
				break;
				
			// [멤버등록 및 회원가입]
			// 사원들의 Online Order Service 멤버등록 및
			// 비사원 유저의 회원가입이 가능합니다.
			case 3:
				us.addPerson();
				break;
			
			// [멤버 및 회원 메뉴]
			// 멤버 또는 회원의 정보를 조회 및 수정하는 메뉴입니다.
			// 등록정보를 조회 및 수정할 수 있으며
			// 마일리지와 주문내역을 조회할 수 있습니다.
			case 4:
				us.personMenu();
				break;
				
			// [관리자메뉴]
			// 관리자를 위한 메뉴입니다.
			// 카페정보, 메뉴를 추가/수정이 가능하며
			// 멤버와 회원리스트를 조회할 수 있습니다.
			case 5:
				ms.login();
				break;
			
			// [서비스종료]
			case 0:
				System.out.println("서비스를 종료합니다. 이용해주셔서 감사합니다.");
				System.out.println("--------------------------------------------------------------");
				return;
			
			// [예외처리]
			default:
				System.out.println("입력이 올바르지 않습니다.");
				break;
			}
		}
	}
}