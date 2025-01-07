package day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

// db를 처리하기 위한 클래스
public class ShopModel {
	MysqlConnect connect = new MysqlConnect();
	
	//전체 데이터 반환하는 메서드
	//List 안에 Vector 형태로 반환
	public List<Vector<String>> getAllDatas() {
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop order by idx desc";
		
			
			try {
				pstmt = conn.prepareStatement(sql);
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
	
	public void insertShop(ShopDto dto) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into shop (sangpum, su, danga, ipgoday) values (?,?,?,now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//binding
			pstmt.setString(1, dto.getSangpum());
			pstmt.setInt(2,  dto.getSu());
			pstmt.setInt(3,  dto.getDanga());
			
			//실행
			pstmt.execute();
		} catch (SQLException e) {	
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connect.dbclose(pstmt, conn);
		}
	}
	
	public void deleteShop(int idx) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from shop where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 후 실행하면 된다
			pstmt.setInt(1, idx);
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.dbclose(pstmt, conn);
		}
	}

	public void updateShop(int idx, String sangpum, int danga) {
		Connection conn = connect.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update shop set sangpum=?, danga=? where idx=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sangpum);
			pstmt.setInt(2,  danga);
			pstmt.setInt(3, idx);
			//실행 --> 이 부분이 빠지면 업뎃이 실시간으로 안됨!!
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	