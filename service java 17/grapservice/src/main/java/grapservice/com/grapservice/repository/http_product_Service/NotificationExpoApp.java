package grapservice.com.grapservice.repository.http_product_Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import grapservice.com.grapservice.DTO.InvoiceDTO;
import grapservice.com.grapservice.DTO.NotificationExpoDTO;

@FeignClient(name="expoapp", url = "https://exp.host/--/api/v2/push/send")
public interface NotificationExpoApp {
	@PostMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE)
	  InvoiceDTO sendNotificationExpoApp(@RequestBody NotificationExpoDTO notificationExpoDTO );

}
