package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.QnaDTO;
import model.ModelAndView;
import service.QnAService;

public class NextQnaListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 조회할 페이지 번호 읽어옴, 아이디(session에 이미 저장)
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String id = (String) request.getSession().getAttribute("id");
		String grade = (String) request.getSession().getAttribute("grade");
		//2. 해당 페이지 목록을 읽어옴 - ArrayList<QnaDTO>
		ArrayList<QnaDTO> list = QnAService.getInstance().selectQnaList(id, pageNo, grade);
		//3. 다음페이지번호 다음페이지가 없으면 0
		if(QnAService.getInstance().selectQnaList(id, pageNo+1, grade).size() == 0)
			pageNo = 0;
		else
			pageNo++;			
 		//4. JSON으로 변환(QnaDTO, 다음페이지번호)
		JSONObject result = new JSONObject();
		JSONArray array = new JSONArray(list);
		result.put("nextPage", pageNo);
		result.put("list", array);
		//5. writer로 출력
		try {
			response.getWriter().write(result.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//6. ModelAndView 없음 그래서 null로 리턴
		return null;
	}

}





