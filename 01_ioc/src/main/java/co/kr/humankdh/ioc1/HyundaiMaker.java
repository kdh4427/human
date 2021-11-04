package co.kr.humankdh.ioc1;

public class HyundaiMaker {
	public Car sell(Money money) {
		System.out.println("금액: " + money.getAmount());
		return new Car("Genesis g80");
	}
}
