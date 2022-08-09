package kr.green.springtest.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//게시판 불러오기
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv) {
		//보드서비스에게 게시글 리스트를 요청
		ArrayList<BoardVO> list = boardService.getBoardList();
		//화면에 게시글 리시트를 전송
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	//게시글 클릭해서 상세보기
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardSelectGet(ModelAndView mv, @PathVariable("bd_num")int bd_num) {
		//보드서비스에게 조회수 증가하라고 시킴
		boardService.updateViews(bd_num);
		//보드서비스에게 게시글을 가져오라고 시킨다.
		BoardVO board = boardService.getBoard(bd_num);
		mv.addObject("board", board);
		mv.setViewName("/board/select");
		return mv;
	}
	//글쓰기
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsetGet(ModelAndView mv) {
		mv.setViewName("/board/insert");
		return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, HttpSession session) {
		//로그인한 회원 정보를 확인
		MemberVO user = (MemberVO)session.getAttribute("user");
		//보드서비스에게 게시물과 아이디를 주고 일을 시킴
		boardService.insertBoard(board,user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}
