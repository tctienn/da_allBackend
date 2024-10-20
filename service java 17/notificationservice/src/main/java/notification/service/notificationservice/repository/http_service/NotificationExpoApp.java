package notification.service.notificationservice.repository.http_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import notification.service.notificationservice.NotificationDTO.NotificationExpoDTO;

@FeignClient(name="expoapps", url = "https://exp.host/--/api/v2/push/send")
public interface NotificationExpoApp {
	@PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
	  void sendNotificationExpoApp(@RequestBody NotificationExpoDTO notificationExpoDTO );
	
}
