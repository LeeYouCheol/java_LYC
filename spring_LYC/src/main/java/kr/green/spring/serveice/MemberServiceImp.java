package kr.green.spring.serveice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO member) {
		//유효성 검사 메소드
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
		//이미 가입된 아이디이면
		if(dbMember != null)
			return false;
		
		//입력한 비밀번호를 암호화
		String endcodePw = passwordEncoder.encode(member.getMe_pw());
		//암호화된 비밀번호를 회원 비번으로 설정
		member.setMe_pw(endcodePw);
		//다오에게 시킴
		memberDao.insertMember(member);
		return true;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return null;
		
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//가입된 아이디가 아니면
		if(dbMember == null)
			return null;
		//아이디 비번이 일치하는경우
		//matches(암호화된비번, 암호화된비번)
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw()))
			return dbMember;
		//아이디는 있지만 비번이 다른경우
		return null;
	}

	@Override
	public boolean checkId(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return false;
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user != null)
			return false;
		return true;
	}
}
