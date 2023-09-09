package com.pms.controller;

import com.pms.service.CustomerService;

public class CustomerUpdate {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		
		boolean s = customerService.updateCustomer("Darshan", "darshan@mail.com", 3);
		System.out.println(s);
	}
}
