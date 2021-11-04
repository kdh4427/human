package co.kr.humankdh.emp;

public abstract class Emp {
	public Emp getEmp(){
		return this;
		
	}
	
	public void work(){
		getEmp().work();
		
	}
}
