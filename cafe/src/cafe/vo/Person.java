package cafe.vo;

/**
 * < Person > 프로그램 이용자<br>
 * ├ Member : 멤버 (마일리지 적립/사용, 배달 /픽업 가능)<br>
 * ├ User : 회원 (픽업만 가능)<br>
 * └ Manager : 관리자
 */
public abstract class Person {
	
	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * < ID > 아이디<br>
	 * ├ memberID : 멤버ID = 사원ID, "K0001"과 같이 맨 앞에 대문자K가 들어감<br>
	 * ├ userID : 회원ID, 영어소문자와 숫자로만 생성 가능<br>
	 * └ managerID : 관리자ID, admin
	 */
	private String id;
	
	// 비밀번호
	private String pw;
	
	// 이름
	private String name;
	
	// 연락처
	private String phone;
	
	// 결제카드
	private String cardNum;
	
	// 카드비밀번호
	private String cardPw;

	
	/* ------------------------------ 생성자 ------------------------------ */
	
	public Person() {}
	
	public Person(String id, String pw, String name, String phone, String cardNum, String cardPw) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.cardNum = cardNum;
		this.cardPw = cardPw;
	}
	
	
	/* ------------------------------ getter & setter ------------------------------ */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCardPw() {
		return cardPw;
	}

	public void setCardPw(String cardPw) {
		this.cardPw = cardPw;
	}
	
	
	/* ------------------------------ toString ------------------------------ */

	@Override
	public String toString() {
		return getMe() + "[" + name + "]" + "님의 등록정보를 조회합니다.\n" +
			   "==============================================================\n"+
			   detail() +
			   "==============================================================";
	}
	
	
	/* ------------------------------ 메서드 ------------------------------ */
	
	public abstract String getMe();
	
	protected String detail() {
		return "　　　　ID: " + id + "\n" +
			   "　　　이름: " + name + "\n" +
			   "　　연락처: " + phone + "\n" +
			   "　결제카드: " + cardNum + "\n" ;
	}
	
}
