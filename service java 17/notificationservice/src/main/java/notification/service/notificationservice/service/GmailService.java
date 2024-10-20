package notification.service.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import notification.service.notificationservice.entity.NotificationEntity;
import notification.service.notificationservice.repository.NotificationRepository;

@Service
public class GmailService {
	private final JavaMailSender mailSender;

    public GmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
    
    
    @Autowired
    private NotificationRepository notificationRepository;
    
    public void createNotification(NotificationEntity notificationParam) throws Exception {
    	if(notificationParam == null) {
    		System.out.println("lỗi null param notification");
    		throw new Exception("lỗi null param notification");
    	}
    	
    	GetDateData getDateData= new GetDateData();
    	notificationParam.setCreateTime(getDateData.getDateNow());
    	notificationRepository.save(notificationParam);
		if(notificationParam.getUser()>0) {
			
		}
    }
    
}
