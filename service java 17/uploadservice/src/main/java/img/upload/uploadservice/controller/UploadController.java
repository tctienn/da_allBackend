package img.upload.uploadservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import img.upload.uploadservice.model.CustomMultipartFile;
import img.upload.uploadservice.service.UplodaFileService;

@RestController
@RequestMapping("image")
public class UploadController {

	@GetMapping("ui")
	private String ui() {
		return "ui";
	}
	
	@Autowired
	private UplodaFileService uplodaFileService;
	
	
//	yêu cầu nến các service giao tiếp bằng @FeignClient thì không dùng MultipartFile mà dùng byte vì có lỗi sử lý khi gửi
	@PostMapping("upload")
	public String UploadImg(@RequestBody byte[] imageBytes) {
//		đổi định dạng file
//		byte[] imageBytes = ...; // Your byte array
		String name = "image"; // The name you want
		String originalFilename = "myImage.jpg"; // Original file name
		String contentType = "image/jpeg"; // Content type

		MultipartFile imgFile = new CustomMultipartFile(imageBytes, name, originalFilename, contentType);
		
		
		
//		
		
	
		
		String imgUrl = "null";
		try {
			imgUrl = uplodaFileService.uploadFile(imgFile);
			return imgUrl;
		}catch (Exception e) {
			return "errorIMG "+e;		}
		
		
	}

	
}
