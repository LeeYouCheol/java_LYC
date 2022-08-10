package kr.green.spring.serveice;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	void isertBoard(BoardVO board, MemberVO user);

	ArrayList<BoardVO> getBoardList();

	void updateViews(Integer bd_num);

	BoardVO getBoard(Integer bd_num);

	void updateBoard(BoardVO board, MemberVO user);

	void deleteBoard(Integer bd_num, MemberVO user);

}