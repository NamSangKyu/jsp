package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.MemberException;
import model.ModelAndView;
import service.MemberService;
import vo.MemberVO;

public class MemberAjaxUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String id =request.getParameter("id");
		String name =request.getParameter("name");
		String grade =request.getParameter("grade");
		int age = Integer.parseInt(request.getParameter("age"));
		
		MemberVO vo = new MemberVO(id, null, name, age, grade);
		try {
			int count = MemberService.getInstance().updateManageMemberVO(vo);
			response.getWriter().write(String.valueOf(count));
		} catch (MemberException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return null;
	}

}
