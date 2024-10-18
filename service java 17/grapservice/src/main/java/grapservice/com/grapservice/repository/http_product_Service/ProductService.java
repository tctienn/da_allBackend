package grapservice.com.grapservice.repository.http_product_Service;

//import java.awt.PageAttributes.MediaType;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import grapservice.com.grapservice.DTO.InvoiceDTO;

@FeignClient(name="grap-service", url = "http://localhost:8080/public/personnel")
public interface ProductService {
	 @GetMapping(value = "/get-invoice-bysohd",produces = MediaType.APPLICATION_JSON_VALUE)
	  InvoiceDTO getBySoHD(@RequestParam("mahd") String mahd);
	 
	 @PostMapping(value = "/update-invoice-product",produces = MediaType.APPLICATION_JSON_VALUE)
	  InvoiceDTO updateInvoiceStatus(@RequestParam("soHD") String soHD,@RequestParam("status") String status);

}

//@FeignClient(name="grap-service", url = "http://localhost:8080/public/personnel")
//public interface ProductService {
//	 @GetMapping(value = "/get-invoice-bysohd",produces = MediaType.APPLICATION_JSON_VALUE)
//	  InvoiceDTO getBySoHD(@RequestParam("mahd") String mahd);
//
//}