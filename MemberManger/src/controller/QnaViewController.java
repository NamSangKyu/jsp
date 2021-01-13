package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelAndView;

public class QnaViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		//아이디에 해당되는 문의 목록을 조회 처음에는 페이지 번호 1
		//단. 관리자일떄는 모든 사용자의 문의 목록을 읽어옴
		//아이디는 세션에서 읽음
		//문의 목록은 request/session 영역에 저장
		//페이지는 qna.jsp로 이동
		return null;
	}

}
