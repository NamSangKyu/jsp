package controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileDTO;
import model.ModelAndView;
import service.BoardService;

public class DeleteBoardController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		ArrayList<FileDTO> list = BoardService.getInstance().selectFileList(bno);
		for(int i=0;i<list.size();i++) {
			File file = new File("c:\\fileupload\\"+list.get(i).getWriter()
					+"\\"+list.get(i).getFileName());
			System.out.println(file.exists());
			System.out.println(file.getAbsolutePath());
			file.delete();//현재 연결된 파일을 삭제
		}
		//DB 처리
		//board_file_list에 있는 해당 게시글 파일 목록 삭제
		if(list.size() > 0)
			BoardService.getInstance().deleteFileList(bno);
		//board에서 해당 게시글 삭제
		BoardService.getInstance().deleteBoard(bno);
		return new ModelAndView("main.do", true);
	}
}







