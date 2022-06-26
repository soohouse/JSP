package kr.co.jsp.user.model;

public interface IUserDAO {
	
	//중복 ID 여부를 검증하는 메서드
	boolean confirmID(String id);
	
	//회원 가입을 처리하는 메서드
	void insertUser(UserVO vo);
	
	//로그인 유효성을 검증하는 메서드
	int usercheck(String id, String pw);
	
	//특정 회원의 모든 정보를 가져오는 메서드
	UserVO getUserInfo(String id);
	
	//비밀번호를 변경하는 메서드
	void changePassword(String id, String newPW);
	
	//회원 정보를 수정하는 메서드
	void updateUser(UserVO vo);
	
	//회원 탈퇴를 처리할 메서드
	void deleteUser (String id);

}
