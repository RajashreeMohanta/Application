package com.salonservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.salonservice.dao.CustomerRepository;
import com.salonservice.entity.Customer;
import com.salonservice.entity.CustomerDTO;
import com.salonservice.exception.CustomerNotFoundException;
/************************************************************************************
 *          @author          Rajashree Mohanta
 *          Description      It is a customer class that provides the informations/datas for adding a new appointment,order,payment,card,services 
                                    and viewing all the information/data  
  *         Version             1.0
  *         Created Date    18-JUNE-2022
 ************************************************************************************/


@Service // @Component
	public class ICustomerServiceImpl implements ICustomerService {

		
		@Autowired
		private CustomerRepository customerRepo;
		
		/************************************************************************************
		 * Method: addCustomer
	                *Description: To adding the data 
		 * @param id       - Customer’s ID
		 * @param name                       - Customer's Name to be added
		 * @returns Boolean                  - true, if added otherwise throws CustomerNotFoundException
		 * @throws CustomerNotFoundException - It is raised due to insufficient data or invalid customer Id or customer side validation 
	                                                                       
	                *Created By                                - Rajashree Mohanta
	                *Created Date                            - 18-JUNE-2022                           
		 
		 ************************************************************************************/

		
		@Override
		public Customer addCustomer(Customer newCustomer) {
			return this.customerRepo.save(newCustomer);
		}
		
		/************************************************************************************
		 * Method: updateCustomer
	                *Description: To updating the data 
		 * @param id       - Customer’s ID
		 * @param name                       - Customer's Name to be updated
		 * @returns Boolean                  - true, if updated otherwise throws CustomerNotFoundException
		 * @throws CustomerNotFoundException - It is raised due to insufficient data or invalid customer Id or customer side validation 
	                                                                       
	                *Created By                                - Rajashree Mohanta
	                *Created Date                            - 18-JUNE-2022                                  
		 
		 ************************************************************************************/


		@Override
		public Customer updateCustomer(CustomerDTO customerDTO) throws CustomerNotFoundException {
			
			Optional<Customer> customerOpt = this.customerRepo.findById(customerDTO.getId());
			if(customerOpt.isEmpty())
				throw new CustomerNotFoundException("Customer id does not exist to update.");
			
			Customer updateCustomer = customerOpt.get();
			updateCustomer.setName(customerDTO.getName());
			updateCustomer.setEmail(customerDTO.getEmail());
			updateCustomer.setContactNo(customerDTO.getContactNo());
			updateCustomer.setPassword(customerDTO.getPassword());
			updateCustomer.setDob(customerDTO.getDob());
			
			
			return this.customerRepo.save(updateCustomer);
		}

		/************************************************************************************
		 * Method: displayCustomer/getCustomer
	                *Description: To displaying/getting the data 
		 * @param id       - Customer’s ID
		 * @param name                       - Customer's Name to be displaying/getting
		 * @returns Boolean                  - true, if displaying/getting otherwise throws CustomerNotFoundException
		 * @throws CustomerNotFoundException - It is raised due to insufficient data or invalid customer Id or customer side validation 
	                                                                       
	                *Created By                                - Rajashree Mohanta
	                *Created Date                            - 18-JUNE-2022                             
		 
		 ************************************************************************************/


		@Override
		public List<Customer> showAllCustomers() {
			
			return this.customerRepo.findAll();
		}

		@Override
		public Customer getCustomerById(Integer customerId) throws CustomerNotFoundException {
			Optional<Customer> customerOpt = this.customerRepo.findById(customerId);
			if(customerOpt.isEmpty())
				throw new CustomerNotFoundException("Customer Not Found");
			
			return customerOpt.get();
			
		}

		@Override
		public List<Customer> getAllCustomers() {
			return this.customerRepo.findAll();
		}
		
		/************************************************************************************
		 * Method: deleteCustomer
	                *Description: To deleting the data 
		 * @param id       - Customer’s ID
		 * @param name                       - Customer's Name to be deleting
		 * @returns Boolean                  - true, if deleting otherwise throws CustomerNotFoundException
		 * @throws CustomerNotFoundException - It is raised due to insufficient data or invalid customer Id or customer side validation 
	                                                                       
	                *Created By                                - Rajashree Mohanta
	                *Created Date                            - 18-JUNE-2022 
		 ************************************************************************************/


		@Override
		public boolean deleteCustomerById(Integer customerId) {
			this.customerRepo.deleteById(customerId);
			return true;
		}
		
}

	