/**
 * 
 */
package com.pawan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pawan.model.Payment;

/**
 * @author pawanthapa
 *
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	
}
