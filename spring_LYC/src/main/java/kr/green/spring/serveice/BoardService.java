package kr.green.spring.serveice;

import java.util.ArrayList;

import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

public interface BoardService {

	void isertBoard(BoardVO board, MemberVO user);

	ArrayList<BoardVO> getBoardList();

}
