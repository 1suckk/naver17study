package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class PersonModel {
	MysqlConnect connect = new MysqlConnect();
	
	public List<Vector<String>> getAllDatas() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from person order by num desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
			
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("blood"));
				data.add(rs.getString("age"));
				data.add(rs.getString("hp"));
			
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbclose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public void insertPerson(PersonDto dto) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into person (name, blood, age, hp) values (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBlood());
			pstmt.setInt(3, dto.getAge());
			pstmt.setString(4, dto.getHp());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbclose(pstmt, conn);
		}
	}
	
	public void deletePerson(int num) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from person where idx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connect.dbclose(pstmt, conn);
		}
	}
	
	public List<Vector<String>> getSearchData(String searchWord) {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop where sangpum like ? order by idx";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			rs = pstmt.executeQuery();
		
			while (rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("idx"));
				data.add(rs.getString("sangpum"));
				data.add(rs.getString("su"));
				data.add(rs.getString("danga"));
				
				int total = rs.getInt("su") * rs.getInt("danga");
				data.add(String.valueOf(total));
				data.add(rs.getString("ipgoday").substring(0,10));
				
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbclose(rs, pstmt, conn);
		}
		
		return list;
	}
}
