package ql.vn.event.dto;

public class NotificationDTO {
	private Integer id;
	private String title;
	private String body;
	private int status;
	private int user;
	private String gmail;
	public NotificationDTO(Integer id, String title, String body, int status, int user, String gmail) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.status = status;
		this.user = user;
		this.gmail = gmail;
	}
	public NotificationDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	

	
	
}
