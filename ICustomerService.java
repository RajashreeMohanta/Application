package com.salonservice.service;

import java.util.List;

import com.salonservice.entity.Customer;
import com.salonservice.entity.CustomerDTO;
import com.salonservice.exception.CustomerNotFoundException;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	
	
	public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException;
	public List<Customer> showAllCustomers();
	public Customer updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException;
	public boolean deleteCustomerById(Integer customerId);
	
}
