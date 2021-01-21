package config;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import dto.EmployeeDTO;

public interface SQLMapper {
	@Select("select * from employee")
	public List<EmployeeDTO> selectEmployeeAll();
}
