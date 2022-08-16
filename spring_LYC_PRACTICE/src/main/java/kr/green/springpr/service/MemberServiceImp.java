package kr.green.springpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
 
import kr.green.springpr.dao.MemberDAO;
import kr.green.springpr.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    @Autowired
	BCryptPasswordEncoder passwordEncoder;
    //회원가입 메소드
	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		if(member.getMe_id() == null || member.getMe_id().length() == 0)
			return false;
		if(member.getMe_pw() == null || member.getMe_pw().length() == 0)
			return false;
		if(member.getMe_email() == null || member.getMe_email().length() == 0)
			return false;
		if((member.getMe_gender() != 'M' && member.getMe_gender() != 'f'))
			return false;
		if(member.getMe_birth() == null)
			return false;
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//이미 가입된 아이디라면 false
		if(dbMember != null)
			return false;
		//입력한 비밀번호를 암호화
		String endcodePw = passwordEncoder.encode(member.getMe_pw());
		//암호화된 비밀번호를 회원 비번으로 설정
		member.setMe_pw(endcodePw);
				
		memberDao.insertMember(member);
		return true;
	}
	//로그인메소드
	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		//멤버다오에게 멤버VO의 회원정보에서 회원들의 아이디를 가져오라고 시킴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//만약 가입된 아이디가 없다면
		if(dbMember == null)
			return null;
		//아이디와 비밀번호가 일치하는경우
		//matches(암호화된비번, 암호화된비번)
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw()))
			return dbMember;
		//아이디는 있지만 비번이 일치하지 않는경우
		return null;
	}

}
