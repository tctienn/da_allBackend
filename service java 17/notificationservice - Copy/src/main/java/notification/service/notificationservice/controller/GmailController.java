package notification.service.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import notification.service.notificationservice.service.GmailService;

@RestController
@RequestMapping("notification/gmail")
public class GmailController {
	
	@Autowired
	private GmailService gmailService;
	
	@PostMapping("send-gmail")
	public ResponseEntity<?> sendGmail(@RequestParam String gmail, @RequestParam String title , @RequestParam String body) {
		
		try {
			gmailService.sendEmail(gmail, title, body);
			return ResponseEntity.ok("gửi gmail thành công");
		} catch (Exception e) {
			return ResponseEntity.ok("gửi gmail thành công");
		}
		
	}
	
}
