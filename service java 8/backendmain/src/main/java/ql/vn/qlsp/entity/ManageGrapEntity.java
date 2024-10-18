package ql.vn.qlsp.entity;

import lombok.Data;
import ql.vn.qlsp.dto.ManageGrapDto;

import javax.persistence.*;

@Entity
@Table(name = "manage_grap")
@Data
public class ManageGrapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "price_base")
    private Double priceBase;

    @Column(name = "price_on_km")
    private Double priceOnKM;

    public ManageGrapEntity(Integer id, Double priceBase, Double priceOnKM) {
        this.id = id;
        this.priceBase = priceBase;
        this.priceOnKM = priceOnKM;
    }

    public ManageGrapEntity(ManageGrapDto manageGrapDto){
        this.priceBase = manageGrapDto.getPriceBase();
        this.priceOnKM = manageGrapDto.getPriceOnKM();
    }

    public ManageGrapEntity() {
    }
}
