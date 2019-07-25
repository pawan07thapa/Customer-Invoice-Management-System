/**
 * 
 */
package com.p2s.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.p2s.model.Invoice;

/**
 * @author pawanthapa
 *
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	public List<Invoice> findByCustomerId(int customerId);

	public Invoice findByCustomerIdAndStatusIn(Integer customerId, List<String> status);

	/**
	 * Queriers mein column names will come that are mentioned in the tabe and not in file
	 * @return
	 */
	@Query(value="SELECT DISTINCT customer_id FROM cmis.invoice;",nativeQuery=true)
	public List<Integer> findDistictCustomers();
}
