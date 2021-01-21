package config;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	@Select("select * from employee where position between #{n1} and #{n2}")
	public List<EmployeeDTO> selectPositionAreaEmployee(@Param("n1")int num1,@Param("n2") int num2 );
	
	//map이나 dto가들어오면 매개변수랑 자동으로 매칭
	@Insert("insert into employee(eno, name, department,position) values(#{eno},#{name},#{department},#{position})")
	public int insertEmployee(EmployeeDTO dto);
	
	@Update("update employee set name = #{name}, department=#{department}, position = #{position} where eno like #{eno}")
	public int updateEmployee(HashMap<String, Object> map);
}














