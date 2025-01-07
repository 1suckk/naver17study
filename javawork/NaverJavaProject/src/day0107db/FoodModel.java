package day0107db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class FoodModel {
	MysqlConnect mysqlconnect = new MysqlConnect();
	
	public void foodmenuInsert(String foodName, int foodPrice, String foodSize)
	{
		Connection conn = mysqlconnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into foodrest (foodname, foodprice, foodsize) values (?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 시 필수로 포함되어야 하는 것들
			pstmt.setString(1, foodName);
			pstmt.setInt(2, foodPrice);
			pstmt.setString(3, foodSize);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(pstmt, conn);
		}
	}
	
	public List<Vector<String>> getAllMenus() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from foodrest order by num";
		
		conn = mysqlconnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				
				list.add(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(rs, pstmt, conn);
		}
		return list;
	}
		
	public void foodOrderInsert(FoodOrderDto dto)
	{
		Connection conn = mysqlconnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into foodorder (num, ordername, ordercnt, bookingday) values (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 시 필수로 포함되어야 하는 것들
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getOrderName());
			pstmt.setInt(3, dto.getOrderCnt());
			pstmt.setString(4, dto.getBookingDay());
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(pstmt, conn);
		}
	}
	
	public List<Vector<String>> getAllOrders() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="""
					select idx, ordername, foodname, foodprice, foodsize, ordercnt, bookingday
					from foodrest fr, foodorder fo
					where fr.num = fo.num;
					""";
		
		conn = mysqlconnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("ordername"));
				data.add(rs.getString("foodname"));
				data.add(rs.getString("foodprice"));
				data.add(rs.getString("foodsize"));
				data.add(rs.getString("ordercnt"));
				data.add(rs.getString("bookingday"));
				
				list.add(data);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(rs, pstmt, conn);
		}
		return list;
	}
	
	public void deleteFoodMenu(int num) {
		Connection conn = mysqlconnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from foodrest where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 시 필수로 포함되어야 하는 것들
			pstmt.setInt(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(pstmt, conn);
		}
	}
	
	public void deleteOrder(int idx) {
		Connection conn = mysqlconnect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from foodorder where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 시 필수로 포함되어야 하는 것들
			pstmt.setInt(1, idx);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(pstmt, conn);
		}
	}
	
	//등록메뉴를 예약한 건수 반환
	public int getOrderMenuCount(int num) {
		Connection conn = mysqlconnect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null; //왜 필요한가?
		int cnt = 0;
		String sql = "select count(*) from foodorder where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery(); //왜 필요한가?
			if (rs.next())
				cnt = rs.getInt("count"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mysqlconnect.dbclose(rs, pstmt, conn);
		}
		return cnt;
	}
}
