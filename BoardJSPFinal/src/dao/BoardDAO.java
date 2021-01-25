package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardDTO;
import dto.CommentDTO;
import dto.FileDTO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private DBManager manager;
	private SqlSession session;
	private BoardDAO() {
		manager = DBManager.getInstance();
		session = DBManager.getInstance().getSession();
	}

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	// 게시글 번호 뽑는 부분
	public int getBoardNO() {
		int result = session.selectOne("board.getBoardNO"); 
		return result;
	}

	public void insertBoardDTO(BoardDTO dto) {
		session.insert("board.insertBoard", dto);
		session.commit();
	}

	public BoardDTO selectBoardDTO(int bno) {
		BoardDTO dto =session.selectOne("board.selectBoardNo", bno);
		return dto;
	}

	public void addCount(int bno) {
		session.update("board.addCount", bno);
		session.commit();
	}

	public void addLikeHate(int bno, int mode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno",bno );
		map.put("mode",mode );
		int count = session.update("board.addLikeHate", map);
		session.commit();
		System.out.println(count);
		
	}

	public int selectLikeHate(int bno, int mode) {
		int result = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno",bno );
		map.put("mode",mode );
		result = session.selectOne("board.selectLikeHate", map);
		return result;
	}

	public List<BoardDTO> selectBoardList(int pageNo,String mode) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pageNo", pageNo);
		map.put("mode", mode);
		return session.selectList("board.selectBoardList", map);
	}

	public int insertBoardComment(CommentDTO dto) {
		int count = 0;
		count = session.insert("board.insertBoardComment", dto);		
		return count;
	}

	public List<CommentDTO> selectCommentDTO(int bno) {
		List<CommentDTO> list = null;
		list = session.selectList("board.selectCommentDTO", bno);
		System.out.println(list);
		System.out.println(list.size());
		return list;
	}
	public int commentCount(int bno) {
		int result = 0;
		result = session.selectOne("board.commentCount", bno);
		return result;
	}
	//전체 게시글 개수
	public int getCount() {
		int result = 0;
		result = session.selectOne("board.getCount");
		return result;		
	}

	public void insertFileList(ArrayList<FileDTO> fList) {
			for(int i=0;i<fList.size();i++) 
				session.insert("board.insertFileList",fList.get(i));
			session.commit();
	}

	public List<FileDTO> selectFileList(int bno) {
		List<FileDTO> list = null;
		list = session.selectList("board.selectFileList", bno);
		return list;
	}

	public int deleteFileList(int bno) {
		int count = session.delete("board.deleteFileList", bno);
		session.commit();
		return count;
	}
	public int deleteBoard(int bno) {
		int count = session.delete("board.deleteBoard", bno);
		session.commit();
		return count;
		
	}
}













