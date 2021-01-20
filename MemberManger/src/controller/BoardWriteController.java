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
		
		ModelAndView view = null;
		try {
			request.setCharacterEncoding("utf-8");
	
		String encoding = "utf-8";
		String root = "c:\\fileupload\\";
		File userRoot = new File(root);
		System.out.println("파일 업로드할 기본 폴더 : "+userRoot);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더
		factory.setSizeThreshold(1024 * 1024);//1mb -> 버퍼 메모리
		ServletFileUpload upload = new ServletFileUpload(factory); 
		
			List<FileItem> list = upload.parseRequest(request);
			ArrayList<FileDTO> fList = new ArrayList<FileDTO>();
			String user = "default";
			int bno = 0;
			String title = "";
			String content = "";
			String writer = "";
			for(int i=0;i<list.size();i++) {
				FileItem item = list.get(i);
				if(item.isFormField()) {
					//받은 내용중에 파일이 아닌 경우
					if(item.getFieldName().equals("title"))
						title = item.getString(encoding);
					else if(item.getFieldName().equals("writer"))
						writer = item.getString(encoding);
					else if(item.getFieldName().equals("content"))
						content = item.getString(encoding);
					
					System.out.println(item.getFieldName() + " : " + item.getString(encoding));
				}else {
					//받은 내용중에 파일인 경우
					System.out.println("매개변수 명 : "+item.getFieldName());
					System.out.println("파일명 : "+item.getName());
					System.out.println("파일크기 : "+item.getSize());
					System.out.println("파일타입 : "+item.getContentType());
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx==-1)
							idx = item.getName().lastIndexOf("/");
						String fileName = item.getName().substring(idx+1);
						//파일 경로 완성
						File uploadFile = new File(root + "\\" + fileName);
						if(!uploadFile.getParentFile().exists())//해당 파일이 들어갈 폴더까지 경로가 유효?
							uploadFile.getParentFile().mkdirs();//해당 경로까지 모든 폴더 생성
						System.out.println("셋팅된 전체 경로 : "+uploadFile);
						item.write(uploadFile);//파일 쓰기
						FileDTO dto = new FileDTO(uploadFile);
						fList.add(dto);
						
					}
					
				}
			}
			System.out.println(writer);
			BoardDTO dto = BoardService.getInstance().insertBoardDTO(new BoardDTO(title, writer, content));
			for(int i=0;i<fList.size();i++) {
				fList.get(i).setBno(dto.getBno());
			}
			//파일 테이블에 저장
			BoardService.getInstance().insertFileList(fList);
			System.out.println("파일쓰기 완료");
			view = new ModelAndView("boardView.do?bno="+dto.getBno(), false);
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

}


