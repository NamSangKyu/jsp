package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;
import model.ModelAndView;
import service.BoardService;
import vo.PaggingVO;

public class MainMoveController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//게시판 첫번째 페이지 글목록
		int pageNo = 1;
		if(request.getParameter("pageNo")!=null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String mode = "bno";
		if(request.getParameter("mode") != null)
			mode = request.getParameter("mode");
		
		ArrayList<BoardDTO> list = BoardService.getInstance().selectBoardList(pageNo, mode);	
		request.setAttribute("list", list);
		
		//페이징 처리
		//전체 글 개수
		int count = BoardDAO.getInstance().getCount();
		PaggingVO vo = new PaggingVO(count, pageNo);
		
		request.setAttribute("pagging", vo);
		
		return new ModelAndView("main.jsp",false);
	}

}






