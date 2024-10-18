package grapservice.com.grapservice.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="list_invoice_grap")
public class ListInvoiceGrapEntity {
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Id
	    private Integer id;
//	  đây là tương đương với trường sohd của invoice trong product service
	    @Column(name = "sohd")
	    private String sohd;
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
		private String status;
		public ListInvoiceGrapEntity(Integer id, String sohd, Integer idGrap, String comment, Date time_get,
				Date time_done, String imageAccess, Double priceForGrap, String status) {
			super();
			this.id = id;
			this.sohd = sohd;
			this.idGrap = idGrap;
			this.comment = comment;
			this.time_get = time_get;
			this.time_done = time_done;
			this.imageAccess = imageAccess;
			this.priceForGrap = priceForGrap;
			this.status = status;
		}
		public ListInvoiceGrapEntity() {
			super();
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getSohd() {
			return sohd;
		}
		public void setSohd(String sohd) {
			this.sohd = sohd;
		}
		public Integer getIdGrap() {
			return idGrap;
		}
		public void setIdGrap(Integer idGrap) {
			this.idGrap = idGrap;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public Date getTime_get() {
			return time_get;
		}
		public void setTime_get(Date time_get) {
			this.time_get = time_get;
		}
		public Date getTime_done() {
			return time_done;
		}
		public void setTime_done(Date time_done) {
			this.time_done = time_done;
		}
		public String getImageAccess() {
			return imageAccess;
		}
		public void setImageAccess(String imageAccess) {
			this.imageAccess = imageAccess;
		}
		public Double getPriceForGrap() {
			return priceForGrap;
		}
		public void setPriceForGrap(Double priceForGrap) {
			this.priceForGrap = priceForGrap;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	    
		
	    
}
