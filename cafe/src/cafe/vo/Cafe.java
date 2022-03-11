package cafe.vo;

/**
 * 카페정보 클래스<br>
 * Date: 2021-07-28
 * @author 박인영
 */
public class Cafe {
	
	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [상호]<br>
	 * 카페의 이름입니다.<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private String cafeName;
	
	/**
	 * [오픈시간]<br>
	 * 카페 영업 시작 시간입니다.<br>
	 * (작성예시. 08:00)<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private String openTime;
	
	/**
	 * [마감시간]<br>
	 * 카페 영업 종료 시간입니다.<br>
	 * (작성예시. 20:00)<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private String closeTime;
	
	/**
	 * [휴무일]<br>
	 * 카페 영업을 하지 않는 날입니다.<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private String holiday;
	
	/**
	 * [카페연락처]<br>
	 * 카페의 전화번호입니다.<br>
	 * (작성예시. 02-1234-5678)<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private String phoneNumber;
	
	/**
	 * [카페주소]<br>
	 * 카페가 영업하고 있는 주소입니다.<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private String cafeAddress;
	
	/**
	 * [최소배달시간] (단위: 분)<br>
	 * 배달하는데 걸리는 최소 시간입니다.<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private int deliveryTimeMin;
	
	/**
	 * [최대배달시간] (단위: 분)<br>
	 * 배달하는데 걸리는 최대 시간입니다.<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	private int deliveryTimeMax;
	
	
	/* ------------------------------ 생성자 ------------------------------ */
	
	/**
	 * 카페정보 클래스의 기본 생성자<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	public Cafe() {}
	
	/**
	 * 카페정보 클래스의 생성자<br>
	 * Date: 2021-07-28
	 * @param cafeName 상호명
	 * @param openTime 오픈시간 (ex. 08:00)
	 * @param closeTime 마감시간 (ex. 20:00)
	 * @param holiday 휴무일
	 * @param phoneNumber 카페연락처 (ex. 02-1234-5678)
	 * @param cafeAddress 카페주소
	 * @param deliveryTimeMin 최소배달시간 (단위: 분)
	 * @param deliveryTimeMax 최대배달시간 (단위: 분)
	 * @author 박인영
	 */
	public Cafe(String cafeName, String openTime, String closeTime, String holiday, String phoneNumber,
			String cafeAddress, int deliveryTimeMin, int deliveryTimeMax) {
		this.cafeName = cafeName;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.holiday = holiday;
		this.phoneNumber = phoneNumber;
		this.cafeAddress = cafeAddress;
		this.deliveryTimeMin = deliveryTimeMin;
		this.deliveryTimeMax = deliveryTimeMax;
				
	}
	
	
	/* ------------------------------ getter & setter ------------------------------ */
	
	/**
	 * 카페명 반환하기<br>
	 * Date: 2021-07-28
	 * @return cafeName 카페명
	 * @author 박인영
	 */
	public String getCafeName() {
		return cafeName;
	}

	/**
	 * 카페명 입력하기<br>
	 * Date: 2021-07-28
	 * @param cafeName 카페명
	 * @author 박인영
	 */
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	/**
	 * 오픈시간 반환하기<br>
	 * Date: 2021-07-28
	 * @return openTime 오픈시간
	 * @author 박인영
	 */
	public String getOpenTime() {
		return openTime;
	}

	/**
	 * 오픈시간 입력하기<br>
	 * Date: 2021-07-28
	 * @param openTime 오픈시간
	 * @author 박인영
	 */
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	
	/**
	 * 마감시간 반환하기<br>
	 * Date: 2021-07-28
	 * @return closeTime 마감시간
	 * @author 박인영
	 */
	public String getCloseTime() {
		return closeTime;
	}

	/**
	 * 마감시간 입력하기<br>
	 * Date: 2021-07-28
	 * @param closeTime 마감시간
	 * @author 박인영
	 */
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	/**
	 * 휴무일 반환하기<br>
	 * Date: 2021-07-28
	 * @return holiday 휴무일
	 * @author 박인영
	 */
	public String getHoliday() {
		return holiday;
	}

	/**
	 * 휴무일 입력하기<br>
	 * Date: 2021-07-28
	 * @param holiday 휴무일
	 * @author 박인영
	 */
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	/**
	 * 카페연락처 반환하기<br>
	 * Date: 2021-07-28
	 * @return phoneNumber 카페연락처
	 * @author 박인영
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 카페연락처 입력하기<br>
	 * Date: 2021-07-28
	 * @param phoneNumber 카페연락처
	 * @author 박인영
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 까페주소 반환하기<br>
	 * Date: 2021-07-28
	 * @return cafeAddress 까페주소
	 * @author 박인영
	 */
	public String getCafeAddress() {
		return cafeAddress;
	}

	/**
	 * 카페주소 입력하기<br>
	 * Date: 2021-07-28
	 * @param cafeAddress 카페주소
	 * @author 박인영
	 */
	public void setCafeAddress(String cafeAddress) {
		this.cafeAddress = cafeAddress;
	}

	/**
	 * 최소배달시간 반환하기<br>
	 * Date: 2021-07-28
	 * @return deliveryTimeMin 최소배달시간 (단위: 분)
	 * @author 박인영
	 */
	public int getDeliveryTimeMin() {
		return deliveryTimeMin;
	}

	/**
	 * 최소배달시간 입력하기<br>
	 * Date: 2021-07-28
	 * @param deliveryTimeMin 최소배달시간 (단위: 분)
	 * @author 박인영
	 */
	public void setDeliveryTimeMin(int deliveryTimeMin) {
		this.deliveryTimeMin = deliveryTimeMin;
	}

	/**
	 * 최대배달시간 반환하기<br>
	 * Date: 2021-07-28
	 * @return deliveryTimeMax 최대배달시간 (단위: 분)
	 * @author 박인영
	 */
	public int getDeliveryTimeMax() {
		return deliveryTimeMax;
	}

	/**
	 * 최대배달시간 입력하기<br>
	 * Date: 2021-07-28
	 * @param deliveryTimeMax 최대배달시간 (단위: 분)
	 * @author 박인영
	 */
	public void setDeliveryTimeMax(int deliveryTimeMax) {
		this.deliveryTimeMax = deliveryTimeMax;
	}

	
	/* ------------------------------ toString ------------------------------ */
	
	/**
	 * [카페정보 toString]<br>
	 * 카페정보 조회를 위한 toString입니다.<br>
	 * Date: 2021-07-28
	 * @author 박인영
	 */
	@Override
	public String toString() {
		return "==============================================================\r\n" +
			   "　카페이름: " + cafeName + "\n" + 
			   "　영업시간: " + openTime + " ~ " + closeTime + "\n" +
			   "　　휴무일: " + holiday + "\n" + 
			   "　　연락처: " + phoneNumber + "\n" +
			   "　　　주소: " + cafeAddress + "\n" +
			   "　배달시간: " + deliveryTimeMin + " ~ " + deliveryTimeMax + "분\n" + 
			   "==============================================================";
	}

}