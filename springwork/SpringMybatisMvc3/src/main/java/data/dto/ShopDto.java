package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/*
create table bootshop (
	num smallint auto_increment primary key,
    sangpum varchar(30),
    scolor varchar(20),
    sprice int,
    scnt smallint,
    sphoto varchar(1000),
    ipgoday varchar(30),
    writeday datetime
); 
 */
@Data
@Alias("sdto")
public class ShopDto {
	private int num;
	private String sangpum;
	private String scolor;
	private int sprice;
	private int scnt;
	private String sphoto;
	private String ipgoday;
	private Timestamp writeday;
	private String mainPhoto;
	private int replecount; //댓글 개수 저장
}
