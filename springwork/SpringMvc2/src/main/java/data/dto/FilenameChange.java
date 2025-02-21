package data.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FilenameChange {
	public static String getDateChangeFileName(String originalName)
	{
		//파일명에 날짜를 붙여서 업로드해보자
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHss");
				//예) a.jpg => a_20250218104123.jpg
				
				//.를 기준으로 파일명과 확장자 구분
				String fileName = originalName.split("\\.")[0];
				String extName = originalName.split("\\.")[1];
				
				System.out.println(fileName); //파일명 디버깅
				System.out.println(extName); //확장자 디버깅
				
				//최종 업로드할 파일명
				String uploadFileName = fileName+"_"+sdf.format(new Date())+"."+extName;
				System.out.println(uploadFileName);
				return uploadFileName;
	}
	
	public static String getRandomChangeFileName(String originalName)
	{
		//확장자만 구하기
		String extName = originalName.split("\\.")[1];
		
		//최종 업로드할 파일명
		String uploadFileName = UUID.randomUUID()+"."+extName;
		
		return uploadFileName;
	}
}
