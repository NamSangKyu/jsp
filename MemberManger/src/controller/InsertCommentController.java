package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CommentDTO;
import model.ModelAndView;
import service.BoardService;

public class InsertCommentController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//글번호, 작성자, 내용
		int bno = Integer.parseInt(request.getParameter("bno"));
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		int count = BoardService.getInstance()
				.insertBoardComment(new CommentDTO(bno, content, writer));
		
		try {
			response.getWriter().write(String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}


