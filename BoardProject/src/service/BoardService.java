package service;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardDAO dao;
	public BoardService() {
		dao = BoardDAO.getInstance();
	}
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}

	public BoardDTO insertBoardDTO(BoardDTO dto) {
		int bno = dao.getBoardNO(); //게시글 번호 뽑음
		dto.setBno(bno);//게시글 번호 셋팅
		dao.insertBoardDTO(dto);
//		return dao.selectBoardDTO(bno);
		return null;
	}
	
}	









