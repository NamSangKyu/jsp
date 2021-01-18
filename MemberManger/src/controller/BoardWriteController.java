package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import model.ModelAndView;
import service.BoardService;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String id = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardDTO dto = BoardService.getInstance().insertBoardDTO(new BoardDTO(title, id, content));
		request.setAttribute("board", dto);
		
		return new ModelAndView("boardView.do?bno="+dto.getBno(), false);
	}

}
