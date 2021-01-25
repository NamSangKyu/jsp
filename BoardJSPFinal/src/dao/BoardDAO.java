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
		String sql = "insert into board_file_list values(?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			for(int i=0;i<fList.size();i++) {
				pstmt = manager.getConn().prepareStatement(sql);
				pstmt.setInt(1, fList.get(i).getBno());
				pstmt.setString(2, fList.get(i).getWriter());
				pstmt.setString(3, fList.get(i).getFileName());
				pstmt.executeUpdate();
				manager.getConn().commit();
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<FileDTO> selectFileList(int bno) {
		String sql = "select * from board_file_list where bno = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new FileDTO(rs.getInt(1),rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public void deleteFileList(int bno) {
		String sql = "delete from board_file_list where bno = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, bno);
			int count = pstmt.executeUpdate();
			System.out.println("파일 DB 삭제 결과 : "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteBoard(int bno) {
		String sql = "delete from board where bno = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = manager.getConn().prepareStatement(sql);
			pstmt.setInt(1, bno);
			int count = pstmt.executeUpdate();
			System.out.println("게시글 삭제 결과 : "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}













