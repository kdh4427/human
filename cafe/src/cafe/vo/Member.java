package cafe.vo;

/**
 * < Person > 프로그램 이용자<br>
 * ├ Member : 멤버 (마일리지 적립/사용, 배달 /픽업 가능)<br>
 * ├ User : 회원 (픽업만 가능)<br>
 * └ Manager : 관리자
 */
public class Member extends Person {
	
	/* ------------------------------ 멤버변수 ------------------------------ */
	
	// 주소(배달장소)
	private String adress;
	
	// 마일리지
	private int mileage;
	

	/* ------------------------------ 생성자 ------------------------------ */
	
	public Member() {}
	
	public Member(String id, String pw, String name, String phone, String cardNum, String cardPw,
			String adress, int mileage) {
		super(id, pw, name, phone, cardNum, cardPw);
		this.adress = adress;
		this.mileage = mileage;
	}


	/* ------------------------------ getter & setter ------------------------------ */

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	
	/* ------------------------------ 메서드 ------------------------------ */

	@Override
	public String getMe() {
		return "멤버";
	}

	@Override
	protected String detail() {
		return super.detail() +
			   "　배달주소: " + adress + "호\n" +
			   "　마일리지: " + mileage + "원\n" ;
	}
	
}
	

