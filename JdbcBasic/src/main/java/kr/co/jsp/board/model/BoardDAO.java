package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.jsp.util.JdbcUtil;
public class BoardDAO implements IBoardDAO {
	
	//커넥션 풀의 정보를 담을 변수를 선언
	private DataSource ds;
	
	private BoardDAO() {
		//클래스에서 커넥션 풀을 구하는 방법. (설정 파일이 InitialContext 객체에 저장됨)
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 private BoardDAO() {
	 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	*/
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
		
	}
	
	//////////////////////////////////////////////
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/*
	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@db2022jisu_high?TNS_ADMIN=/Users/dood/Wallet_DB2022jisu";
		String uid = "jsp";
		String upw = "Oracle_practice1";
		
		return DriverManager.getConnection(url, uid, upw);
	}
	*/

	@Override
	public boolean insert(BoardVO vo) {
		boolean flag = false;
		
		String sql = "INSERT INTO board"
				+"(board_id, writer, title, content)"
				+ "VALUES(bid_seq.NEXTVAL,?,?,?)";
		
		try {
			conn=ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			/*
			int rn = pstmt.executeUpdate();
			if(rn == 1)flag = true;
			*/
			
			if(pstmt.executeUpdate() == 1)flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}

	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM board ORDER BY board_id DESC";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				BoardVO vo = new BoardVO(
							rs.getInt("board_id"),
							rs.getString("writer"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getTimestamp("reg_date")
						);
				articles.add(vo);
						
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return articles;
	}

	@Override
	public BoardVO selectOne(int bId) {
		BoardVO vo = null;
		
		String sql = "SELECT * FROM board WHERE board_id=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO(
							rs.getInt("board_id"),
							rs.getString("writer"),
							rs.getString("title"),
							rs.getString("content"),
							rs.getTimestamp("reg_date")
						);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return vo;
	}

	@Override
	public boolean update(BoardVO vo) {
		boolean flag = false;
		
		String sql = "UPDATE board SET title=?, content=? WHERE board_id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());
			
			if(pstmt.executeUpdate()==1) flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}

	@Override
	public boolean delete(int bId) {
		boolean flag = false;
		
		String sql = "DELETE FROM board WHERE board_id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bId);
			if(pstmt.executeUpdate() == 1) flag = true;
		} catch (Exception e) {
			JdbcUtil.close(conn, pstmt);
		}
		return flag;
	}

}
