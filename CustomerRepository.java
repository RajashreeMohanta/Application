package com.salonservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salonservice.entity.Customer;

@Repository // @Component
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
