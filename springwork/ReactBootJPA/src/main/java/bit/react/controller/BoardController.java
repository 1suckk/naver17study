package bit.react.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.react.data.BoardDto;
import bit.react.data.BoardEntity;
import bit.react.jwt.JwtUtil;
import bit.react.repository.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	private final NcpObjectStorageService storageService;
	private final JwtUtil jwtUtil;
	
	private String bucketName = "bitcamp-bucket-140";
	private String folderName = "board";
	
	@PostMapping(value="/auth/board/insert", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String insert(@RequestPart("upload") MultipartFile upload,
							@RequestPart("subject") String subject,
							@RequestPart("content") String content,
							HttpServletRequest request
							)
	{
		//사진은 네이버 스토리지에 업로드
		String uploadFileName = storageService.uploadFile(bucketName, folderName, upload);
		//현재 로그인한 username 정보를 header에서 얻기
		String auth = request.getHeader("Authorization");
		String token = auth.substring(7);
		String username = jwtUtil.getUsername(token);
		
		BoardEntity boardEntity = BoardEntity.builder()
				.subject(subject)
				.content(content)
				.photo(uploadFileName)
				.username(username)
				.build();
				
		//save
		boardService.insertBoard(boardEntity);
		
		return "board insert ok!";
	}
	
	@GetMapping("/board/list")
	public List<BoardEntity> getAllList()
	{
		return boardService.getAllBoard();
	}
	
	@GetMapping("/auth/board/detail")
	public BoardEntity selectData(@RequestParam("num") int num)
	{
		boardService.updateReadCount(num);
		return boardService.getData(num);
	}
	
	@DeleteMapping("/auth/board/delete")
	public String deleteBoard(@RequestParam("num") int num)
	{
		//스토리지에 업로드된 사진 지우기
		String oldPhotoname=boardService.getData(num).getPhoto();
		storageService.deleteFile(bucketName, folderName, oldPhotoname);

		//db 삭제
		boardService.deleteBoard(num);
		return "delete ok!";
	}

	
	@GetMapping("/auth/board/updateform")
	public BoardEntity updateForm(@RequestParam("num") int num)
	{
		return boardService.getData(num);
	}
}
