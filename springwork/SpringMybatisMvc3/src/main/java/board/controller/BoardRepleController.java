package board.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.ec2.model.Storage;

import data.dto.BoardRepleDto;
import data.service.BoardRepleService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
public class BoardRepleController {
	final BoardRepleService boardRepleService;
	final BoardService boardService;
	final MemberService memberService;
	final NcpObjectStorageService storageService;
	
	//NCP 버킷 이름
	private String bucketName = "bitcamp-bucket-140";
	
	private String uploadFilename;//댓글에서 업로드한 파일명;
	
	//0. 댓글 사진 업로드 ajax
	@PostMapping("/board/uploadreple")
	public String uploadReple(@RequestParam("upload") MultipartFile upload)
	{
		//사진을 다시 올릴 경우 기존 사진은 삭제(차후 구현)
		
		//네이버 스토리지에 사진 업로드
		uploadFilename = storageService.uploadFile(bucketName, "board", upload);
		
		return uploadFilename;
	}
	
	//1. 댓글 삽입
	@PostMapping("/board/addreple")
	public void insertReple()
	{
		
	}
	
	//2. 댓글 조회
	@GetMapping("/board/replelist")
	public List<BoardRepleDto> replelist(@RequestParam int idx)
	{
		List<BoardRepleDto> list = null;
		list = boardRepleService.getRepleByIdx(idx);
		return list;
	}
	
	//3. 댓글 삭제
	@GetMapping("board/repledel")
	public void repleDelete(@RequestParam String fname)
	{
		storageService.deleteFile(bucketName, "board", fname);
	}
}
