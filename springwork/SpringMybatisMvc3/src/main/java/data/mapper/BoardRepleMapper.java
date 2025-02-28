package data.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import data.dto.BoardRepleDto;

@Mapper
public interface BoardRepleMapper {
	public int getTotalCount(int idx);
	public List<BoardRepleDto> getRepleByIdx(int idx);
	public void insertBoardReple(BoardRepleDto dto);
	public void deleteBoardReple(int num);
	public String getPhoto(int num);
}
