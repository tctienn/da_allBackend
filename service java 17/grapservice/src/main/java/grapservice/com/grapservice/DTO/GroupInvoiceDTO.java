package grapservice.com.grapservice.DTO;

public class GroupInvoiceDTO {
	 private Long idGrap;
	    private Long totalInvoices;
	    private Double totalAmount;
	    private String statuses;
	    private String invoiceDetails;
		public GroupInvoiceDTO(Long idGrap, Long totalInvoices, Double totalAmount, String statuses,
				String invoiceDetails) {
			super();
			this.idGrap = idGrap;
			this.totalInvoices = totalInvoices;
			this.totalAmount = totalAmount;
			this.statuses = statuses;
			this.invoiceDetails = invoiceDetails;
		}
		public GroupInvoiceDTO() {
			super();
		}
		public Long getIdGrap() {
			return idGrap;
		}
		public void setIdGrap(Long idGrap) {
			this.idGrap = idGrap;
		}
		public Long getTotalInvoices() {
			return totalInvoices;
		}
		public void setTotalInvoices(Long totalInvoices) {
			this.totalInvoices = totalInvoices;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public String getStatuses() {
			return statuses;
		}
		public void setStatuses(String statuses) {
			this.statuses = statuses;
		}
		public String getInvoiceDetails() {
			return invoiceDetails;
		}
		public void setInvoiceDetails(String invoiceDetails) {
			this.invoiceDetails = invoiceDetails;
		}
	    
	    
}
