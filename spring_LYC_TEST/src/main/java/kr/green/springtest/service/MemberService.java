package kr.green.springtest.service;

import kr.green.springtest.vo.MemberVO;

public interface MemberService {

	public boolean signup(MemberVO member);

	public MemberVO login(MemberVO member);

	public Object idcheck(MemberVO member);

	public String getId(MemberVO member);

	public boolean findPw(MemberVO member);

	public boolean updateMember(MemberVO member, MemberVO user);

}
