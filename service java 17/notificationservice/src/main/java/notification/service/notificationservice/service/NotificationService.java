package notification.service.notificationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import notification.service.notificationservice.NotificationDTO.NotificationExpoDTO;
import notification.service.notificationservice.entity.NotificationEntity;
import notification.service.notificationservice.repository.NotificationRepository;
import notification.service.notificationservice.repository.http_service.NotificationExpoApp;
import ql.vn.event.dto.NotificationDTO;

@Service
public class NotificationService {

	@Autowired
	private GetDateData getDateData;
	@Autowired
	private GmailService gmailService;
	
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private NotificationExpoApp notificationExpoApp;
	
//	trạng thái 1: tạo thông báo , 2 tạo thông báo và gủi gmail status = 0 là off còn status > là on 
	public String createNotitication(NotificationDTO notificationDTO) {
		NotificationEntity notificationEntity = new NotificationEntity();
		

		notificationEntity.setBody(notificationDTO.getBody());
		notificationEntity.setStatus(1);
		notificationEntity.setUser(notificationDTO.getUser());
		notificationEntity.setTitle(notificationDTO.getTitle());
		notificationEntity.setCreateTime(getDateData.getDateNow());
		
		notificationRepository.save(notificationEntity);
		if(notificationDTO.getGmail() != null&& notificationDTO.getUser()>0)// gửi gmail
		{
			gmailService.sendEmail(notificationDTO.getGmail(), notificationDTO.getTitle(),notificationDTO.getBody()  );
		}else {
			NotificationExpoDTO notificationExpoDTO = new NotificationExpoDTO(notificationDTO.getTitle(),notificationDTO.getBody());
			System.out.println("entiti notification expo"+ notificationDTO.getGmail());

			notificationExpoApp.sendNotificationExpoApp(notificationExpoDTO);
		}
		return "tạo và gửi thông báo thành công";
		
	}
	public List<NotificationEntity> getNotificationsForUserGrap(int idGrap){
		
		return notificationRepository.findAll();
		
	}

	public void DeleteNotifiaction (NotificationDTO notificationDTO) {
		
//		NotificationEntity notificationEntity = notificationRepository.findById(notificationDTO.getId()).orElse(null);
//		if(notificationEntity == null) {
//			
//		}
		notificationRepository.deleteById(notificationDTO.getId());
		
		
	}
	
	
}
