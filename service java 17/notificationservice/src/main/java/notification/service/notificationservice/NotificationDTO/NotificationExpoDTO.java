package notification.service.notificationservice.NotificationDTO;

public class NotificationExpoDTO {
	private String to = "ExponentPushToken[Mg1Bh0KdGGGQqxp29SZpA9]";
	private String title;
	private String body;
	public NotificationExpoDTO( String title, String body) {
		super();
//		this.to = "ExponentPushToken[Mg1Bh0KdGGGQqxp29SZpA9]";
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
