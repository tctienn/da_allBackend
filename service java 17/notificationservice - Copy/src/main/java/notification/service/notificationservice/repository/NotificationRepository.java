package notification.service.notificationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import notification.service.notificationservice.entity.NotificationEntity;
////




public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {
	
	
//	hàm này dùng cho người dùng app
	@Query(value = "SELECT * FROM notification where user = :idGrap and user = 0;", nativeQuery = true)
	List<NotificationEntity> getNotificationForGrapUser(@Param("idGrap") int idGrap);
	
//	 hàm này dùng cho admin productservice
	List<NotificationEntity> findAll();
}
