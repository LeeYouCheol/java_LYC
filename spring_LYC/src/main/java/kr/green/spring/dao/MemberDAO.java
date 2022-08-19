package kr.green.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);
	//m은 member를 줄인것
	void insertMember(@Param("m")MemberVO member);
	ArrayList<String> selectIdList(@Param("m")MemberVO member);

}
