package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO implements IBoardDAO {
	
	private DataSource ds;
	
	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("jaava:comp/env/Jdbc/myOracle"); //커넥션풀을 찾고 데이타소스타입으로 내려서 넣겠다
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	
	
	///////////////////////////////////////////
	
		

	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO my_board (board_id, writer, title, content) VALUES(board_seq.NEXTVAL,?,?,?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM my_board ORDER BY board_id DESC";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
				articles.add(vo);
						
			}
		} catch (Exception e) {
			e.printStackTrace();
			} 
		return articles;
	}

	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO vo = null;
		String sql = "SELECT * FROM my_board WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			ResultSet rs = pstmt.executeQuery();
			//조회된 결과가 있니?
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content").replace("\r\n", "<br>"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE my_board SET title=?, content=? WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBoard(int bId) {
		String sql = "DELETE FROM my_board WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	@Override
	public void upHit(int bId) {
		String sql = "UPDATE my_board SET hit=hit+1 "
				+ "WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





	@Override
	public int countArticles() {
		// TODO Auto-generated method stub
		return 0;
	}

	



}
