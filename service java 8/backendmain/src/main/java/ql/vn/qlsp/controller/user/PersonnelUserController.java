package ql.vn.qlsp.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ql.vn.qlsp.entity.InvoiceEntity;
import ql.vn.qlsp.entity.ManageGrapEntity;
import ql.vn.qlsp.repository.httpClient.GrapServiceHTTP;
import ql.vn.qlsp.service.InvoiceService;
import ql.vn.qlsp.service.ManagerGrapService;

@RestController
@RequestMapping("public/personnel")
public class PersonnelUserController {

    @Autowired
    private ManagerGrapService managerGrapService;
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("get-picelist-grapmanage")
    public ManageGrapEntity getpriceGrapmanage(){
        return managerGrapService.getManageGrap();

    }

//   v1 lấy hóa đơn đang chờ giao hàng trạng thái giao là wait (chưa được tạo đơn giao )
        @GetMapping("get-invoice-bysohd")
        public InvoiceEntity getInvoiceWaitBySoHD(@RequestParam String mahd){
            return invoiceService.getInvoiceBySoHD(mahd);
        }

//   v2 cái này lấy chi tết hóa đơn theo số hóa đơn
    @GetMapping("get-invoice-bysohdv2")
    public InvoiceEntity getInvoiceBySoHDv2(@RequestParam String soHD  ){
        return invoiceService.getInvoiceBySoHDs(soHD);
    }

    @PostMapping("update-invoice-product")
    public  void updateStatusInvoid(@RequestParam String soHD, @RequestParam String status){
        invoiceService.updateStatusInvoice(soHD,status);
    }

    @Autowired
    private GrapServiceHTTP grapServiceHTTP;
    @GetMapping("get-usergrap-bystatus")
    public ResponseEntity<?> getAllUserGrapByStatus(@RequestParam String status , Pageable pageable){

        try {
            return ResponseEntity.ok(grapServiceHTTP.getAllUserByStatus(status,pageable));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("lỗi lấy dánh sách uẻ grap "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("update-status-byidGrap")
    public ResponseEntity<?> updateStatusByIdGrap(@RequestParam Integer idGrap, @RequestParam String status){

        try {
            return ResponseEntity.ok(grapServiceHTTP.updateStatusGrapUser(idGrap,status));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("lỗi cập nhật trạng thái tài khoản nhân viên "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("group-invoice-by-user-month")
    public ResponseEntity<?> groupInvoiceByUserMonth(){

        try {
            return ResponseEntity.ok(grapServiceHTTP.groupInvoiceByUserGrapMonth() );
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("lLấy dữ liệu group-invoice-by-user-month không thành công "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("get-invoiceGrap-by-idGrap-andStatus")
    public ResponseEntity<?> getinvoiceGrapByIdGrapAndStatus(@RequestParam Integer idGrap , @RequestParam String status){

        try {
            return ResponseEntity.ok(grapServiceHTTP.getInvoiceGrapBystatusAndIdGrap(idGrap,status) );
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("lLấy dữ liệu getInvoiceGrapBystatusAndIdGrap không thành công "+ e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

//    @Autowired
//    private InvoiceRepository invoiceRepository;
//    @GetMapping("invoice/findter-name/{sohd}")
//    public InvoiceEntity getInvoiceByName(@PathVariable("sohd") String sohd ){
//        return invoiceRepository.findBySohd(sohd);
//    }

}
