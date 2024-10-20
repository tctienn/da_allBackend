package grapservice.com.grapservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import grapservice.com.grapservice.DTO.GroupInvoiceDTO;
import grapservice.com.grapservice.entity.ListInvoiceGrapEntity;
import grapservice.com.grapservice.repository.ListInvoiceGrapRepository;
import grapservice.com.grapservice.service.ListInvoiceGrapService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("oder-grap")
public class InvoiceGrapController {

	
	@Autowired
	private ListInvoiceGrapService listInvoiceGrapService;
	
	
//	tạo đơn hàng cho nhân viên
	@PostMapping("create-oder")
	public ResponseEntity<?> createOder (@RequestParam String soHD, @RequestParam int idGrap, @RequestParam Double priceOfGrap) {
		
		
		try{
			listInvoiceGrapService.CreateListInvoice(soHD, idGrap, priceOfGrap);
			return ResponseEntity.ok("tạo đơn hàng thành công");
        }catch (Exception ex){
            return new ResponseEntity<>("Tạo đơn hàng thất bại: "+ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
	}
	@PostMapping("destroy-Oder")
	public ResponseEntity<?> destroyOder(@RequestParam String soHD, @RequestParam Integer idGrap,@RequestParam String commend){ 
		try {
			listInvoiceGrapService.destroyOrder(soHD, idGrap,commend);
			return ResponseEntity.ok("hủy đơn hàng thành công");
		}catch (Exception e) {
            return new ResponseEntity<>("Hủy đơn hàng thất bại: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping("success-Oder")
	public ResponseEntity<?> successOder(@RequestParam String soHD, @RequestParam Integer idGrap,@RequestParam String token, @RequestParam MultipartFile imageFile){ 
		try {
			listInvoiceGrapService.successOder(soHD, idGrap,token,imageFile);
			return ResponseEntity.ok("xác nhận giao hàng thành công");
		}catch (Exception e) {
            return new ResponseEntity<>("xác nhận giao hàng thất bại: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	
	
//	trạng thái nhân viên đã nhận đơn
//	final String  receivedStatus = "received";
//	final String successStatus = "success";
//	final String falseStatus = "false";
	@GetMapping("oder-filter-by-idgrap-status-month")
	public List<ListInvoiceGrapEntity> filterOderGrapOnMonth(@RequestParam int idGrap, @RequestParam String status){
		return listInvoiceGrapService.getOderGrapOnMonthByIdGrapAndStatus(idGrap, status);
	}
	
	@GetMapping("oder-filter-by-idgrap-status")
	public List<ListInvoiceGrapEntity> filterOderGrap(@RequestParam int idGrap, @RequestParam String status){
		return listInvoiceGrapService.getOderGrapByIdGrapAndStatus(idGrap, status);
	}
	
	@GetMapping("get-oder-bysohd-andidgrap")
	public ListInvoiceGrapEntity getOderBySohdAndIdGrap(@RequestParam String soHD ,@RequestParam int idGrap) {
		return listInvoiceGrapService.getOderBySohdAndIdGrap(soHD, idGrap);

	}
	
	
	//xuất dữ liệu để xuất file excel
	@Autowired
	private ListInvoiceGrapRepository grapRepository;
	@GetMapping("get-groupInvoice-byUserGrap-month")
	public List<Object> groupInvoiceByUserMonth() {
		return grapRepository.groupInvoiceByUserForExcelMonth();
	}
	
	
	
	
	
}
