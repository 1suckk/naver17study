package bit.react.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import bit.react.data.BoardEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository; //final 안붙여서 403 에러 발생
	
	public void insertBoard(BoardEntity boardEntity)
	{
		boardRepository.save(boardEntity);
	}
	
	public List<BoardEntity> getAllBoard()
	{
		//num의 내림차순으로 게시판 글을 정렬
		return boardRepository.findAll(Sort.by(Sort.Direction.DESC,"num"));
	}
	
	public BoardEntity getData(int num)
	{
		return boardRepository.getReferenceById(num);
	}
	
	public void deleteBoard(int num)
	{
		boardRepository.deleteById(num);
	}
	
	public void updateReadCount(int num)
	{
		boardRepository.updateReadCount(num);
	}
	
	public void updateBoard(BoardEntity boardEntity)
	{
		boardRepository.save(boardEntity);
	}
}
