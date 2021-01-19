package dto;

public class FileDTO {
	//작성자, 글번호, 경로
	private String writer;
	private int bno;
	private String path;
	public FileDTO(String writer, int bno, String path) {
		super();
		this.writer = writer;
		this.bno = bno;
		this.path = path;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
