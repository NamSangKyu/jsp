package config;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import dto.EmployeeDTO;

/*
 * 리턴타입 --->  SQL 결과 형태
 * 매개변수 ---> PreparedStatement ? 처리위한 값
 * 메서드명 ---> 실행할 sql문 지칭
 * SQL문은 어노테이션으로 실행
 * 
 */
public interface SQLMapper {
	@Select("select * from employee")
	public List<EmployeeDTO> selectEmployeeAll();
	
	@Select("select count(*) from employee")
	public int selectEmployeeCount();
	
	@Select("select * from employee where position < #{no}")
	public List<EmployeeDTO> selectPositionEmployee(int param);
}














