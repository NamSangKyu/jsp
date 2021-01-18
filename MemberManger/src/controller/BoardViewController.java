package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.CommentDTO;
import model.ModelAndView;
import service.BoardService;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		if(request.getAttribute("board") == null) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardDTO board = BoardService.getInstance().selectBoardDTO(bno);
			request.setAttribute("board", board);
			ArrayList<CommentDTO> list = BoardService.getInstance().selectCommentDTO(bno);
			request.setAttribute("comment", list);
		}
		return new ModelAndView("board_detail_view.jsp", false);
	}

}
