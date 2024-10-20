package grapservice.com.grapservice.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.status.Status;
import grapservice.com.grapservice.DTO.UserLoginDTO;
import grapservice.com.grapservice.entity.GrapUserEntity;
import grapservice.com.grapservice.repository.GrapUserRepository;
import grapservice.com.grapservice.repository.http_product_Service.NotificationService;
import grapservice.com.grapservice.repository.http_product_Service.UploadImageService;
import jakarta.transaction.Transactional;

@Service
public class GrapUserService {

	@Autowired
	private GrapUserRepository grapUserRepository;
	
	@Autowired
	private UploadImageService uploadImageService;
	@Autowired
	private NotificationService notificationService;
	
	public String CreateUser(String name, String sdt,String address,String gender,Date birth , String scccd ,String password ,String gmail, MultipartFile imageCCCD, MultipartFile imageFace) {

		GrapUserEntity grapUserEntity = new GrapUserEntity();
		
		grapUserEntity.setName(name);
		grapUserEntity.setSdt(sdt);
		grapUserEntity.setAddress(address);
		grapUserEntity.setGender(gender);
		grapUserEntity.setBirth(birth);
		grapUserEntity.setScccd(scccd);
		grapUserEntity.setPassword(password);
		grapUserEntity.setGmail(gmail);
		String urlImageCCCD = "null";
		String urlImageFace = "null";
		try {
			urlImageCCCD = uploadImageService.uploadImage(imageCCCD.getBytes());
			urlImageFace = uploadImageService.uploadImage(imageFace.getBytes());
		} catch (Exception e) {
			System.out.println("up load ảnh cccd hoặc face có vấn đề");
		}
		grapUserEntity.setImageCCCCD(urlImageCCCD);
		grapUserEntity.setImageFace(urlImageFace);
		grapUserEntity.setStatus("wait");
		
		grapUserRepository.save(grapUserEntity);
		try {
			notificationService.sendNotificationGmail(gmail, "thông báo tạo tài khoản nhân viên", "tài khoản của bạn đã được tạo thành công , vui lòng chờ quản trị viên xác nhận danh tính của bản");
		} catch (Exception e) {
			System.out.println("gửi gmail xác nhận tạo tài khoản nhân viên có vấn đề");
		}
				
				
		return "tạo tài khoản thành công";
		
	}
	
	public GrapUserEntity loginUser(UserLoginDTO userLoginDTO) throws Exception {
		System.out.println("param "+userLoginDTO.getGmail() + userLoginDTO.getPassword());

		GrapUserEntity grapUserEntity = grapUserRepository.findByGmailAndPassword(userLoginDTO.getGmail(), userLoginDTO.getPassword()).orElse(null);
		
		if(grapUserEntity == null) {
			throw new Exception("không tìm thấy thông tin gmail và password ");
			
		}
		
		grapUserEntity.setPassword(null);
		System.out.println("Đăng nhập "+userLoginDTO.getGmail() + userLoginDTO.getPassword());
		return grapUserEntity;
	}
	
	public Page<GrapUserEntity> getAllUserByStatus(String Status, Pageable pageable) {
		
		return grapUserRepository.findAllByStatus(Status, pageable);
		
	}
	
	/// thừa ?
	public GrapUserEntity getUserById(Integer idGrapUser) throws Exception {
		if(idGrapUser == null) {
			System.out.println("request không hợp lệ thiếu idGrapUser");
			throw new Exception("request không hợp lệ thiếu idGrapUser");
		}
		
		return grapUserRepository.findById(idGrapUser).orElse(null);
		
	}
	
	@Transactional
	public GrapUserEntity updateStatusGrapUser( Integer idGrap, String status ) throws Exception {
		GrapUserEntity grapUserEntity = grapUserRepository.findById(idGrap).orElse(null);
		if( grapUserEntity ==null) {
			
			throw new Exception("cảnh báo không tìm thấy user theo id "+ idGrap);
			
		}
		
		grapUserEntity.setStatus(status);
		String title = "";
		String body ="";
		if(status.equals("working")) {
			 title = "Thông báo tới người dùng "+ grapUserEntity.getName();
			 body ="Tài khoản của bạn đã được xác nhậ và đươc phép đi vào hoạt động"; 
		}
		if(status.equals("false")) {
			 title = "Thông báo tới người dùng "+ grapUserEntity.getName();
			 body =" Quản trị hệ thống đã quết định dừng hoạt động tài khoản của bạn , từ giờ tài khoản này không cò hiệu lực để sử dụng hệ thống app  nhân viên giao hàng  "; 
		}
		notificationService.sendNotificationGmail(grapUserEntity.getGmail(), title, body);
		return grapUserEntity;
		
		
		
		
		
	}
	
	
}
