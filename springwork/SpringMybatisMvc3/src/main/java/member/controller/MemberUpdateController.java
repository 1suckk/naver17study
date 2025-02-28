package member.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.MemberDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import naver.storage.NcpObjectStorageService;

@Controller
public class MemberUpdateController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	NcpObjectStorageService storageService;
	@Autowired
	BoardService boardService;
	@Autowired
	BoardFileService boardFileService;
	
	//버켓 이름
	private String bucketName = "bitcamp-bucket-140";
	
	@GetMapping("/member/mypage")
	public String goMypage(HttpSession session, Model model)
	{
		//세션으로부터 아이디를 얻는다
		String myid = (String)session.getAttribute("loginid");
		
		List<BoardDto> list=null; //페이징에 필요한 데이타
		list=boardService.getSelectById(myid);
		
		if(myid == null)
		{
			//로그인되지 않으면 로그인부터 하도록 
			return "redirect:/login";
		}
		//아이디에 해당하는 dto 얻기
		MemberDto dto = memberService.getMemberbyId(myid);
		
		//반목문으로 회원이 쓴 글을 읽어오기
		for(int i=0; i<list.size(); i++)
		{
			int count = boardFileService.getFiles(list.get(i).getIdx()).size();
			list.get(i).setPhotoCount(count);
			
			BoardDto bdto = list.get(i);
			System.out.println("bdto: "+bdto);
		}
		
		//모델에 dto 저장
		model.addAttribute("dto", dto);
		model.addAttribute("list", list);
		model.addAttribute("naverurl", "https://kr.object.ncloudstorage.com/bitcamp-bucket-140");
		
		System.out.println("멤버 업데이트 컨트롤러에서 받은 dto: "+dto);
		
		return "member/mypage";
	}
	
	@PostMapping("/member/changephoto")
	@ResponseBody
	public void changePhoto(HttpServletRequest request,
							@RequestParam("upload") MultipartFile upload,
							@RequestParam("myid") String myid,
							HttpSession session)
	{	
		//사진수정시 db 저장 파일명 받아서 스토리지에 삭제후 추가
		String oldFilename = memberService.getMemberbyId(myid).getMphoto();
		storageService.deleteFile(bucketName, "member", oldFilename);
		
		//네이버 스토리지에 업로드
		String uploadFilename = storageService.uploadFile(bucketName, "member", upload);
		//db에서도 수정
		memberService.changePhoto(uploadFilename, myid);
		//세션도 변경
		session.setAttribute("loginphoto", uploadFilename);
	}
	
	//회원 이름, 폰번호, 주소 수정 모달
	//post
	@PostMapping("/member/update")
	@ResponseBody
	public void update(@ModelAttribute MemberDto dto)
	{
		System.out.println(dto.getNum());
		
		memberService.updateMember(dto);
	}
}