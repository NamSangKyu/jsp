package main;

import dao.EmployeeDAO;

public class MyBatisMain {

	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		int count = dao.selectEmployeeAllCount();
		System.out.println("현재 사원 인원수 : " + count);
	}

}
