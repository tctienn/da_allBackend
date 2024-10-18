package ql.vn.qlsp.repository.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="notificaton", url = "http://localhost:8083")
public interface NotificationService {
    @GetMapping(value = "/notification/getall-notifiaction")
    Object getAllUserByStatus(Pageable pageable);
}
