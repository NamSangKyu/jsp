package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;
import service.QnAService;

public class ResponeUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		int qno = Integer.parseInt(request.getParameter("qno"));
		String answer = request.getParameter("response");
		ModelAndView view = null;
		int count = QnAService.getInstance().updateResponse(qno,answer);
		if(count == 0) {
			try {
				response.getWriter().write("<script>alert('답변 등록에 실패 했습니다');"
						+ "location.href='qnaAdminView.do'</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			view = new ModelAndView("adminQnaDetailView.do?qno="+qno, false);
		}
		System.out.println(count);
		return view;
	}

}





