package ql.vn.qlsp.repository.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
@FeignClient(name="grap-service-product", url = "http://localhost:8081")
public interface GrapServiceHTTP {
    @PostMapping(value = "/grapuser/update-status-user")
    Object updateStatusGrapUser ( @RequestParam("idGrap") Integer idGrap,
                                  @RequestParam("status") String status);
    @GetMapping(value = "/grapuser/get-grapUsers-byStatus")
    Object getAllUserByStatus(@RequestParam String status , Pageable pageable);
    @GetMapping(value = "/grapuser/get-grapUsers")
    Object getAllUser();

    @GetMapping (value = "/oder-grap/get-groupInvoice-byUserGrap-month")
    List<Object> groupInvoiceByUserGrapMonth();
    @GetMapping (value = "/oder-grap/oder-filter-by-idgrap-status-month")
    List<Object> getInvoiceGrapBystatusAndIdGrap(@RequestParam Integer idGrap, @RequestParam String status);
}
