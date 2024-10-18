package ql.vn.qlsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // kích hoạt tính năng lập lịch chạy các hàm định kỳ
@EnableFeignClients
public class QlspApplication {

    public static void main(String[] args) {
        SpringApplication.run(QlspApplication.class, args);
    }

}
