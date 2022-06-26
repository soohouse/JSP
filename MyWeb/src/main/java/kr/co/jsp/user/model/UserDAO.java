package kr.co.jsp.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.jdbc.proxy.annotation.Pre;

public class UserDAO implements IUserDAO {
	
	private DataSource ds;
	private Context ct;
	
	private UserDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static UserDAO dao = new UserDAO();
	
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	
	
	////////////////////////////////////////////////
	
	//왜 변수선언 안했나요? :더 간단한 방법 try작성 후 ()열고 ()안에 try블록 안에서 사용할 객체를 생성해라
	@Override
	public boolean confirmID(String id) {
		boolean flag = false;
		String sql = "SELECT * FROM my_user WHERE user_id=?";
		
		
		/*
		 # try with resource 
		 - try문을 작성할 때 자원 객체를 소괄호 안에 전달하면
		 try블록이 끝날 때 자동으로 자원을 해제해 줍니다.
		 - 자동으로 종료되는 자원은 반드시 AutoCloseable 인터페이스의 구현체여야 합니다.
		  */
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())//조회된 데이터가 존재하니?를 묻는 것) 
					flag = true;
			} catch (Exception e) {
					e.printStackTrace();
				}
		return flag;
	}

	@Override
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO my_user VALUES(?,?,?,?,?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int usercheck(String id, String pw) {
		int check = 0;
		
		String sql = "SELECT * FROM my_user WHERE user_id=?";
			try(Connection conn = ds.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql);) {
					pstmt.setString(1, id);
					ResultSet rs = pstmt.executeQuery();
					
					if(rs.next() ) {
						String dbPw = rs.getString("user_pw");
						if(dbPw.equals(pw)) {
							check = 1;
						} else {
							check = 0;
						}
					} else {
						check = -1;
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return check;
	}

	@Override
	public UserVO getUserInfo(String id) {
		UserVO user = null;	//"SELECT * FROM my_user WHERER user_id='" + id + "'"; 값이 하나니까 가능/ 표기주의
		String sql = "SELECT * FROM my_user WHERE user_id=?"; 
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			if(rs.next()) {
				user = new UserVO(
						rs.getString("user_id"), 
						rs.getString("user_pw"), 
						rs.getString("user_name"), 
						rs.getString("user_email"), 
						rs.getString("user_address")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void changePassword(String id, String newPw) {
		String sql = "UPDATE my_user SET user_pw=? WHERE user_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, newPw);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(UserVO vo) {
		String sql = "UPDATE my_user SET user_name=? user_email=? user_address=?  WHERE user_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getEmail());
				pstmt.setString(3, vo.getAddress());
				pstmt.setString(4, vo.getId());
				pstmt.executeUpdate();
				
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	} 

	@Override
	public void deleteUser(String id) {
		String sql = "DELETE FROM my_user WHERE user_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
				pstmt.setString(1, id);
				pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
