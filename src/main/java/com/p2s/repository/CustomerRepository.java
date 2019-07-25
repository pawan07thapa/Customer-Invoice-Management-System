package com.p2s.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.p2s.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
