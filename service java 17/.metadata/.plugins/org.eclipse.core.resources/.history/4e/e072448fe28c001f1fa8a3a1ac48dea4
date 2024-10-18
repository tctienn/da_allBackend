package notification.service.notificationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import notification.service.event.dto.NotificationDTO;
import notification.service.notificationservice.entity.NotificationEntity;
import notification.service.notificationservice.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	// tạo và xuất thông báo
//	@PostMapping("notification-user-grap")
	@KafkaListener(topics = "notifiacion")
	public String postMethodName( NotificationDTO notificationDTO) {
		
		try {
			notificationService.createNotitication(notificationDTO);
			return ("gửi thông báo thành công");
		} catch (Exception e) {
			e.printStackTrace();
			return ("tạo và gửi thông báo không thành công: ");
		}
		
	}
	
	@GetMapping("get-notification-grapuser")
	public List<NotificationEntity> getMethodName(@RequestParam int idGrap) {
		return notificationService.getNotificationsForUserGrap(idGrap);
	}
	
	
	
}
