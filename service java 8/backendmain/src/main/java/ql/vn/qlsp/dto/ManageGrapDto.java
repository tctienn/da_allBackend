package ql.vn.qlsp.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class ManageGrapDto {
    private Integer id;
    private Double priceBase;
    private Double priceOnKM;

    public ManageGrapDto(Integer id, Double priceBase, Double priceOnKM) {
        this.id = id;
        this.priceBase = priceBase;
        this.priceOnKM = priceOnKM;
    }

    public ManageGrapDto() {
    }
}
