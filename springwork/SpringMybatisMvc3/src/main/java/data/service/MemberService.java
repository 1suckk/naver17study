package data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import data.dto.MemberDto;
import data.mapper.MemberMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
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
}
