package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private SqlSessionFactory factory;
	private SqlSession session;
	private EmployeeDAO() {
		String resource = "db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession(false);//false - not auto commit
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public int selectEmployeeAllCount() {
		int count = 0;
		count = session.selectOne("db.sqlmapper.selectAllCountEmployee");
		return count;
	}
	
	public List<EmployeeDTO> selectAllEmployee() {
		List<EmployeeDTO> list = session.selectList("db.sqlmapper.selectAllEmployee");
		return list;
	}
		
	public List<EmployeeDTO> selectPositionEmployee(int pos){
		return session.selectList("db.sqlmapper.selectPositionEmployee", pos);
	}
	/*직급이 start부터 end까지*/
	public List<EmployeeDTO> selectPositionAreaEmployee(int start,int end){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("n1", start);
		map.put("n2", end);
		return session.selectList("db.sqlmapper.selectPositionAreaEmployee", map);
	}
	
	public int insertEmployee(EmployeeDTO dto) {
		return session.insert("db.sqlmapper.insertEmployee", dto);		
	}

	public int updateEmployee(EmployeeDTO dto) {
		return session.update("db.sqlmapper.updateEmployee",dto);
	}
	
	
}












