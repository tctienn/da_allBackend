package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import service.UplodaFileService;

@RestController
@RequestMapping("image")
public class UploadController {
	
	
	@Autowired
	private UplodaFileService uplodaFileService;
	
	@GetMapping("ui")
	private String ui() {
		return "ui";
	}
	
	@PostMapping("upload")
	public String UploadImg(@RequestParam("imageFile") MultipartFile imgFile) {
		String imgUrl = "null";
		try {
			imgUrl = uplodaFileService.uploadFile(imgFile);
			return imgUrl;
		}catch (Exception e) {
			return "errorIMG";		}
		
		
	}

}
