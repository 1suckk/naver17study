package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import data.dto.MemberDto;

@Mapper
public interface MemberMapper {
	public int checkMyid(String Myid);
	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMember();
	public void deleteSelected(List<Integer> selected);
	public void deleteMember(int num);
	public MemberDto getMemberById(String myid);
	public void changePhoto(String mphoto, String myid);
	public void UpdateMember(MemberDto dto);
}
