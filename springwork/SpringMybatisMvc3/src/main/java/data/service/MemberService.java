package data.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	public boolean isMyidCheck(String myid)
	{
		return memberMapper.checkMyid(myid)==1?true:false; //true 이면 중복이므로 가입 불가
	}
	
	public void insertMember(MemberDto dto)
	{
		memberMapper.insertMember(dto);
	}
	
	public List<MemberDto> getAllMember()
	{
		return memberMapper.getAllMember();
	}
	
	public void deleteSelected(List<Integer> selected)
	{
        memberMapper.deleteSelected(selected);
    }
	
	public void deleteMember(int num)
	{
		memberMapper.deleteMember(num);
	}
	
	public MemberDto login(String myid, String mpass) {
		MemberDto dto = memberMapper.getMemberById(myid);
		System.out.println("조회된 회원 정보: " + dto); // 로그 출력
		
		if (dto != null && dto.getMpass().equals(mpass))
		{
			System.out.println("로그인 성공: " + dto.getMyid()); // 로그 출력
			return dto; // 아이디와 비밀번호가 일치하면 회원 정보 반환
		}
		else
		{
            System.out.println("로그인 실패: 아이디 또는 비밀번호 불일치"); // 로그 출력
			return null; // 일치하지 않으면 null 반환
		}
	}
	
	public MemberDto getMemberbyId(String myid)
	{
		return memberMapper.getMemberById(myid);
	}
	
	public void changePhoto(String mphoto, String myid)
	{
		memberMapper.changePhoto(mphoto, myid);
	}
	
	public void updateMember(MemberDto dto) {
		memberMapper.UpdateMember(dto);
	}
}
	