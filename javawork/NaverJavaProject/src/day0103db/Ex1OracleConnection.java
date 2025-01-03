package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1OracleConnection {
	
	public static Connection getConnection(){
        Connection conn = null;
        try {
            String user = "ANGEL"; //사용자 계정 
            String pw = "a1234"; //비밀번호
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
            } catch (ClassNotFoundException cnfe) {
                System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
            } catch (SQLException sqle) {
                System.out.println("DB 접속실패 : "+sqle.toString());
            } catch (Exception e) {
                System.out.println("Unkonwn error");
                e.printStackTrace();
            }
            return conn;     
        }
	
	public void shopWriteData()
	{
		// 아래의 세 변수는 꼭 지역변수로 주어야한다
		//일반적으로 DB를 하나만 다루는 것이 아니라 충돌 발생 우려
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from shop";
		
		conn = this.getConnection();
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1OracleConnection.getConnection();
	}
}