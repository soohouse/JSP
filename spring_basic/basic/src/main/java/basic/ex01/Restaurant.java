package basic.ex01;

public class Restaurant {
	
	private Chef chef;

	public Restaurant() {
		System.out.println("레스토랑이 생성됨!");
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void orderDinner() {
		System.out.println("저녁 식사를 주문받습니다.");
		chef.cook();
	}

	
}
