package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;
import service.MemberService;
import vo.MemberVO;

public class MemberAdminController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		List<MemberVO> list = MemberService.getInstance().selectAllMemberVO();
		request.setAttribute("list", list);
		return new ModelAndView("member_manage_main.jsp", false);
	}

}
