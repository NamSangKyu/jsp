package main;
import java.util.List;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeMain {

	public static void main(String[] args) {
		List<EmployeeDTO> list = EmployeeDAO.getInstance().selectAllEmployee();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println(EmployeeDAO.getInstance().selectEmployeeCount());
	}

}
