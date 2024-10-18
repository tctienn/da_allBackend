package ql.vn.qlsp.controller.fontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import ql.vn.event.dto.NotificationDTO;
import ql.vn.qlsp.entity.InvoiceEntity;
import ql.vn.qlsp.entity.ManageGrapEntity;
import ql.vn.qlsp.repository.InvoiceRepository;
import ql.vn.qlsp.repository.httpClient.NotificationService;
import ql.vn.qlsp.service.ManagerGrapService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("public/ManageGrap")
public class ManageGrap {

    @Autowired
    private ManagerGrapService managerGrapService;

    @GetMapping("get-detail")
    public ManageGrapEntity getDetail(){
        return managerGrapService.getManageGrap();
    }

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("invoice/get-invoice-wait")
    public List<InvoiceEntity> getInvoiceWait(){
        return invoiceRepository.getInvoiceWaits();
    }

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;
    @PostMapping("notidfication-create")
    public void createNotification(@RequestBody NotificationDTO notificationDTO){
        kafkaTemplate.send("notifiacion", notificationDTO);
    }
    @PostMapping("notidfication-delete")
    public void deleteNotifiacation(@RequestBody NotificationDTO notificationDTO){ // chỉ cần giá trị id
        kafkaTemplate.send("deleteNotification", notificationDTO);
    }

    @Autowired
    private NotificationService notificationService;

    @GetMapping("get-notifications")
    public Object getAllNotifiacations(Pageable pageable){
        return  notificationService.getAllUserByStatus(pageable);
    }


}
