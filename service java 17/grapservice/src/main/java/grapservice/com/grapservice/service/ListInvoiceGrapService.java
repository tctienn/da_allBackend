package grapservice.com.grapservice.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import grapservice.com.grapservice.DTO.InvoiceDTO;
import grapservice.com.grapservice.DTO.NotificationExpoDTO;
import grapservice.com.grapservice.entity.ListInvoiceGrapEntity;
import grapservice.com.grapservice.repository.GrapUserRepository;
import grapservice.com.grapservice.repository.ListInvoiceGrapRepository;
import grapservice.com.grapservice.repository.http_product_Service.NotificationExpoApp;
import grapservice.com.grapservice.repository.http_product_Service.ProductService;
import grapservice.com.grapservice.repository.http_product_Service.UploadImageService;
import jakarta.transaction.Transactional;

@Service
public class ListInvoiceGrapService {
	
//	token chung để toàn bộ các app expo nhận được thông báo
	final String tokenPrivateNotificationExpoApp = "ExponentPushToken[Mg1Bh0KdGGGQqxp29SZpA9]";

	@Autowired
	private ListInvoiceGrapRepository listInvoiceGrapRepository;
	
	@Autowired
	private GrapUserRepository grapUserRepository;
	
	@Autowired
	private GetDateData getDateData;
	
	@Autowired
	private ProductService productService;
	@Autowired
	private UploadImageService uploadImageService;
	
	@Autowired
	private NotificationExpoApp notificationExpoApp;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	
//	trạng thái nhân viên đã nhận đơn
	final String  receivedStatus = "received";
	final String successStatus = "success";
	final String falseStatus = "false";
//	lấy toàn bộ đơn hàng nhân viên đang  nhận giao
//	public Page<ListInvoiceGrapEntity> getAllInvoiceForGrapWait(Pageable page) throws Exception { 
//		
//		Page<ListInvoiceGrapEntity> listInvoices = listInvoiceGrapRepository.findAllByStatus("wait",page);
//		if(!(listInvoices == null)) {
//			throw new Exception("lỗi load danh sách hóa đơn của nhân viên grap hoặc hiện tại không có hóa đơn nào");
//		}
//		
//		return listInvoices;
//		
//		
//	}
	
//	tạo đơn hàng nhân viên nhận giao
	public void CreateListInvoice(String soHD, int idGrap, Double priceForGrap  ) throws Exception {
		
		ListInvoiceGrapEntity checkdata = listInvoiceGrapRepository.findBySohd(soHD).orElse(null);
		
		if(checkdata != null) {
			throw new  Exception("lỗi hóa đơn đã được sử lý trước đó ");
		}
		
//		if(checkdata.getStatus().equals("false") || checkdata.getStatus().equals("true")) {
//			throw new Exception("lỗi hóa đơn đã được sử lý trước đó ");
//		}
		if(productService.getBySoHD(soHD)==null) {
//			System.out.println("nulllllllllllllllllllllllllll");
			throw new  Exception("lỗi không tìm thấy hóa đơn trong nhánh product service ");
		}
		InvoiceDTO invoiceDTO = productService.getBySoHD(soHD);
		productService.updateInvoiceStatus(invoiceDTO.getSohd(), receivedStatus);
		
		ListInvoiceGrapEntity  invoiceGrapEntity = new ListInvoiceGrapEntity();
		invoiceGrapEntity.setSohd(invoiceDTO.getSohd());
		invoiceGrapEntity.setIdGrap(idGrap);
		invoiceGrapEntity.setPriceForGrap(priceForGrap);
		invoiceGrapEntity.setStatus(receivedStatus);
		invoiceGrapEntity.setTime_get(getDateData.getDateNow());
		invoiceGrapEntity.setTime_done(null);
		
		listInvoiceGrapRepository.save(invoiceGrapEntity);
		
		
	}
	
//	hủy đơn hàng của nhân viên	
	@Transactional
	public void destroyOrder(String soHD, Integer idGrap,String commend) throws Exception {
		

		ListInvoiceGrapEntity grapOder = listInvoiceGrapRepository.findBySohdAndIdGrap(soHD,idGrap).orElse(null);
//		System.out.println("data"+ soHD + " "+ idGrap);

		if(grapOder == null) {
			throw new  Exception("lỗi không thấy đơn hàng với id nhân viên và số hóa đơn ");
		}
		grapOder.setTime_done(getDateData.getDateNow());
		grapOder.setStatus(falseStatus);
		grapOder.setComment(commend);
		productService.updateInvoiceStatus(soHD, falseStatus);

		
		
		
	}
	
	
//	hàm xác nhận giao hàng thành công
	@Transactional
	public void successOder(String soHD, Integer idGrap,String token, MultipartFile imageFile) throws Exception {
		

		ListInvoiceGrapEntity grapOder = listInvoiceGrapRepository.findBySohdAndIdGrap(soHD,idGrap).orElse(null);
//		System.out.println("data"+ soHD + " "+ idGrap);

		if(grapOder == null) {
			throw new  Exception("lỗi không thấy đơn hàng với id nhân viên và số hóa đơn ");
		}
		grapOder.setTime_done(getDateData.getDateNow());
		grapOder.setStatus(successStatus);
		String imgUrl = uploadImageService.uploadImage(imageFile.getBytes());
		grapOder.setImageAccess(imgUrl);
//		grapOder.setComment(commend);
		productService.updateInvoiceStatus(soHD, successStatus);
//		System.out.println("token "+token+" "+imgUrl);
//
//		System.out.println("xác nhận giao hàng");

//		kafkaTemplate.send("successOder", "test data");
		NotificationExpoDTO notificationExpoDTO = new NotificationExpoDTO(token,"Xác nhận giao đơn hàng","Đã xác nhận giao đơn hàng "+soHD+" thành công");
		notificationExpoApp.sendNotificationExpoApp(notificationExpoDTO);

	}
	
//	lấy đơn hàng trong tháng hiện tại
	public List<ListInvoiceGrapEntity> getOderGrapOnMonthByIdGrapAndStatus(int idGrap, String Status) {
		
		return listInvoiceGrapRepository.getOderGrapOnMonthByIdGrapAndByStatus(idGrap, Status);
		
		
	}
//	lấy đơn hàng không giới hạn thời gian
	public List<ListInvoiceGrapEntity> getOderGrapByIdGrapAndStatus(int idGrap, String Status) {
		
		return listInvoiceGrapRepository.getOderGrapByIdGrapAndByStatus(idGrap, Status);
		
		
	}
//	lấy chi tiết đơn hàng theo user
	public ListInvoiceGrapEntity getOderBySohdAndIdGrap(String soHD, int idGrap) {
		
		return listInvoiceGrapRepository.findBySohdAndIdGrap(soHD, idGrap);
		
		
	}
	
	
	
	
	
}
