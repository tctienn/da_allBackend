package grapservice.com.grapservice.repository.http_product_Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="notificationservice", url = "http://localhost:8083")
public interface NotificationService {
	@PostMapping(value = "notification/gmail/send-gmail",produces = MediaType.APPLICATION_JSON_VALUE)
	  String sendNotificationGmail(@RequestParam String gmail ,@RequestParam String title, @RequestParam String body);

}
