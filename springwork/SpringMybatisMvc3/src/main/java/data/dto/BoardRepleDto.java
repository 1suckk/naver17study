package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/*
create table boardreple
(
	num smallint auto_increment primary key,
	idx smallint,
	myid varchar(30),
    message varchar(100),
    photo varchar(50),
    writeday datetime,
    foreign key(idx) references board(idx)
		on delete cascade
);
*/
@Data
@Alias("BoardRepleDto")
public class BoardRepleDto {
	private int num;
	private int idx;
	private String myid;
	private String message;
	private String photo;
	private Timestamp writeday;
}
