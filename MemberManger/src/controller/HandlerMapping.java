package controller;
//각종 컨트롤러를 찍어는 클래스
//싱글톤 패턴, 팩토리 패턴이 적용
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {	}

	public static HandlerMapping getInstance() {
		if(instance==null)
			instance = new HandlerMapping();
		return instance;
	}
	//원하는 컨트롤러를 찍어는 메서드
	public Controller createController(String command) {
		Controller controller = null;
		switch(command) {
		case "login.do":
			controller = new LoginController();
			break;
		case "logout.do":
			controller = new LogoutController();
			break;
		case "register.do":
			controller = new RegisterController();
			break;
		case "updateView.do":
			controller = new UpdateViewController();
			break;
		case "updateAction.do":
			controller = new UpdateController();
			break;
		case "sendQnA.do":
			controller = new InsertQnAController();
			break;
		case "qnaView.do":
			controller = new QnaViewController();
			break;
		case "nextQnaList.do":
			controller = new NextQnaListController();
			break;
		case "qnaAdminView.do":
			controller = new QnaAdminViewController();
			break;
		case "adminQnaDetailView.do":
			controller = new QnaAdminDetailViewController();
			break;
		case "answer.do":
			controller = new ResponeUpdateController();
			break;
		case "main.do":
			controller = new MainMoveController();
			break;
		case "boardWriteView.do":
			controller = new BoardWriteViewController();
			break;
		case "loginView.do":
			controller = new LoginViewController();
			break;
		}
		return controller;
	}
	
}




