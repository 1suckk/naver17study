package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.connect.MysqlConnect;

public class Ex1ShopMysql {
	MysqlConnect mysqlConnect = new MysqlConnect();
	
	//shop에 상품 추가
	public void insertShop(String sangpum, int su, int danga)
	{
		System.out.println("상품을 추가합니다.");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into shop (sangpum, su, danga, ipgoday) values (?,?,?,now())";
		
		conn = mysqlConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); //이때 sql문을 검사한다
			// ? 갯수만큼 데이터를 넣어준다
			// 첫번째 물음표부터 1번, 2번 ...
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, danga);
			
			//바인딩을 모두 마친 후 실행하는데 이때 sql문을 보내면 안됨, 바로 실행함
			pstmt.execute(); //실행을 마지막에 꼭 해줘야함
			System.out.println("상품을 추가했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbclose(pstmt, conn);
		}
	}
	
	//전체 shop 데이터 출력
	public void writeShop()
	{
		System.out.println("전체 상품을 출력합니다.");
		System.out.println("인덱스\t상품명\t수량\t단가\t총금액");
		System.out.println("=".repeat(50));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from shop order by idx";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩할게 없으므로 바로 실행
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su * dan;
				
				System.out.println(rs.getInt("idx") + "\t" + rs.getString("sangpum")
				+ "\t" + su + "\t" + dan + "\t" + total + "\t" + rs.getString("ipgoday").substring(0,16));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbclose(rs, pstmt, conn);
		}
		
	}
	
	//상품을 삭제합니다.
	public void deleteShop(String sangpum)
	{
		System.out.println("상품을 삭제합니다");
		
		Connection conn=null;
    	Statement stmt=null;
    	String sql="delete from shop where sangpum='"+sangpum+"'";
    	
    	conn = mysqlConnect.getConnection();
    	try {
			stmt=conn.createStatement();
			int n=stmt.executeUpdate(sql);
			if(n==0)
				System.out.println("\""+sangpum+"\" 관련 상품은 존재하지 않습니다");
			else
				System.out.println(n+" 개의 데이타가 삭제되었습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//상품조회
	public void searchSangpum(String sangpum)
	{
		System.out.println("[" + sangpum + "] 상품을 조회합니다.");
		System.out.println("인덱스\t상품명\t수량\t단가\t총금액");
		System.out.println("=".repeat(50));
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from shop where sangpum like ? order by idx"; //바인딩을 이용
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sangpum + "%");
			
			rs = pstmt.executeQuery();
			
			int count = 0;
			while (rs.next())
			{
				count++;
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su*dan;
				
				System.out.println(rs.getInt("idx") + "\t" + rs.getString("sangpum")
				+ "\t" + su + "\t" + dan + "\t" + total + "\t" + rs.getString("ipgoday").substring(0,16));
			}
			
			if (count==0) 
				System.out.println("[" + sangpum + "] 관련 제품이 없습니다.");
			else
				System.out.println("[" + sangpum + "] 관련 제품이 총 "+ count + "개 있습니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbclose(rs, pstmt, conn);
		}
	}
	
	//상품 수정
	public void updateShop(int idx, int su, int danga)
	{
		System.out.println(idx +"번째 인덱스 상품을 수정합니다.");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update shop set su=?, danga=? where idx=?";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, su);
			pstmt.setInt(2,  danga);
			pstmt.setInt(3,  idx);
			
			int n = pstmt.executeUpdate();
			if (n == 0)
				System.out.println("해당 인덱스 상품이 없습니다.");
			else
				System.out.println("해당 인덱스 상품을 수정했습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlConnect.dbclose(pstmt, conn);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex1ShopMysql ex = new Ex1ShopMysql();
		
		while (true) {
			System.out.println("\t** 상품관리 메뉴 **\n");
			System.out.println("1.상품추가 2.전체출력 3.상품조회 4.상품삭제 5.상품수정 6.종료");
			System.out.println("번호 선택(1-6) : ");
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1 -> {
				System.out.println("상품명: ");
				String sang = sc.nextLine();
				System.out.println("수량: ");
				int su = Integer.parseInt(sc.nextLine());
				System.out.println("단가: ");
				int dan = Integer.parseInt(sc.nextLine());
				
				ex.insertShop(sang, su, dan);
			}
			
			case 2 -> {
				ex.writeShop();
			}
			
			case 3 -> {
				System.out.println("검색할 상품명을 입력하세요.");
				String sangpum = sc.nextLine();
				ex.searchSangpum(sangpum);
			}
			
			case 4 -> {
				System.out.println("삭제할 제품의 이름을 입력하세요");
				String sangpum = sc.nextLine();
				
				ex.deleteShop(sangpum);
				break;
			}
			
			case 5 -> {
				System.out.println("수정할 상품의 인덱스 값을 입력하시오.");
				int idx = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 상품의 수량을 입력하시오.");
				int su = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 상품의 단가를 입력하시오.");
				int dan = Integer.parseInt(sc.nextLine());
				
				ex.updateShop(idx, su, dan);
			}
			
			default -> {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
			}
		
		
		} //while문 끝
	}

}