package controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import dto.BoardDTO;
import dto.FileDTO;
import model.ModelAndView;
import oracle.net.aso.f;
import service.BoardService;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//경로
		String root = "c:\\fileupload";
		//DiskFileItemFactory 초기화
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024,new File(root));
		ArrayList<FileDTO> fList = null;
		ModelAndView model = null;
		try {
		//데이터를 읽어와서 처리
		ServletFileUpload upload = new ServletFileUpload(factory); 
			List<FileItem> list = upload.parseRequest(request);
			String title = null;
			String id = null;
			String content = null;

			for(int i=0;i<list.size();i++) {
				if(list.get(i).isFormField()) {
					//입력한 데이터부분 처리
					String field =list.get(i).getFieldName(); 
					switch(field) {
					case "title":
						title = field;
						break;
					case "writer":
						id = field;
						break;
					case "content":
						content = field;
						break;
					}
				}else {
					//파일 업로드 처리
					int idx = list.get(i).getName().lastIndexOf("\\");
					if(idx==-1)
						idx = list.get(i).getName().lastIndexOf("/");
					String fileName = list.get(i).getName().substring(idx+1);
					File path = new File(root + "\\" + id + "\\"+fileName);
					list.get(i).write(path);
					//파일 경로 저장할 파일 --> 작성자, 글번호, 경로  DTO 클래스 생성
					if(fList == null) fList = new ArrayList<FileDTO>();
					fList.add(new FileDTO(id, 0, path.getName())); 
				}
			}
			
			
			BoardDTO bDto = BoardService.getInstance().insertBoardDTO(new BoardDTO(title, id, content));
			if(fList != null) {
				for(int i=0;i<fList.size();i++) {
					fList.get(i).setBno(bDto.getBno());
				}
				//파일 테이블에 저장
				BoardService.getInstance().insertFileList(fList);
			}
			request.setAttribute("board", bDto);
			model = new ModelAndView("boardView.do?bno="+bDto.getBno(), false);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}


