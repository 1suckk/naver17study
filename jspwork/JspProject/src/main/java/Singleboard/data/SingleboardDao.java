package Singleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import sawon.data.SawonDto;

public class SingleboardDao {
	MysqlConnect db = new MysqlConnect();
	
	public List<SingleboardDto> getAllDatas()
	{
		List<SingleboardDto> list = new Vector<SingleboardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from singleboard order by num desc";
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				SingleboardDto dto = new SingleboardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//dto에 레코드 단위의 데이터를 다 넣은 후 list 에 추가
				list.add(dto);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			db.dbclose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public void insertBoard(SingleboardDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		String sql="""
				insert into singleboard (writer, subject, content, writeday)
				 values (?,?,?,now())
				""";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			//실행
			pstmt.execute();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbclose(pstmt, conn);
		}
	}
	
	public SingleboardDto getData(int num)
	{
		SingleboardDto dto=new SingleboardDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from Singleboard where num=?";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs, pstmt, conn);
		}
		return dto;
	}
	
	public void updateReadCount(int num)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update singleboard set readcount=readcount+1 where num=?";
		
		conn = db.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			pstmt.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbclose(pstmt, conn);
		}
	}
	
	public void deleteBoard(int num)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from singleboard where num=?";
		
		conn = db.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			pstmt.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbclose(pstmt, conn);
		}
	}
	
	public void updateBoard(SingleboardDto dto)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update singleboard set writer=?, subject=?, content=? where num=?";
		
		conn = db.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩 과정
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			//실행
			pstmt.execute();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			db.dbclose(pstmt, conn);
		}
		
	}
}
