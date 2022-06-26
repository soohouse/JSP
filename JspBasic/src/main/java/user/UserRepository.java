package user;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	
	//회원의 정보를 담아놓을 리스트 (DB 대용)
	private static List<User> userList = new ArrayList<>();
	
	//생성된 User 객체를 리스트에 추가하는 메서드
	public static void save(User user) {
		userList.add(user);
	}
	
	//회원 정보 저장 후 리스트 내부를 보여주는 메서드.
	   public static void showUsers() {
	      System.out.println("### 회원 정보 ###");

	      for(User user : userList) {
	         System.out.println("아이디: " + user.getAccount());
	         System.out.println("비밀번호: " + user.getPassword());
	         System.out.println("이름: " + user.getName());
	         System.out.println("별명: " + user.getNickName());
	         System.out.println("===============================");
	      }
	   }
	   
	   //매개값으로 id를 받아서 해당 id를 가진 객체가 userList에 있는 지 탐색하는 메서드
	   public static User getUser(String id) {
			for(User user : userList) {
				if(user.getAccount().equals(id)) {
					return user;
				}
			}
			return null;
		}
	   
	   //매개값으로 id를 받아서 해당 id를 가진 객체를 userList에서 삭제하는 메서드
	   public static void deleteUser(String id) {
//			for(User user : userList) {
//			if(user.getAccount().equals(id)) {
//				userList.remove(user);
//				return;
//			}
//		}
		   userList.remove(getUser(id));
	   }




	
	   
}
