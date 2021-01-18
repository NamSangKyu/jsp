package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;

public class LoginViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println(request.getSession().getAttribute("resultPage"));
		System.out.println(request.getSession().getAttributeNames().toString());
		return new ModelAndView("login.jsp",false);
	}

}
