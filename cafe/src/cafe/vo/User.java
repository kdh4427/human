package cafe.vo;

/**
 * < Person > 프로그램 이용자<br>
 * ├ Member : 멤버 (마일리지 적립/사용, 배달 /픽업 가능)<br>
 * ├ User : 회원 (픽업만 가능)<br>
 * └ Manager : 관리자
 */
public class User extends Person {
	
	/* ------------------------------ 생성자 ------------------------------ */
	
	public User() {	}

	public User(String id, String pw, String name, String phone, String cardNum, String cardPw) {
		super(id, pw, name, phone, cardNum, cardPw);
	}

	/* ------------------------------ 메서드 ------------------------------ */
	
	@Override
	public String getMe() {
		return "회원";
	}

}	
	
	
	

	
	
