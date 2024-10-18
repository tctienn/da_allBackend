package grapservice.com.grapservice.DTO;

public class NotificationExpoDTO {

	private String to;
	private String title;
	private String body;
	public NotificationExpoDTO(String to, String title, String body) {
		super();
		this.to = to;
		this.title = title;
		this.body = body;
	}
	public NotificationExpoDTO() {
		super();
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	
	
	
}
