package service;

import dao.QnADAO;
import dto.QnaDTO;

public class QnAService {
	private static QnAService instance = new QnAService();
	private QnADAO dao;
	private QnAService() {
		dao = QnADAO.getInstance();
	}
	
	public static QnAService getInstance() {
		if(instance==null)
			instance= new QnAService();
		return instance;
	}

	public int insertQnA(QnaDTO dto) {
		return dao.insertQna(dto);
	}
	
	
}










