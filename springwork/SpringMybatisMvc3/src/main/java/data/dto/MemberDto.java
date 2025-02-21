package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
create table member 
(
	num smallint auto_increment primary key,
    mname varchar(20),
    mpass varchar(20),
    myid varchar(20),
    mhp varchar(20),
    maddr varchar(300),
    mphoto varchar(100),
    gaipday datetime
);
 */
@Data
@Alias("MemberDto")
public class MemberDto {
	private int num;
	private String mname;
	private String mpass;
	private String myid;
	private String mhp;
	private String maddr;
	private String mphoto;
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp gaipday;
}
