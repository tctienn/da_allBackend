package ql.vn.qlsp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ql.vn.qlsp.dto.ManageGrapDto;
import ql.vn.qlsp.entity.BlogEntity;
import ql.vn.qlsp.service.ManagerGrapService;

@RestController
@RequestMapping("admin/personnel")
public class PersonnelController {

    @Autowired
    private ManagerGrapService managerGrapService;

    @PostMapping("update-price-list")
    public ResponseEntity<?> update(@RequestBody ManageGrapDto pramsManageGrap){


        try{
            managerGrapService.updateManageGrap(pramsManageGrap);
            return ResponseEntity.ok("cập nhật giá thành công");
        }catch (Exception ex){
            return new ResponseEntity<>( "cập nhật giá không thành công: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
