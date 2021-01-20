package main;

import java.util.List;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {

	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		int count = dao.selectEmployeeAllCount();
		System.out.println("현재 사원 인원수 : " + count);
		System.out.println("-------------------------------------------");
		List<EmployeeDTO> list = dao.selectAllEmployee();
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i).toString());
	}

}











