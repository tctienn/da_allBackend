package grapservice.com.grapservice.entity;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grapuser")
public class GrapUserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;
    
    private String name;
    private String sdt;
    private String address;
    private String gender;
    private Date birth;
    private String scccd;
    private String password;
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
	private String gmail;
	public GrapUserEntity(Integer id, String name, String sdt, String address, String gender, Date birth, String scccd,
			String password, String imageCCCCD, String imageCCCDFace, String imageFace, String status, Float stepPrice,
			String notice, String gmail) {
		super();
		this.id = id;
		this.name = name;
		this.sdt = sdt;
		this.address = address;
		this.gender = gender;
		this.birth = birth;
		this.scccd = scccd;
		this.password = password;
		this.imageCCCCD = imageCCCCD;
		this.imageCCCDFace = imageCCCDFace;
		this.imageFace = imageFace;
		this.status = status;
		this.stepPrice = stepPrice;
		this.notice = notice;
		this.gmail = gmail;
	}
	public GrapUserEntity() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getScccd() {
		return scccd;
	}
	public void setScccd(String scccd) {
		this.scccd = scccd;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageCCCCD() {
		return imageCCCCD;
	}
	public void setImageCCCCD(String imageCCCCD) {
		this.imageCCCCD = imageCCCCD;
	}
	public String getImageCCCDFace() {
		return imageCCCDFace;
	}
	public void setImageCCCDFace(String imageCCCDFace) {
		this.imageCCCDFace = imageCCCDFace;
	}
	public String getImageFace() {
		return imageFace;
	}
	public void setImageFace(String imageFace) {
		this.imageFace = imageFace;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getStepPrice() {
		return stepPrice;
	}
	public void setStepPrice(Float stepPrice) {
		this.stepPrice = stepPrice;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
    

    
    
    
    

}
