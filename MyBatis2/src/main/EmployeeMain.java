package main;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class EmployeeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<EmployeeDTO> list = EmployeeDAO.getInstance().selectAllEmployee();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("-------------------------------------------");
		/*
		 * System.out.println(EmployeeDAO.getInstance().selectEmployeeCount());
		 * System.out.println("-------------------------------------------"); list =
		 * EmployeeDAO.getInstance().selectPositionEmployee(5); for(int
		 * i=0;i<list.size();i++) { System.out.println(list.get(i).toString()); }
		 * 
		 * System.out.println("-------------------------------------------"); list =
		 * EmployeeDAO.getInstance().selectPositionAreaEmployee(5,6); for(int
		 * i=0;i<list.size();i++) { System.out.println(list.get(i).toString()); }
		 * System.out.println("-------------------------------------------"); String eno
		 * = sc.nextLine(); String name = sc.nextLine(); String department =
		 * sc.nextLine(); int position = sc.nextInt();
		 * System.out.println(EmployeeDAO.getInstance().insertEmployee(new
		 * EmployeeDTO(eno, name, department, position)));
		 * System.out.println("-------------------------------------------");
		 * 
		 * String eno = sc.nextLine(); String name = sc.nextLine(); String department =
		 * sc.nextLine(); int position = sc.nextInt(); HashMap<String, Object> map = new
		 * HashMap<String, Object>(); map.put("eno", eno); map.put("name", name);
		 * map.put("department", department); map.put("position", position);
		 * System.out.println(EmployeeDAO.getInstance().updateEmployee(map));
		 */
		String name = sc.nextLine();
		list = EmployeeDAO.getInstance().selectNameEmployee(name);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

}






