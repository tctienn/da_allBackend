package grapservice.com.grapservice.DTO;

public class UserLoginDTO {

	private String gmail;
	private String password;
	public UserLoginDTO(String gmail, String password) {
		super();
		this.gmail = gmail;
		this.password = password;
	}
	public UserLoginDTO() {
		super();
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
