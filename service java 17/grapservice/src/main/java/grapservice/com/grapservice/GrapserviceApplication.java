package grapservice.com.grapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GrapserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrapserviceApplication.class, args);
	}

}
