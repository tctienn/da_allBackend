package ql.vn.qlsp.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "")
@Data
public class ListInvoiceGrapEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "id_invoice")
    private Integer idInvoice;
    @Column(name = "id_grap")
    private Integer idGrap;
    private String comment;
    @Column(name = "time_get")
    private Date time_get;
    @Column(name = "time_done")
    private Date time_done;
    @Column(name = "image_access")
    private String imageAccess;
    @Column(name = "price_for_grap")
    private Double priceForGrap;

}
