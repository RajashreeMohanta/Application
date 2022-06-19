package com.salonservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.salonservice.entity.Customer;
import com.salonservice.entity.CustomerDTO;
import com.salonservice.exception.CustomerNotFoundException;
import com.salonservice.service.ICustomerService;

@RestController
@RequestMapping("v1")
@CrossOrigin(value = "http://localhost:3000/")
public class CustomerController {

	@Autowired
	private ICustomerService iCustomerService;

	@PostMapping("customer")
	public Customer addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {

		Customer customer = new Customer(null, customerDTO.getName(), customerDTO.getEmail(), 
				customerDTO.getContactNo(), customerDTO.getPassword(), customerDTO.getDob(), null, null, null);
		return this.iCustomerService.addCustomer(customer);
	}

	@PutMapping("customer")
	public Customer updateCustomer(@RequestBody CustomerDTO customerDTO) throws CustomerNotFoundException {
		return this.iCustomerService.updateCustomer(customerDTO);
	}

	@DeleteMapping("customer/{customerId}")
	public boolean deleteCustomerById(@PathVariable("customerId")Integer customerId) throws CustomerNotFoundException {
		return this.iCustomerService.deleteCustomerById(customerId);
	}
	
	@GetMapping("customers")
	public List<Customer> getAllCustomers() {
		return this.iCustomerService.showAllCustomers();
	}
	
	@GetMapping("Customer/{id}")
	public Customer getCustomerById(@PathVariable("id") Integer customerId ) throws CustomerNotFoundException {
		return this.iCustomerService.getCustomerById(customerId);
	}
	

}

