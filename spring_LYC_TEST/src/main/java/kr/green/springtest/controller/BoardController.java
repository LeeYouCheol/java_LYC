package kr.green.springtest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;

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
	
}
