package day0103db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex2MysqlConnect {
	
	//연결 성공 후 
	public Connection getConnection() {
		Connection conn = null;
		try {
				String username = "root";
				String password = "1234";
				String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
				String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
			
				Class.forName(MYSQL_DRIVER);
				
				conn = DriverManager.getConnection(url, username, password);
				System.out.println("Connected!");
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("JDBC Driver not found: " + 
			e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Database connection error: " + 
					e.getMessage());
		}
		
		return conn;
	}
	
	public void personWriteData()
	{
		Connection conn = getConnection();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				 System.out.println("Error closing connection: " + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Ex2MysqlConnect ex2 = new Ex2MysqlConnect();
	     ex2.personWriteData();
	}
}