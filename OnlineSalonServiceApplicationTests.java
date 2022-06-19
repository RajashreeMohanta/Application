package com.salonservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.salonservice.entity.Customer;
import com.salonservice.entity.CustomerDTO;
import com.salonservice.exception.CustomerNotFoundException;
import com.salonservice.service.ICustomerService;

@SpringBootTest
class OnlineSalonServiceApplicationTests {
	
	@Autowired
	private ICustomerService iCustomerService;
		
		@Test
		void addCustomerTest() {
			Customer customer = new Customer(105, "Capgi", "123", "88888", "test@gmail.com", null, null, null, null);
			Customer testCustomer = this.iCustomerService.addCustomer(customer);
			assertNotNull(testCustomer);// it should return newly added customer object
			// remove test data
		}

		@Test
		void updateCustomerTest() {
			CustomerDTO customerDTO = new CustomerDTO(105, "TestName", null, "8888", "test@gmail.com", null);

			assertThrows(CustomerNotFoundException.class, () -> this.iCustomerService.updateCustomer(customerDTO));

		}

		@Test
		void updateCustomerTest2() {
			// Customer customer = new Customer(24, "Capgi", "123", 8888L, "test@gmail.com",
			// null, null);
			// Customer testCustomer = this.iCustomerService.addCustomer(customer);

			CustomerDTO customerDTO = new CustomerDTO(24, "TestName", null, "8888", "test@gmail.com", null);

			try {
				Customer updatedCustomer = this.iCustomerService.updateCustomer(customerDTO);

				assertEquals("TestName", updatedCustomer.getName());
			} catch (CustomerNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
