package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleJoin {

	public static Connection getConnection(){
        Connection conn = null;
        try {
            String user = "ANGEL";
            String pw = "a1234";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unknown error");
            e.printStackTrace();
        }
        return conn;     
    }
    
    public static void executeJoinQuery() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = """
        	    SELECT S.SANGCODE, SANGNAME, CNTNUM, TO_CHAR(CNTDAY, 'YYYY-MM-DD') AS CNTDAY
        	    FROM SHOP S, CART C
        	    WHERE S.SANGCODE = C.SANGCODE
        	    """;//멀티라인 텍스트를 이용한 쿼리문 입력

        
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            System.out.println("상품코드\t\t상품명\t\t\t수량\t등록일");
            System.out.println("-----------------------------------------------------------");
            
            while (rs.next()) {
                String sangCode = rs.getString("SANGCODE");
                String sangName = rs.getString("SANGNAME");
                int cntNum = rs.getInt("CNTNUM");
                String cntDay = rs.getString("CNTDAY");
                
                System.out.printf("%-10s\t%-20s\t%d\t%s\n", sangCode, sangName, cntNum, cntDay);
            }
            
        } catch (SQLException e) {
            System.out.println("SQL 실행 오류: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("리소스 해제 중 오류 발생: " + e.getMessage());
            }
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        executeJoinQuery();
	}
}