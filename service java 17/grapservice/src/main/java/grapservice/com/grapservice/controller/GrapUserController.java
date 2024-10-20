package grapservice.com.grapservice.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import grapservice.com.grapservice.DTO.UserLoginDTO;
import grapservice.com.grapservice.entity.GrapUserEntity;
import grapservice.com.grapservice.repository.GrapUserRepository;
import grapservice.com.grapservice.service.GrapUserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("grapuser")
public class GrapUserController {
	
	@Autowired
	private GrapUserService grapUserService;
	
	@PostMapping("create-grapuser") 			// yêu cầù string yyyy-MM-dd
	public String postMethodName(@RequestParam String name,@RequestParam String sdt,@RequestParam String address,@RequestParam String gender,@RequestParam String birth ,@RequestParam String scccd ,@RequestParam String password ,@RequestParam String gmail,@RequestParam MultipartFile imageCCCD,@RequestParam MultipartFile imageFace) {
		
		try {
			Date sqlDate = Date.valueOf(birth);
			grapUserService.CreateUser(name, sdt, address, gender, sqlDate, scccd, password, gmail, imageCCCD, imageFace);
			return "tạo tài khoản người dùng thành công";
		} catch (Exception e) {
			System.out.println("lỗi tạo tài khoản người dùng " + e);
			e.printStackTrace();
			return "lỗi tạo tài khoản người dùng "+e;
		}
		
	}
	@PostMapping("login")
	public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO){
		 try{
	            GrapUserEntity grapUserEntity = grapUserService.loginUser(userLoginDTO);
	            return ResponseEntity.ok(grapUserEntity);
	        }catch (Exception ex){
	        	System.out.println(ex);
	        	ex.printStackTrace();
	            return new ResponseEntity<>( "Đăng nhập không thành công : " + ex.getMessage(), HttpStatus.BAD_REQUEST);
	        }
		
	}
	
	@GetMapping("get-grapUsers-byStatus")
	public Page<GrapUserEntity> getAllGrapUserByStatus(@RequestParam String status,Pageable pageable){
		
		return grapUserService.getAllUserByStatus(status, pageable);
		
	}
	
	@Autowired
	private GrapUserRepository grapUserRepository;
//	lấy danh sách nhân viên đang hoạt động không phân trang
	@GetMapping("get-grapUsers")
	public List<GrapUserEntity> getAllGrapUserworking(){
		
		return grapUserRepository.findAll();
		
	}
	@GetMapping("get-grapUsers-byId/{id}")
	public ResponseEntity<?> getAllGrapUserByID(@PathVariable Integer id){
		
	
		try {
			return ResponseEntity.ok(grapUserService.getUserById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return	 new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@PostMapping("update-status-user")
	public ResponseEntity<?> updateStatusUserGrap(@RequestParam Integer idGrap, @RequestParam String status){
		
		try {
			GrapUserEntity grapUserEntity =  grapUserService.updateStatusGrapUser(idGrap, status);
			return ResponseEntity.ok(grapUserEntity);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("lỗi khi cập nhật trạng tái tài khoản uer grap"+ e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	
}
