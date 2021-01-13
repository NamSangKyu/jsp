package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DBConfig;
import config.DBManager;
import dto.QnaDTO;

public class QnADAO {
	private static QnADAO instance = new QnADAO();
	
	private QnADAO() {

	}

	public static QnADAO getInstance() {
		if(instance == null)
			instance = new QnADAO();
		return instance;
	}

	public int insertQna(QnaDTO dto) {
		int result = 0;
		
		String sql = "insert into qna(qno, title, contetnt, wirter) "
				+ "values(qno_seq.nextval, ?, ? ,?)";
		try {
			PreparedStatement pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getWriter());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}

	
}



















