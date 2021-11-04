package singleton;

public class Student {
	private static Student student = new Student();
	
	private Student() {}
	
	public static Student getInstance() {
		return new Student();
	}
	
	public static Student getInstance2() {
		return student;
	}
	
	
}
