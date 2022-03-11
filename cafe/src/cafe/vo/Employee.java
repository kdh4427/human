package cafe.vo;

/**
 * 사원 클래스<br><br>
 * Date: 2021-08-04
 * @author 박인영
 */
public class Employee {

	/* ------------------------------ 멤버변수 ------------------------------ */
	
	/**
	 * [사원ID]<br>
	 * 사원이 입사하면 부여받는 고유ID입니다.<br>
	 * 인사팀에서 받는 사원리스트에서 사원ID를 조회할 수 있습니다.<br>
	 * 사원이 Online Order Service의 멤버로 가입할 때 이 값이 멤버ID가 됩니다.<br><br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	private String employeeID;
	
	/**
	 * [사원이름]<br>
	 * 사원의 이름입니다.<br>
	 * 인사팀에서 받는 사원리스트에서 사원이름를 조회할 수 있습니다.<br>
	 * 이 조회정보를 이용하여 사원이 Online Order Service의 멤버로 가입할 때<br>
	 * 이름을 입력하지 않습니다.<br><br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	private String employeeName;
	
	/**
	 * [사원연락처]<br>
	 * 입사 당시 인사팀에 입력된 사원의 연락처입니다.<br>
	 * 인사팀에서 받는 사원리스트에서 사원연락처를 조회할 수 있습니다.<br>
	 * 이 조회정보를 이용하여 사원이 Online Order Service의 멤버로 가입할 때<br>
	 * 연락처을 입력하지 않습니다.<br>
	 * 이 값은 멤버 등록시에만 불러오는 값이므로<br>
	 * 인사팀에 등록된 연락처가 변동되어도 멤버정보가 같이 변동되지 않습니다.<br><br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	private String employeePhoneNum;
	
	/**
	 * [사원부서]<br>
	 * 입사 당시 인사팀에 입력된 사원의 소속 부서입니다.<br>
	 * 인사팀에서 받는 사원리스트에서 사원부서를 조회할 수 있습니다.<br>
	 * 이 값은 멤버 등록시에만 사원 확인용으로 불러오는 값입니다.<br><br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	private String department;
	
	/**
	 * [사원부서주소]<br>
	 * 사원이 소속된 본사 부서의 호수입니다. (ex. 506호)<br>
	 * 인사팀에서 받는 사원리스트에서 사원부서주소를 조회할 수 있습니다.<br>
	 * 사원이 Online Order Service의 멤버로 가입할 때<br>
	 * 이 조회정보가 배달주소로 입력됩니다.<br><br>
	 * 가상부서호수: 301 경리부<br>
	 * 　　　　　　　402 기술지원부<br>
	 * 　　　　　　　503 기획부<br>
	 * 　　　　　　　604 마케팅부<br>
	 * 　　　　　　　705 영업부<br>
	 * 　　　　　　　801 인사부<br>
	 * 　　　　　　　902 총무부<br>
	 * 　　　　　　　903 홍보부<br><br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	private String departmentAdress;

	
	/* ------------------------------ 생성자 ------------------------------ */
	
	/**
	 * 사원 클래스의 기본 생성자<br><br>
	 * Date: 2021-08-04
	 * @author 박인영
	 */
	public Employee() {}

	/**
	 * 사원 클래스의 생성자<br><br>
	 * Date: 2021-08-04
	 * @param employeeID 사원ID
	 * @param employeeName 사원이름
	 * @param employeePhoneNum 사원연락처
	 * @param department 소속부서
	 * @param departmentAdress 부서호수
	 * @author 박인영
	 */
	public Employee(String employeeID, String employeeName, String employeePhoneNum, String department,
			String departmentAdress) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeePhoneNum = employeePhoneNum;
		this.department = department;
		this.departmentAdress = departmentAdress;
	}
	
	
	/* ------------------------------ getter & setter ------------------------------ */
	
	/**
	 * 사원ID 반환하기<br><br>
	 * Date: 2021-08-04
	 * @return employeeID 사원ID
	 * @author 박인영
	 */ 
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * 사원ID 입력하기<br><br>
	 * Date: 2021-08-04
	 * @param employeeID 사원ID
	 * @author 박인영
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * 사원이름 반환하기<br><br>
	 * Date: 2021-08-04
	 * @return employeeName 사원이름
	 * @author 박인영
	 */ 
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * 사원이름 입력하기<br><br>
	 * Date: 2021-08-04
	 * @param employeeName 사원이름
	 * @author 박인영
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * 사원연락처 반환하기<br><br>
	 * Date: 2021-08-04
	 * @return employeePhoneNum 사원연락처
	 * @author 박인영
	 */ 
	public String getEmployeePhoneNum() {
		return employeePhoneNum;
	}

	/**
	 * 사원연락처 입력하기<br><br>
	 * Date: 2021-08-04
	 * @param employeePhoneNum 사원연락처
	 * @author 박인영
	 */
	public void setEmployeePhoneNum(String employeePhoneNum) {
		this.employeePhoneNum = employeePhoneNum;
	}

	/**
	 * 소속부서 반환하기<br><br>
	 * Date: 2021-08-04
	 * @return department 소속부서
	 * @author 박인영
	 */ 
	public String getDepartment() {
		return department;
	}

	/**
	 * 소속부서 입력하기<br><br>
	 * Date: 2021-08-04
	 * @param department 소속부서
	 * @author 박인영
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 부서호수 반환하기<br><br>
	 * Date: 2021-08-04
	 * @return departmentAdress 부서호수
	 * @author 박인영
	 */ 
	public String getDepartmentAdress() {
		return departmentAdress;
	}

	/**
	 * 부서호수 입력하기<br><br>
	 * Date: 2021-08-04
	 * @param departmentAdress 부서호수
	 * @author 박인영
	 */
	public void setDepartmentAdress(String departmentAdress) {
		this.departmentAdress = departmentAdress;
	}

	@Override
	public String toString() {
		return "인사팀에 등록된 사원 [" + getEmployeeName() + "]님의 정보를 불러옵니다.\r\n" +
			   "--------------------------------------------------------------\r\n" +
			   "　　사원ID: " + getEmployeeID() +"\n" +
			   "　　　이름: " + getEmployeeName() + "\n" +
			   "　　연락처: " + getEmployeePhoneNum() + "\n" +
			   "　소속부서: " + getDepartment() + "\n" +
			   "　부서호수: " + getDepartmentAdress() + "\n" +
			   "--------------------------------------------------------------";
	}
	
}
