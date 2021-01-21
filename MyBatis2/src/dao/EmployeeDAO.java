package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import config.SQLMapper;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSession session;
	private SQLMapper mapper;
	
	private EmployeeDAO() {
		session = DBManager.getInstance().getSqlSession();
		mapper = session.getMapper(SQLMapper.class);
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public List<EmployeeDTO> selectAllEmployee(){
		return mapper.selectEmployeeAll();
	}

	public int selectEmployeeCount() {
		return mapper.selectEmployeeCount();
	}
	
	public List<EmployeeDTO> selectPositionEmployee(int pos){
		return mapper.selectPositionEmployee(pos);
	}
	
}











