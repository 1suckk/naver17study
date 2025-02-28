package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardRepleDto;
import data.mapper.BoardRepleMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardRepleService {
	
	BoardRepleMapper boardRepleMapper;
	
	public int getTotalCount(int idx)
	{
		return boardRepleMapper.getTotalCount(idx);
	}
	
	public List<BoardRepleDto> getRepleByIdx(int idx)
	{
		return boardRepleMapper.getRepleByIdx(idx);
	}
	
	public void insertBoardReple(BoardRepleDto dto)
	{
		boardRepleMapper.insertBoardReple(dto);
	}
	
	public void deleteBoardReple(int num)
	{
		boardRepleMapper.deleteBoardReple(num);
	}
	
	public String getPhoto(int num)
	{
		return boardRepleMapper.getPhoto(num);
	}
}
