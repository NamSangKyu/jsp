package service;

import dao.BoardDAO;

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
	
}	
