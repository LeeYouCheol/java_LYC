package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.springtest.dao.BoardDAO;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public BoardVO getBoard(int bd_num) {
		return boardDao.selectBoard(bd_num);
	}

	@Override
	public void updateViews(int bd_num) {
		boardDao.updateViews(bd_num);
	}

	@Override
	public void insertBoard(BoardVO board, MemberVO user) {
		if(board == null || board.getBd_title() == null || board.getBd_content() == null)
			return;
		//제목에 공백만 있는 경우
		if(board.getBd_title().trim().length() == 0)
			return; //등록 못하게함
		//내용에 공백만 있는 경우
		if(board.getBd_content().trim().length() == 0)
			return; //등록 못하게 함
		//로그인 안한 경우
		if(user == null || user.getMe_id() == null)
			return;
		
		//게시글 작성자로 회원 아이디를 저장
		board.setBd_me_id(user.getMe_id());
		//다오에게 게시글 작성하라고 시킴
		boardDao.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user) {
		if(user == null || board == null)
			return;
		//게시글 번호에 맞는 게시글 정보(dbBoard)를 가져옴
		//board에 게시글 번호가 있기때문에 board.getBd_num() 라고 적는다
		BoardVO dbBoard = boardDao.selectBoard(board.getBd_num());
		//게시글이 없거나 삭제된 게시글이면 종료
		if(dbBoard == null || !dbBoard.getBd_del().equals("N"))
			return;
		//게시글의 작성자와 회원의 아이디가 같은지 확인하여 다르면 종료
		if(!user.getMe_id().equals(dbBoard.getBd_me_id()))
			return;
		//제목에 공백만 있는경우
		if(board.getBd_title().trim().length() == 0)
			return;
		//내용에 공백만 있는경우
		if(board.getBd_content().trim().length() == 0)
			return;
		//다오에게 게시글 정보를 주면서 수정하라고 시킴
		boardDao.updateBoard(board);
	}

	@Override
	public void deleteBoard(int bd_num, MemberVO user) {
		//회원 정보 null체크해서 null이면 종료
		if(user == null)
			return;
		//보드다오에게 게시글번호를 주면서 가져오라고 시킴
		BoardVO dbBoard = boardDao.selectBoard(bd_num);
		//가져온 게시글의 작성자와 회원 아이디가 다르면 종료
		if(!user.getMe_id().equals(dbBoard.getBd_me_id()))
			return;
		if(dbBoard == null || !dbBoard.getBd_del().equals("N"))
		dbBoard.setBd_del("Y");
		boardDao.updateBoard(dbBoard);
		return;
	}
}
