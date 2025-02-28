package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/*
create table shopreple
(
	idx smallint auto_increment primary key,
    num smallint,
    star smallint,
    message varchar(300),
    writeday datetime,
    foreign key(num) references shop(num) on delete cascade -- 글이 삭제되면 댓글도 함께 삭제
);
 */
@Data
@Alias("ShopRepleDto")
public class ShopRepleDto {
	private int idx;
	private int num;
	private int likes;
	private String message;
	private String photo;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writetime;
}
