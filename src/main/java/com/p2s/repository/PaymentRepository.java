/**
 * 
 */
package com.p2s.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2s.model.Payment;

/**
 * @author pawanthapa
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	
}
