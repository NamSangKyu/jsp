package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dto.QnaDTO;
import model.ModelAndView;
import service.QnAService;
import vo.PaggingVO;

public class QnaAdminViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = (String) request.getSession().getAttribute("id");
		String grade = (String) request.getSession().getAttribute("grade");
		int pageNo = 1;
		if(request.getParameter("pageNo") != null)
			 pageNo = Integer.parseInt(request.getParameter("pageNo"));
		ArrayList<QnaDTO> list = QnAService.getInstance().selectQnaList(id, pageNo, grade);
		int count = QnAService.getInstance().selectCount();
		PaggingVO vo = new PaggingVO(count, pageNo);
		System.out.println(vo);
		request.getSession().setAttribute("page", vo);
		request.getSession().setAttribute("list", list);
				
		return new ModelAndView("admin_qna.jsp",true);
	}

}




