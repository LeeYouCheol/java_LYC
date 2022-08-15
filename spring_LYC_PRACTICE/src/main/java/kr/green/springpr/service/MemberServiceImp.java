package kr.green.springpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import kr.green.springpr.dao.MemberDAO;
import kr.green.springpr.vo.MemberVO;
 
@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    MemberDAO memberDao;
    
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
		memberDao.insertMember(member);
		return true;
	}

}
