package basic.ex01;

public class Hotel {
	
	 private Restaurant res;//여기 지금 null 밑에 생성자에 값 넣어주
	
	 public Hotel(Restaurant res) {
		 System.out.println("호텔이 생성됨!");
		 this.res = res;
	 }
	 
	 public void reserveRestaurant() {
		 System.out.println("레스토랑을 예약합니다.");
		 res.orderDinner();
		 
	 }

}
