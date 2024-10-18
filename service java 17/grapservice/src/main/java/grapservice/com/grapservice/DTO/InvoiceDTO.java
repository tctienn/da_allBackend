package grapservice.com.grapservice.DTO;

public class InvoiceDTO {

	private Integer id;
    private String magd;
    private String sohd;
    private Double tongtien;
    private String nganhang;
    private String noidung;
    private String trangthai; // trạng thái thanh toán
    private String sp;
    private String giaohang;
    private String diachi;
    private String gmail;
    private String sdt;
    private String tennguoinhan;
    private String ngaytao;
	public InvoiceDTO(Integer id, String magd, String sohd, Double tongtien, String nganhang, String noidung,
			String trangthai, String sp, String giaohang, String diachi, String gmail, String sdt, String tennguoinhan,
			String ngaytao) {
		super();
		this.id = id;
		this.magd = magd;
		this.sohd = sohd;
		this.tongtien = tongtien;
		this.nganhang = nganhang;
		this.noidung = noidung;
		this.trangthai = trangthai;
		this.sp = sp;
		this.giaohang = giaohang;
		this.diachi = diachi;
		this.gmail = gmail;
		this.sdt = sdt;
		this.tennguoinhan = tennguoinhan;
		this.ngaytao = ngaytao;
	}
	public InvoiceDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMagd() {
		return magd;
	}
	public void setMagd(String magd) {
		this.magd = magd;
	}
	public String getSohd() {
		return sohd;
	}
	public void setSohd(String sohd) {
		this.sohd = sohd;
	}
	public Double getTongtien() {
		return tongtien;
	}
	public void setTongtien(Double tongtien) {
		this.tongtien = tongtien;
	}
	public String getNganhang() {
		return nganhang;
	}
	public void setNganhang(String nganhang) {
		this.nganhang = nganhang;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getSp() {
		return sp;
	}
	public void setSp(String sp) {
		this.sp = sp;
	}
	public String getGiaohang() {
		return giaohang;
	}
	public void setGiaohang(String giaohang) {
		this.giaohang = giaohang;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTennguoinhan() {
		return tennguoinhan;
	}
	public void setTennguoinhan(String tennguoinhan) {
		this.tennguoinhan = tennguoinhan;
	}
	public String getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}
    
    
	
}
