package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.QnaDTO;

public class QnADAO {
	private static QnADAO instance = new QnADAO();
	private SqlSession session;
	private QnADAO() {
		session = DBManager.getInstance().getSession();
	}

	public static QnADAO getInstance() {
		if(instance == null)
			instance = new QnADAO();
		return instance;
	}

	public int insertQna(QnaDTO dto) {
		int result = 0;
		result = session.insert("qna.insertQna", dto);		
		return result;
	}
	//개인 문의 목록을 조회
	public List<QnaDTO> selectQnaList(String id, int pageNo){
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<QnaDTO> list = null;
		list = session.selectList("qna.selectQnaList",map);		
		return list;
	}

	public List<QnaDTO> selectQnaAdminList(int pageNo) {
		List<QnaDTO> list = null;
		list = session.selectList("qna.selectQnaAdminList",pageNo);
		return list;
	}

	public List<QnaDTO> selectNoAnswerList() {
		List<QnaDTO> list = session.selectList("qna.selectNoAnswerList");
		return list;
	}

	public int selectCountQna() {
		int count = session.selectOne("qna.selectCountQna");		
		return count;
	}

	public QnaDTO selectQna(int qno) {
		QnaDTO dto = session.selectOne("qna.selectQna",qno);
		return dto;
	}

	public int updateResponse(int qno, String answer) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("qno", qno);
		map.put("answer", answer);
		int count = session.update("qna.updateResponse", map);
		return count;
	}

	public int updateQnAStatus(int qno) {
		int count = session.update("qna.updateQnAStatus", qno);
		return count;
	}
}



















