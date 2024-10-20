package notification.service.notificationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import notification.service.notificationservice.entity.NotificationEntity;
import notification.service.notificationservice.repository.NotificationRepository;
import notification.service.notificationservice.service.NotificationService;
import ql.vn.event.dto.NotificationDTO;

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
		System.out.println("data notifiacton:"+notificationDTO.getId()+"|"+ notificationDTO.getUser()+"|"+ notificationDTO.getGmail() +"|"+ notificationDTO.getTitle());
		try {
			notificationService.createNotitication(notificationDTO);
			return ("gửi thông báo thành công");
		} catch (Exception e) {
			e.printStackTrace();
			return ("tạo và gửi thông báo không thành công: ");
		}
		
	}
	@KafkaListener(topics = "deleteNotification")
	public void deleteNotification( NotificationDTO notificationDTO) {
		System.out.println("data delete:"+notificationDTO.getId()+"|"+ notificationDTO.getUser()+"|"+ notificationDTO.getGmail() +"|"+ notificationDTO.getTitle());

		notificationService.DeleteNotifiaction(notificationDTO);
	}
	
	@GetMapping("get-notification-grapuser")
	public List<NotificationEntity> getMethodName(@RequestParam int idGrap) {
		return notificationService.getNotificationsForUserGrap(idGrap);
	}
	
	
	
//	@GetMapping("getall-botification")
//	public List<NotificationEntity> getMethodName() {
//		return notificationService.getNotificationsForUserGrap(idGrap);
//	}
	
	@Autowired 
	private NotificationRepository notificationRepository;
	@GetMapping("getall-notifiaction")
	public Page<NotificationEntity> getallNotification(Pageable pageable){
		return notificationRepository.findAll(pageable);
		
	}
	
	
	
}
