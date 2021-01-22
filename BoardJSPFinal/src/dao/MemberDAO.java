package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import exception.MemberException;
import vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private SqlSession session;
	private MemberDAO() {
		session = DBManager.getInstance().getSession();
	}

	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}

	public MemberVO selectMemberVO(String id) {
		return session.selectOne("member.selectMemberVO", id);
	}
	
	public void insertMemberVO(MemberVO vo) {
		session.insert("member.insertMemberVO", vo);
	}

	public void updatePass(String id, String pass) throws MemberException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		session.update("member.updatePass",map);		
	}

	public MemberVO login(String id, String pass) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("pass", pass);
		return session.selectOne("member.login", map);
	}

	public void updateMember(MemberVO vo) throws MemberException {
		session.update("member.updateMember",vo);
		session.commit();
	}

	public List<MemberVO> selectAllMemberVO() {
		//반드시 ArrayList 사용할 필요는 없음
		List<MemberVO> list = session.selectList("member.selectAllMember");
		return list;
	}

	public ArrayList<MemberVO> searchMember(String kind, String search) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select id, name, pass, age, grade_name "
				+ "from member, grade_list where grade_no = grade and " + kind + " like ? order by grade desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, "%" + search + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1), null, rs.getString(2), 
						rs.getInt(4), rs.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.getInstance().close(pstmt, rs);
		}
		
		return list;
	}

	public boolean updateManageMember(MemberVO vo) {
		String sql = "update member set name=?,age=?,grade="
				+ "(select grade_no from grade_list where grade_name = ?) where id=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGrade());
			pstmt.setString(4, vo.getId());
			
			int count = pstmt.executeUpdate();
			if(count == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean deleteMember(String id) {
		String sql = "delete from member where id=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = DBManager.getInstance().getConn().prepareStatement(sql);
			pstmt.setString(1, id);

			int count = pstmt.executeUpdate();
			if(count == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
}



















