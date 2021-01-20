package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.ModelAndView;
import service.BoardService;

public class PlusLikeHateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			if(request.getSession().getAttribute("login") == null) {
				response.getWriter().write("false");
				return null;
			}
			int mode = Integer.parseInt(request.getParameter("mode"));
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardDAO.getInstance().addLikeHate(bno,mode);
				int count = BoardDAO.getInstance().selectLikeHate(bno,mode);
				response.getWriter().write(String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return null;
	}

}
