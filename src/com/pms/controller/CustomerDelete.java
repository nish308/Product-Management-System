package com.pms.controller;

import com.pms.service.CustomerService;


public class CustomerDelete {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		boolean res = customerService.deleteCustomer(3);
		
		System.out.println(res);
	}
}
