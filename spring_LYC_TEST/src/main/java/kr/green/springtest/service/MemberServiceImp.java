package kr.green.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.MemberDAO;
import kr.green.springtest.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    
	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		if(member.getMe_id() == null || member.getMe_pw() == null || member.getMe_birth() == null || member.getMe_email() == null || member.getMe_gender() == null)
			return false;
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		if(dbMember != null)
			return false;
		System.out.println(member);
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		
		memberDao.insertMember(member);
		return true;
	}

	@Override
	public MemberVO login(MemberVO member) {
		//멤버 목록이 null이거나 멤버아이디가 null이라면
		if(member == null || member.getMe_id() == null)
		return null;
		
		//다오에게 멤버중에서 로그인한 아이디와 일치하는걸 가져오라고함
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//비교해서, 없으면 null
		if(user == null)
			return null;
		//멤버에 회원 정보가 있고 비밀번호가 같으면
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		//둘다아니면 null
		return null;
	}

	@Override
	public Object idcheck(MemberVO member) {
		if(member == null || member.getMe_id() == null)
			return false;
		if(memberDao.selectMember(member.getMe_id()) != null)
			return false;
		return true;
	}
    
}
