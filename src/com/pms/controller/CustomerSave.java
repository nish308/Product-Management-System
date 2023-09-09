package com.pms.controller;

import com.pms.dto.Customer;
import com.pms.service.CustomerService;

public class CustomerSave {
	public static void main(String[] args) {
		Customer customer = new Customer();
		
		customer.setId(3);
		customer.setName("Adarsh");
		customer.setEmail("adarsh@mail.com");
		
		CustomerService customerService = new CustomerService();
		Customer cs = customerService.saveCustomer(customer);
		if(cs != null) {
			System.out.println(cs.getId() +" Added Successfully");
			System.out.println(cs.getName() +" Added Successfully");
			System.out.println(cs.getEmail() +" Added Successfully");
		}
	}
}
