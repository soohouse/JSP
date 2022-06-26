package kr.co.jsp.score.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO는 웹 서버의 DB 연동 요청이 발생할 때마다
//DataBase CRUD(create, read, update, delete)작업을 전담하는 클래스 입니다.

public class ScoreDAO {
	
	//싱글톤 디자인 패턴(객체의 생성을 단 하나로 제한하기 위한 코드 디자인 패턴)
	
	//1. 클래스 외부에서 객체를 생성하지 못하게 생성자에 private 접근 제한을 붙임.
	//커넥트 드라이버 호출도 하자!
	private ScoreDAO() {
		try {
			Class.forName("oracle.jobc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2. 이제 객체를 생성할 수 있는 영역은 해당 클래스 내부 뿐이므로
	//스스로의 객체를 단 하나만 생성함.
	private static ScoreDAO dao = new ScoreDAO();
	
	//3. 외부에서 객체를 요구할 시 공개된 메서드를 통해
	//2번에서 미리 만들어 놓은 단 하나의 객체의 주소값을 리턴.
	//여기서 static을 썼으면 2번에도 static 작성해줘라
	//근데 그냥 static을 해주면 어디서든 접근 가능하니까 private해주기(2번)
	public static ScoreDAO getInstance() {
		if(dao == null) {
			dao = new ScoreDAO();
		}
		return dao;
	}
	////////////////////////////////////////////////
	
	//DB 관련 여러가지 작업 메서드가 들어가는 공간
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//모든 메서드에서 공용적으로 사용할 Connection객체를 얻을 수 있는 유틸 메서드
	private Connection getConnection() throws Exception { //발생하는 모든 예외를 getconnection에서 처리하도록 떠넘
		String url = "jdbc:oracle:thin:@db2022jisu_high?TNS_ADMIN=/Users/dood/Wallet_DB2022jisu";
		String uid = "jsp";
		String upw = "Oracle_practice1";
		
		return DriverManager.getConnection(url, uid, upw);
	}
	
	//점수 데이터를 저장하는 메서드
	public boolean insert(scoreVO vo) {
		boolean flag = false;
		String sql = "INSERT INTO scores VALUES(id_seq.NEXTVAL,?,?,?,?,?,?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getTotal());
			pstmt.setDouble(6,vo.getAverage());
			
			int rn = pstmt.executeUpdate();
			if(rn == 1) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				
			}
		}
		
		return flag;
	}
	
	//점수 목록을 조회하는 메서드
	public List<scoreVO> selectAll() {
		List<scoreVO> scoreList = new ArrayList<>();
		String sql = "SELECT * FROM scores ORDER BY id ASC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				scoreVO vo = new scoreVO(//얘네들이 한 행이다라고 보이기위해 묶어둔 
							rs.getInt("id"),
							rs.getString("name"),
							rs.getInt("kor"),
							rs.getInt("eng"),
							rs.getInt("math"),
							rs.getInt("total"),
							rs.getDouble("average"));
					scoreList.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return scoreList;
	}
	
	//점수를 삭제하는 메서드
	public boolean delete(int id) {
		boolean flag = false;
		String sql = "DELETE FROM scores WHERE id=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rn = pstmt.executeUpdate();
			
			if(rn == 1) flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return flag;
	}
	
	//이름 검색 메서드
	public List<scoreVO> search(String keyword) {

		List<scoreVO> scoreList = new ArrayList<>();
		
		//?에 % 붙이지 마세요!!!
		String sql = "SELECT * FROM scores WHERE name LIKE ?";
			
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			
		while(rs.next()) {
			scoreVO vo = new scoreVO(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getInt("kor"),
					rs.getInt("eng"),
					rs.getInt("math"),
					rs.getInt("total"),
					rs.getDouble("average")
					);
			scoreList.add(vo);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return scoreList;
	}
}
