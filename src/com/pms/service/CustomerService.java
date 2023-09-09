package com.pms.service;

import com.pms.dao.CustomerDao;
import com.pms.dto.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);			
	}
	
	public boolean deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}
	
	public boolean updateCustomer(String name, String email, int id) {
		return customerDao.updateCustomer(name, email, id);
	}
	
	public boolean getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
}
