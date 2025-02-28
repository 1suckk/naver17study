package board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import data.dto.BoardDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class BoardListController {
	final BoardService boardService;
	final BoardFileService boardFileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	//페이징 로직 포함
	@GetMapping("/board/list")
	public String list(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			Model model)
	{
		int perPage = 5; //페이지당 게시글 수
		int perBlock = 5; //한 블럭 당 출력할 페이지의 수
		int totalCount;//전체 게시글 갯수
		int totalPage = 0; //총 페이지 수
		int startNum; //각 페이지에서 가져올 시작번호(mysql은 첫데이터가 0번 오라클은 1번)
		int startPage; //각 블럭에서 출력할 시작페이지
		int endPage; //각 블럭에서 출력할 끝페이지
		int no; //각 페이징서 출력한 시작 번호

		List<BoardDto> list=null; //페이징에 필요한 데이타
		
		totalCount=boardService.getTotalCount(); //글의 총 갯수를 변수에 저장
		totalPage = (int)Math.ceil((double)totalCount/perPage); //총 페이지 갯수
	
		//시작페이지
		startPage = (pageNum-1)/perBlock*perBlock+1;
		//끝페이지
		endPage = startPage + perBlock - 1;
		
		//endPage는 totalPage를 넘을 수 없음
		if (endPage > totalPage)
			endPage = totalPage;
		
		//현재 페이지의 시작 번호 (가장 작은 번호; 내림차순이니까)
		startNum = perPage*(pageNum-1); //mysql은 첫 글이 0번, 오라클은 첫 글이 1번

		list=boardService.getPagingList(startNum, perPage);
		//마지막 페이지의 1개 남은 글을 지우고 다시 해당페이지로
		//있을 경우 데이터가 안나오는 현상
		if(list.size()==0)
		{
			return "./list?pageNum="+(pageNum-1);
		}
		
		for(int i=0; i<list.size(); i++)
		{
			BoardDto dto = list.get(i);
			int count = boardFileService.getFiles(dto.getIdx()).size();
			list.get(i).setPhotoCount(count);
		}

		//각 페이지의 글앞에 출력할 시작번호 (예: 총글이 20게일경우 1페이지는 20, 2페이지는 15)
		no = totalCount-(pageNum-1)*perPage;

		//request 에 저장
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		//페이지 출력에 필요한 모든 변수를 request에 넣는다
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("no", no);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("totalPage", totalPage);
		
		return "board/boardlist";	
	}
	
}
