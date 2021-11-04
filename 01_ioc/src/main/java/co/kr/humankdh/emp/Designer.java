package co.kr.humankdh.emp;

public class Designer extends Emp {

	@Override
	public Emp getEmp() {
		return this;
	}

	@Override
	public void work() {
		System.out.println("디자이너가 개발을 합니다.");
	}
	
	
	
}
