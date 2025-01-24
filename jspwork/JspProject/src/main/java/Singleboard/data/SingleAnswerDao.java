package Singleboard.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.protocol.Resultset;

import db.connect.MysqlConnect;

public class SingleAnswerDao {
	MysqlConnect db = new MysqlConnect();
	
	public void insertAnswer(SingleAnswerDto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt = null;
		String sql="insert into simpleanswer (num, nickname, content, writeday) values (?,?,?,now())";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getNickname());
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
	
	public List<SingleAnswerDto> getAnswerByNum(int num)
	{
		List<SingleAnswerDto> alist = new Vector<SingleAnswerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from simpleanswer where num=? order by idx desc";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, num);
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				SingleAnswerDto dto=new SingleAnswerDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setNum(rs.getInt("num"));
				dto.setNickname(rs.getString("nickname"));
				dto.setContent(rs.getString("content"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				//alist 에 추가
				alist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(rs, pstmt, conn);
		}
		return alist;
	}
	
	public void deleteAnswer(int idx)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from simpleanswer where idx=?";
		
		conn = db.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setInt(1, idx);
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
