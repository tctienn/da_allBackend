package ql.vn.qlsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ql.vn.qlsp.controller.fontend.ManageGrap;
import ql.vn.qlsp.dto.ManageGrapDto;
import ql.vn.qlsp.entity.GrapEntity;
import ql.vn.qlsp.entity.ManageGrapEntity;
import ql.vn.qlsp.repository.GrapRepository;
import ql.vn.qlsp.repository.ManageGrapRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ManagerGrapService {
    @Autowired
    ManageGrapRepository manageGrapRepository;
    @Autowired
    GrapRepository grapRepository;


    public List<GrapEntity> getGraps(){
        return grapRepository.findAll();
    }

    public GrapEntity updateStatusGrap(Integer idGrap, String status) throws Exception {

        GrapEntity grapEntity = grapRepository.findById(idGrap).orElse(null);

        if(grapEntity== null){
            throw new Exception("không tìm id nhân viên grap");
        }

        return grapEntity;

    }


    ///////// quản lý giá hóa đơn của grap
//    private ManageGrapEntity getPriceKistGrapManage(){
//         ManageGrapEntity manageGrapEntity = manageGrapRepository.findById(1).orElse(null);
//        return manageGrapEntity;
//    }
    private void createManageGrap(){
        manageGrapRepository.save(new ManageGrapEntity(1,1d,1d));
    }

    public ManageGrapEntity getManageGrap(){
        List<ManageGrapEntity> list = manageGrapRepository.findAll();
        if(list.size() == 0){
            return null;
        }
        ManageGrapEntity manageGrapEntity = list.get(0);

        return manageGrapEntity;
    }
    @Transactional
    public ManageGrapEntity updateManageGrap(ManageGrapDto manageGrapDto) throws Exception {




        ManageGrapEntity manageGrapEntity = manageGrapRepository.findById(1).orElse(null);
        if(manageGrapEntity == null){
            createManageGrap();
            throw new Exception("không tìm thấy dữ liệu của manageGrap có id  (mặc định 1)");
        }

        if(manageGrapDto.getPriceBase()<=0 || manageGrapDto.getPriceOnKM()<=0){
            throw new Exception("lỗi nhập giá không được nhỏ hơn hoặc bằng 0");
        }
        manageGrapEntity.setPriceBase(manageGrapDto.getPriceBase());
        manageGrapEntity.setPriceOnKM(manageGrapDto.getPriceOnKM());
        System.out.println("tesssssssssssssssss");
        return manageGrapEntity;
    }






}
