package grapservice.com.grapservice.repository.http_product_Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

//import grapservice.com.grapservice.DTO.InvoiceDTO;

import org.springframework.web.multipart.MultipartFile;

import feign.Headers;
import feign.RequestLine;


@FeignClient(name="upload-image-service", url = "http://localhost:8082/")

public interface UploadImageService {
	 @PostMapping(value = "/image/upload", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	    String uploadImage(@RequestBody byte[] imageBytes);
//	@PostMapping(value = "/image/uploads", consumes = MediaType.APPLICATION_JSON_VALUE)
//	  String uploadImage(@RequestParam("imageFile") String imageFile);
}
