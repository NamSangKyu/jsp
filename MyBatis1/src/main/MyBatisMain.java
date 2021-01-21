package main;

import java.util.List;
import java.util.Scanner;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

public class MyBatisMain {

	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		/*
		 * int count = dao.selectEmployeeAllCount(); System.out.println("현재 사원 인원수 : " +
		 * count); System.out.println("-------------------------------------------");
		 * List<EmployeeDTO> list = dao.selectAllEmployee(); for(int
		 * i=0;i<list.size();i++) System.out.println(list.get(i).toString());
		 * System.out.println("-------------------------------------------"); list =
		 * dao.selectPositionEmployee(4); for(int i=0;i<list.size();i++)
		 * System.out.println(list.get(i).toString());
		 * System.out.println("-------------------------------------------"); list =
		 * dao.selectPositionAreaEmployee(2,5); for(int i=0;i<list.size();i++)
		 * System.out.println(list.get(i).toString());
		 * Scanner sc = new Scanner(System.in);
		 * 
		 * String eno = sc.nextLine(); String name = sc.nextLine(); String department =
		 * sc.nextLine(); int position = sc.nextInt(); int count =
		 * dao.insertEmployee(new EmployeeDTO(eno, name, department, position));
		 * System.out.println(count);
		 */
		System.out.println("-------------------------------------------");
		List<EmployeeDTO> list = dao.selectAllEmployee();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).toString());
		
		Scanner sc = new Scanner(System.in);

		String eno = sc.nextLine();
		String name = sc.nextLine();
		String department = sc.nextLine();
		int position = sc.nextInt();
		int count = dao.updateEmployee(new EmployeeDTO(eno, name, department, position));
		System.out.println(count);
		System.out.println("-------------------------------------------");
		list = dao.selectAllEmployee();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).toString());

	}

}





