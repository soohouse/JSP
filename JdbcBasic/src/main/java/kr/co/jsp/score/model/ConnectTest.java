package kr.co.jsp.score.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTest {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@db2022jisu_high?TNS_ADMIN=/Users/dood/Wallet_DB2022jisu",
						"jsp",
						"Oracle_practice1"
					);
			
			System.out.println("conn: " + conn);
			System.out.println("데이터베이스 접속 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
