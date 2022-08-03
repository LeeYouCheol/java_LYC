package kr.green.spring.serveice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;

	@Override
	public String getEmail(String me_id) {
		if(me_id == null) {
			return null;
		}else {
			return memberDao.selectEmail(me_id);
		}
	}

	@Override
	public MemberVO getMember(String me_id) {
		if(me_id == null)
		return null;
		else
		return memberDao.selectMember(me_id);
	}

	@Override
	public MemberVO getMember(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null)
		return null;
		MemberVO dbmember = memberDao.selectMember(member.getMe_id());
		if(dbmember == null)
		return null;
		if(dbmember.getMe_pw().equals(member.getMe_pw()))
			return dbmember;
		return null;
	}
}
