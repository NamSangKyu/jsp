package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.QnaDTO;
import model.ModelAndView;
import service.QnAService;

public class QnaAdminDetailViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int qno = Integer.parseInt(request.getParameter("qno"));
		QnaDTO dto = QnAService.getInstance().selectQna(qno);
		ModelAndView view = null;
		if(dto==null) {
			try {
				response.getWriter().write("<script>alert('문의글이 없습니다.');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println(dto);
			request.setAttribute("dto", dto);
			view = new ModelAndView("admin_qna_view.jsp", false);
		}
		
		return view;
	}

}
