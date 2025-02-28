package board.controller;

import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.dto.MemberDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
public class BoardController {
	//Autowired 안쓸거면 final 써야함
	final BoardService boardService;
	final BoardFileService boardFileService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	//NCP 버킷 이름
	private String bucketName="bitcamp-bucket-140";
	
	//글 작성 페이지
	@GetMapping("/board/writeform")
	public String writeForm(
			@RequestParam(value = "idx", defaultValue = "0") int idx,
			@RequestParam(value = "regroup", defaultValue = "0") int regroup,
			@RequestParam(value = "restep", defaultValue = "0") int restep,
			@RequestParam(value = "relevel", defaultValue = "0") int relevel,
			@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
			Model model)
	{
		model.addAttribute("idx", idx);
		model.addAttribute("regroup", regroup);
		model.addAttribute("restep", restep);
		model.addAttribute("relevel", relevel);
		model.addAttribute("pageNum", pageNum);
		
		return "board/writeform";
	}
	
	//글 세부 페이지
	@GetMapping("/board/detail")
	public String detail(@RequestParam int idx,
							@RequestParam int pageNum,
							Model model)
	{
		boardService.updateReadCount(idx);
		
		BoardDto dto = boardService.getSelectByIdx(idx);
		
		List<String> fileList = new Vector<>();
		List<BoardFileDto> flist = boardFileService.getFiles(idx);
		
		for(BoardFileDto fdto:flist)
		{
			fileList.add(fdto.getFilename());
		}
		
		dto.setPhotos(fileList);
		
		String memberPhoto = memberService.getMemberbyId(dto.getMyid()).getMphoto();
		
		model.addAttribute("dto", dto);
		model.addAttribute("memberPhoto", memberPhoto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-140");
		
		return "board/boarddetail";
	}
	
	//글 작성 액션
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto dto,
							@RequestParam int pageNum,
							@RequestParam("upload") List<MultipartFile> uploadList,
							HttpSession session)
	{
		//세션으로부터 아이디를 얻는다
		String myid = (String)session.getAttribute("loginid");
		
		//아이디를 이용해서 멤버 테이블에서 작성자를 얻는다
		String writer = memberService.getMemberbyId(myid).getMname();
		System.out.println("writer: "+writer);
		
		//dto 에 넣기
		dto.setWriter(writer);
		dto.setMyid(myid);
		
		//게시판 내용을 일단 DB에 저장()
		boardService.insertBoard(dto);
		
		//파일이 있는 경우에만 해당, 네이버 스토리지에 저장 후 파일 저장 (이때 필요한게 idx, filename)
		//반복문 안에서 이루어져야만 한다
		if(!uploadList.get(0).getOriginalFilename().equals(""))
		{
			for(MultipartFile file:uploadList)
			{
				String uploadFilename = storageService.uploadFile(bucketName, "board", file); //url 형성
				BoardFileDto bdto = new BoardFileDto();
				bdto.setIdx(dto.getIdx());
				bdto.setFilename(uploadFilename);
				boardFileService.insertBoardFile(bdto);
			}
		}
		
		System.out.println("pageNum"+pageNum);
		
		return "redirect:./list?pageNum="+pageNum;
	}
	
	//글 수정 페이지
	@GetMapping("/board/updateform")
	public String updateform(@RequestParam int idx,
								@RequestParam int pageNum,
								Model model)
	{
		BoardDto dto = boardService.getSelectByIdx(idx);
		
		model.addAttribute("dto", dto);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/"+bucketName);
		
		return "board/updateform";
	}
	
	//수정 페이지에서 기존 사진 목록 나타냄
	@GetMapping("/board/photolist")
	@ResponseBody
	public List<BoardFileDto> photoList(@RequestParam int idx)
	{
		List<BoardFileDto> list = boardFileService.getFiles(idx);
		return list;
	}
	
	//수정 페이지에서 기존 사진 삭제
	@GetMapping("/board/delphoto")
	@ResponseBody
	public void delphoto(@RequestParam int num)
	{
		
		String filename = boardFileService.getFilename(num);
		
		storageService.deleteFile(bucketName, "board", filename);
		
		boardFileService.deleteFile(num);
	}
	

	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto,
							@RequestParam int pageNum,
							@RequestParam("upload") List<MultipartFile> upload)
	{
		//제목 및 내용 수정
		boardService.updateBoard(dto);
		//사진은 추가
		//파일이 있는 경우에만 해당, 네이버 스토이지에 저장 후 파일 저장
		//반복문 내에서 이루어져야만 한다
		if(!upload.get(0).getOriginalFilename().equals(""))
		{
			for(MultipartFile f:upload)
			{
				String filename = storageService.uploadFile(bucketName, "board", f);
				BoardFileDto bdto = new BoardFileDto();
				bdto.setIdx(dto.getIdx());
				bdto.setFilename(filename);
				//boardfile에 insert
				boardFileService.insertBoardFile(bdto);
			}
		}
		
		return "redirect:./detail?idx="+dto.getIdx()+"&pageNum="+ pageNum;
	}
	
	@GetMapping("/board/delete")
	@ResponseBody
	public void boardDelete(@RequestParam int idx)
	{	
		List<BoardFileDto> filelist = boardFileService.getFiles(idx);
		
		//지우려는 글의 idx에 해당하는 사진들을 각각 삭제
		//안지우면 네이버 스토리지에 계속 잔존하는 문제 발생
		for(BoardFileDto fdto:filelist)
		{
			String filename = fdto.getFilename();
			storageService.deleteFile(bucketName, "board", filename);
		}
		
		boardService.deleteBoard(idx);
	}
}