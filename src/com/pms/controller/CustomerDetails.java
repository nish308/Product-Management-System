package com.pms.controller;

import com.pms.service.CustomerService;

public class CustomerDetails {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		
		boolean details = customerService.getCustomer(2);
		
		
		System.out.println(details);
	}
}
