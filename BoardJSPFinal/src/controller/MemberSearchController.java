package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;
import service.MemberService;
import vo.MemberVO;

public class MemberSearchController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		List<MemberVO> list = MemberService.getInstance().searchMember(kind, search);
		String result = "";
		for(int i=0;i<list.size();i++) {
			result += list.get(i).getId() + " " + list.get(i).getName()
					+ " " + list.get(i).getAge()  + " " + list.get(i).getGrade()+",";
					
		}
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
