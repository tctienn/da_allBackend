package grapservice.com.grapservice.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import grapservice.com.grapservice.DTO.GroupInvoiceDTO;
import grapservice.com.grapservice.entity.ListInvoiceGrapEntity;
import java.util.List;
import java.util.Optional;


public interface ListInvoiceGrapRepository extends JpaRepository<ListInvoiceGrapEntity, Integer> {
	
	Page<ListInvoiceGrapEntity> findAllByStatus( String status,Pageable page);
	Optional<ListInvoiceGrapEntity> findBySohd(String sohd);
	Optional<ListInvoiceGrapEntity> findBySohdAndIdGrap(String sohd,Integer idGrap);
	
	
//	lấy đơn hàng đang giao trong tháng hiện tại
	@Query(value = "SELECT *\r\n"
			+ "FROM list_invoice_grap\r\n"
			+ "WHERE MONTH(time_get) = MONTH(CURRENT_DATE()) \r\n"
			+ "AND YEAR(time_get) = YEAR(CURRENT_DATE()) \r\n"
			+ "AND id_grap = :idGrap AND status = :status", nativeQuery = true)
	List<ListInvoiceGrapEntity> getOderGrapOnMonthByIdGrapAndByStatus(@Param("idGrap") int idGrap, @Param("status") String status);
	
//	lấy đơn hàng với trạng thái và idgrap không giới hạn thời gian
	@Query(value = "SELECT *\r\n"
			+ "FROM list_invoice_grap\r\n"
			+ "WHERE  id_grap = :idGrap AND status = :status", nativeQuery = true)
	List<ListInvoiceGrapEntity> getOderGrapByIdGrapAndByStatus(@Param("idGrap") int idGrap, @Param("status") String status);
	
	// lấy chi tiết đơn hàng theo user
	ListInvoiceGrapEntity findBySohdAndIdGrap(String soHD, int idGrap);
	
	// lấy danh sách hóa đơn được nhoms theo idGrapuser và tôngr lương từng nhân viên để xuất file excel
	@Query(value = "SELECT id_grap, \r\n"
			+ "       COUNT(*) AS total_invoices, \r\n"
			+ "       SUM(price_for_grap) AS total_amount,\r\n"
			+ "       GROUP_CONCAT(DISTINCT status) AS statuses,\r\n"
			+ "       GROUP_CONCAT(CONCAT('SOHD: ', sohd, ' - Price: ', price_for_grap, ' - Status: ', status)) AS invoice_details\r\n"
			+ "FROM list_invoice_grap\r\n"
			+ "WHERE status = 'success'\r\n"
			+ "GROUP BY id_grap;\r\n"
			+ "", nativeQuery = true)
	List<Object> groupInvoiceByUserForExcelMonth();
	
	
}
