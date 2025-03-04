package data.dto;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/*
create table board 
(
		idx smallint auto_increment primary key,
        myid varchar(30),
        writer varchar(30),
        subject varchar(300),
        content varchar(2000),
        readcount smallint default 0,
        regroup smallint,
        relevel smallint,
        restep smallint,
        writeday datetime default now()
);
 */
@Data
@Alias("BoardDto")
public class BoardDto {
	private int idx;
	private String myid;
	private String writer;
	private String subject;
	private String content;
	private int readcount;
	private int regroup;
	private int relevel;
	private int restep;
	private Timestamp writeday;
	private List<String> photos; //다른 db에서 join 받을 것
	private int photoCount;
	private int repleCount;
}
