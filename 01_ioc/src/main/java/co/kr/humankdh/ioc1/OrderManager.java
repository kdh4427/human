package co.kr.humankdh.ioc1;



public class OrderManager {

	private HyundaiMaker maker;

	public OrderManager() {
		this.maker = new HyundaiMaker();
	}

	public void order() {
		Car car = maker.sell(new Money(8000));
		System.out.println("차량 이름: " + car.getName());
	}
}