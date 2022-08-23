package kr.green.springtest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.pagination.PageMaker;
import kr.green.springtest.service.BoardService;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.CommentVO;
import kr.green.springtest.vo.LikesVO;
import kr.green.springtest.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//게시판 불러오기
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv, Criteria cri) {
		cri.setPerPageNum(2);
		//보드서비스에게 게시글 리스트를 요청
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		System.out.println(pm);
		mv.addObject("pm", pm);
		//화면에 게시글 리시트를 전송
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	//게시글 클릭해서 상세보기
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardSelectGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, HttpSession session) {
		//보드서비스에게 조회수 증가하라고 시킴
		boardService.updateViews(bd_num);
		//보드서비스에게 게시글을 가져오라고 시킨다.
		BoardVO board = boardService.getBoard(bd_num);
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		LikesVO likes = boardService.getLikes(bd_num, user);
		
		mv.addObject("likes",likes);
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
	//수정하는 메소드
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardUpdateGet(ModelAndView mv, @PathVariable("bd_num")int bd_num) {
		//보드서비스에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardService.getBoard(bd_num);
		//가져온 게시글을 화면에 출력
		mv.addObject("board", board);
		mv.setViewName("/board/update");
		return mv;
	}
	@RequestMapping(value="/board/update/{bd_num}", method=RequestMethod.POST)
	public ModelAndView boardUpdatePost(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, HttpSession session, BoardVO board) {
		//멤버vo에서 로그인한 회원정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");
		//게시글정보에 게시글 번호를 추가
		board.setBd_num(bd_num);
		//보드서비스에게 회원 정보와 게시글 정보를 주면서 수정하라고 시킴
		boardService.updateBoard(board, user);
		mv.setViewName("redirect:/board/select/"+bd_num);
		return mv;
	}
	//삭제기능
	@RequestMapping(value="/board/delete/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardDeleteGet(ModelAndView mv,
			@PathVariable("bd_num")int bd_num, HttpSession session) {
		//회원정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");
		//보드서비스에게 게시글번호와 유저정보를 주면서 삭제하라고 시킴
		boardService.deleteBoard(bd_num, user);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	@RequestMapping(value="/check/likes")
	@ResponseBody
	public Map<Object,Object> checkLikes(@RequestBody LikesVO likes,
			HttpSession session) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		//state : 추천=1, 비추=-1, 추천취소=10, 비추천취소=-10
		String state = boardService.getLikesState(likes, user);
		map.put("state", state);
		return map;
	}
	@RequestMapping(value="/ajax/comment/insert")
	@ResponseBody
	public Map<Object,Object> ajaxCommentInsert(@RequestBody CommentVO comment,
			HttpSession session) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertComment(comment,user);
		map.put("res", res);
		return map;
	}
	@RequestMapping(value="/ajax/comment/list/{bd_num}")
	@ResponseBody
	public Map<Object,Object> ajaxCommentInsert(@RequestBody Criteria cri,
			@PathVariable("bd_num") int bd_num) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		ArrayList<CommentVO> list = boardService.getCommentList(bd_num, cri);
		int totalCount = boardService.getCommnetTotalCount(bd_num);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
	@RequestMapping(value="/ajax/comment/delete")
	@ResponseBody
	public Map<Object,Object> ajaxCommentDelete(@RequestBody CommentVO comment,
			HttpSession session) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		System.out.println(user);
		System.out.println(comment);
		return map;
	}
}
