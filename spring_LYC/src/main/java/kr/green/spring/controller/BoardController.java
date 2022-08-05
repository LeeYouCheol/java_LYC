package kr.green.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.serveice.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Controller // 컨트롤러는 이런 어노테이션을 붙여야한다
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value= "/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value= "/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsertGet(ModelAndView mv) {
		mv.setViewName("/board/insert");
		return mv;
	}
	@RequestMapping(value= "/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, HttpSession session) {
		//화면에서 전송한 데이터가 잘 오는지 확인
		///System.out.println(board);
		//로그인한 회원 정보를 확인
		MemberVO user = (MemberVO)session.getAttribute("user");
		//System.out.println(user);
		boardService.isertBoard(board,user);
		mv.setViewName("redirect://board/list");
		return mv;
	}
}
