package data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/*
create table boardfile
(
	num smallint auto_increment primary key,
    idx smallint,
    filename varchar(50),
    foreign key(idx) references board(idx)
		on delete cascade
);
*/

@Data
@Alias("BoardFileDto")
public class BoardFileDto {
	private int num;
	private int idx;
	private String filename;
}
