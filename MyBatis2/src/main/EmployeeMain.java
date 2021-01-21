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
		System.out.println("-------------------------------------------");
		System.out.println(EmployeeDAO.getInstance().selectEmployeeCount());
		System.out.println("-------------------------------------------");
		list = EmployeeDAO.getInstance().selectPositionEmployee(5);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		
		System.out.println("-------------------------------------------");
		list = EmployeeDAO.getInstance().selectPositionAreaEmployee(5,6);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		
	}

}





