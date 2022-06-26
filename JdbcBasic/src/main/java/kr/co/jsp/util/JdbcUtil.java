package kr.co.jsp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {

	
	public static void close(Connection conn, PreparedStatement pstmt) {
		
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("close 과정에서 에러 발생!");
				e.printStackTrace();
			}
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	} catch (SQLException e) {
		System.out.println("close 과정에서 에러 발생!");
	}
	}
}