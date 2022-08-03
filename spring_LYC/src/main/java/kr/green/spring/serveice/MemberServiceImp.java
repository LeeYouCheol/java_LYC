package kr.green.spring.serveice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;

	@Override
	public String getEmail(String id) {
		if(id == null) {
			return null;
		}else {
			return memberDao.selectEmail(id);
		}
	}
}
