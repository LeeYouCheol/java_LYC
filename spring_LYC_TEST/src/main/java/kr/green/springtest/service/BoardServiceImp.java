package kr.green.springtest.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.springtest.dao.BoardDAO;
import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.utils.UploadFileUtils;
import kr.green.springtest.vo.BoardVO;
import kr.green.springtest.vo.CommentVO;
import kr.green.springtest.vo.FileVO;
import kr.green.springtest.vo.LikesVO;
import kr.green.springtest.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	String uploadPath = "C:\\Users\\LYC\\OneDrive\\바탕 화면\\숙제\\java_LYC\\uploadfiles_test";
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		return boardDao.selectBoardList(cri);
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
	public void insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
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
		//다오에게 업데이트하라고 시킴
		boardDao.updateOrderBoard(board);
		//다오에게 게시글 작성하라고 시킴
		boardDao.insertBoard(board);
		
		if(files == null || files.length == 0) {
			return;
		}
		for(MultipartFile tmp : files) {
			insertFile(tmp, board.getBd_num());
		}
	}

	@Override
	public void updateBoard(BoardVO board, MemberVO user, MultipartFile[] files, int[] nums) {
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
		
		if(files != null && files.length != 0) {
			for(MultipartFile tmp : files) {
				insertFile(tmp, board.getBd_num());
			}
		}
		
		if(nums == null || nums.length == 0)
			return;
		for(int fi_num : nums) {
			FileVO file = boardDao.selectFile(fi_num);
			deleteFile(file);
		}
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
			return;
		dbBoard.setBd_del("Y");
		boardDao.updateBoard(dbBoard);
		
		//다오에게 게시글 번호에 맞는 첨부파일들을 가져오라고 시킴
		ArrayList<FileVO> fileList = boardDao.selectFileList(bd_num);
		//null체크, 첨부파일이 없으면 종료
		if(fileList == null || fileList.size() == 0)
			return;
		for(FileVO tmp : fileList) {
			deleteFile(tmp);
		}
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null)
			return 0;
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public String getLikesState(LikesVO likes, MemberVO user) {
		if(likes == null || user == null)
			return "0";
		
		likes.setLi_me_id(user.getMe_id());
		
		LikesVO dbLikes = boardDao.selectLikes(likes);
		
		try {
			if(dbLikes == null) {
				boardDao.insertLikes(likes);
				return "" + likes.getLi_state(); //1 or -1 문자열이 리턴
			}
			String res;
			if(likes.getLi_state() == dbLikes.getLi_state()) {
				dbLikes.setLi_state(0);
				res = likes.getLi_state() + "0";
			}else {
				dbLikes.setLi_state(likes.getLi_state());
				res = likes.getLi_state() + "";
			}
			boardDao.updateLikes(dbLikes);
			return res;
			
		}catch(Exception e) {}
		finally {
			boardDao.updateBoardLikes(likes.getLi_bd_num());
		}
		return "0";
	}

	@Override
	public LikesVO getLikes(int bd_num, MemberVO user) {
		if(user == null)
			return null;
		LikesVO likes = new LikesVO();
		likes.setLi_bd_num(bd_num);
		likes.setLi_me_id(user.getMe_id());
		return boardDao.selectLikes(likes);
	}

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		comment.setCo_me_id(user.getMe_id());
		boardDao.insertComment(comment);
		return true;
	}

	@Override
	public ArrayList<CommentVO> getCommentList(int bd_num, Criteria cri) {
		if(cri == null)
			return null;
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null || !board.getBd_del().equals("N"))
			return null;
		return boardDao.selectCommentList(bd_num,cri);
	}

	@Override
	public int getCommnetTotalCount(int bd_num) {
		BoardVO board = boardDao.selectBoard(bd_num);
		if(board == null || !board.getBd_del().equals("N"))
			return 0;
		return boardDao.selectCommentTotalCount(bd_num);
	}

	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		//다오에게 댓글정보에서 댓글번호와 일치하는 댓을글을 가져오라고 시킴
		CommentVO dbComment = boardDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id()))
			return false;
		//다오에게 댓글을 업데이트하라고 시킴
		boardDao.deleteComment(comment.getCo_num());
		return true;
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(comment == null || user == null)
			return false;
		
		CommentVO dbComment = boardDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id()))
			return false;
		boardDao.updateComment(comment);
		return true;
	}

	@Override
	public ArrayList<FileVO> getFileList(int bd_num) {
		return boardDao.selectFileList(bd_num);
	}
	//첨부파일 넣기
	private void insertFile(MultipartFile tmp, int bd_num) {
		String fi_ori_name = tmp.getOriginalFilename();
		if(tmp == null || fi_ori_name == null || fi_ori_name.length() == 0)
			return;
		try {
			String fi_name = UploadFileUtils.uploadFile(uploadPath, fi_ori_name, tmp.getBytes());
		
			FileVO file = new FileVO(fi_name, fi_ori_name, bd_num);
			boardDao.insertFile(file);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	//첨부파일 삭제
	private void deleteFile(FileVO tmp) {
		UploadFileUtils.deleteFile(uploadPath, tmp.getFi_name());
		boardDao.deleteFile(tmp.getFi_num());
	}
}
