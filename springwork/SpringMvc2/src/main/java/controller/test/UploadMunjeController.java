package controller.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FilenameChange;
import jakarta.servlet.http.HttpServletRequest;

//컨트롤러를 통해서 제목을 가져올것
@Controller
public class UploadMunjeController {
	//ajax - 여러 개 사진 업로드
	@GetMapping("/munjeupload1")
	public String munje1()
	{
		return "upload/uploadformmunje";
	}
	
	@PostMapping("/munjeprocess1")
	@ResponseBody
	public Map<String, String> upload1(
								HttpServletRequest request,
								@RequestParam String title,
								@RequestParam("upload") MultipartFile upload)
	//여기서부터 함수 선언부
	{
		Map<String, String> map = new HashMap<>();
		
		//업로드할 프로젝트 내의 위치 지정 (webapp/save)
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		//업로드할 파일명 구하기
		String uploadFileName = FilenameChange.getDateChangeFileName(upload.getOriginalFilename());
		
		//사진들 업로드
		try
		{
			upload.transferTo(new File(uploadFolder+"/"+uploadFileName));
		}
		catch (IllegalStateException | IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map.put("title", title);
		map.put("photo", uploadFileName);
		
		return map;
	}
	
	@GetMapping("/munjeupload2")
	public String munje2()
	{
		return "upload/uploadformCRUDmunje";
	}
	
	@PostMapping("/munjeprocess2")
	public String upload2(
								HttpServletRequest request,
								@RequestParam String title,
								@RequestParam("upload") List<MultipartFile> uploadList,
								Model model)
	//여기서부터 함수 선언부
	{
		//제목을 모델에 저장
		model.addAttribute("title", title);
		
		//업로드할 프로젝트 내의 위치 지정 (webapp/save)
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		
		//업로드할 파일명을 저장할 리스트 변수
		List<String> list = new Vector<>();
		
		for(MultipartFile multiFile:uploadList)
		{
			//업로드할 파일명 구하기
			String uploadFileName = FilenameChange.getRandomChangeFileName(multiFile.getOriginalFilename());
			
			//사진을 업로드
			try
			{
				multiFile.transferTo(new File(uploadFolder+"/"+uploadFileName));
			}
			catch (IllegalStateException | IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//업로드된 파일명을 list에 추가
			list.add(uploadFileName);
		}
		
		model.addAttribute("list", list);
		
		//이게 왜 String인지?
		return "upload/uploadresultCRUDmunje";
	}
}
