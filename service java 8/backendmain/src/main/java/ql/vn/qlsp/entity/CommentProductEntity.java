package ql.vn.qlsp.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="comment_product")
@Data
public class CommentProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "id_product")
    private int idProduct;
    @Column(name = "id_user")
    private int idUser;
    private String comment;
    @Column(name = "create_time")
    private Date createTime;

    public CommentProductEntity(Integer id, int idProduct, int idUser, String comment, Date createTime) {
        this.id = id;
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.comment = comment;
        this.createTime = createTime;
    }

    public CommentProductEntity() {
    }
}
