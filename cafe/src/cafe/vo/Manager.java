package cafe.vo;

/**
 * < Person > 프로그램 이용자<br>
 * ├ Member : 멤버 (마일리지 적립/사용, 배달 /픽업 가능)<br>
 * ├ User : 회원 (픽업만 가능)<br>
 * └ Manager : 관리자
 */
public class Manager extends Person {

	/* ------------------------------ 생성자 ------------------------------ */
	
	public Manager() {}

	public Manager(String id, String pw, String name) {
		super(id, pw, name, null, null, null);
	}

	
	/* ------------------------------ 메서드 ------------------------------ */
	
	@Override
	public String getMe() {
		return "관리자";
	}
	
}
