package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.BoardFileDto;
import data.mapper.BoardFileMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardFileService {
	BoardFileMapper boardFileMapper;
	
	public void insertBoardFile(BoardFileDto dto)
	{
		boardFileMapper.insertBoardFile(dto);
	}
	
	public List<BoardFileDto> getFiles(int idx)
	{
		return boardFileMapper.getFiles(idx);
	}
	
	public void deleteFile(int num)
	{
		boardFileMapper.deleteFile(num);
	}
	
	public String getFilename(int num)
	{
		return boardFileMapper.getFilename(num);
	}
}
