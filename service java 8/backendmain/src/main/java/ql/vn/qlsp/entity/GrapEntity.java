package ql.vn.qlsp.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Grapuser")
@Data
public class GrapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String name;
    private String sdt;
    private String address;
    private String gender;
    private Date birth;
    private String scccd;
    @Column(name = "image_cccd")
    private String imageCCCCD;
    @Column(name = "image_cccd_face")
    private String imageCCCDFace;
    @Column(name = "image_face")
    private String imageFace;
    private String status;
    @Column(name = "step_price")
    private Float stepPrice;
    private String notice;

    public GrapEntity(Integer id, String name, String sdt, String address, String gender, Date birth, String scccd, String imageCCCCD, String imageCCCDFace, String imageFace, String status, Float stepPrice, String notice) {
        this.id = id;
        this.name = name;
        this.sdt = sdt;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
        this.scccd = scccd;
        this.imageCCCCD = imageCCCCD;
        this.imageCCCDFace = imageCCCDFace;
        this.imageFace = imageFace;
        this.status = status;
        this.stepPrice = stepPrice;
        this.notice = notice;
    }

    public GrapEntity() {
    }
}
