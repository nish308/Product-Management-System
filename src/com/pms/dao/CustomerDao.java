package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pms.configuration.Config;
import com.pms.dto.Customer;


public class CustomerDao {
	Config config = new Config();
	Connection connection = null;
	
	public Customer saveCustomer(Customer customer) {
		connection = config.getConnection();
		String sql = "insert into customer values (?,?,?)";
		
		try {
			//create statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//passed the values to placeholder
			preparedStatement.setInt(1, customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getEmail());
			
			//execute statement
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customer;
	}
	
	//To Delete the product
	public boolean deleteCustomer(int id) {
		connection = config.getConnection();
		int i = 0;
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from customer where id = ?");
			
			preparedStatement.setInt(1, id);
			
			i = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//To update the product
	public boolean updateCustomer(String name, String email, int id) {
		connection = config.getConnection();
		
		try {
		  PreparedStatement preparedStatement = connection.prepareStatement("update customer set name = ?, email = ? where id = ?");
		  
		  preparedStatement.setString(1, name);
		  preparedStatement.setString(2, email);
		  preparedStatement.setInt(3, id);
		  
		  preparedStatement.executeUpdate();
		  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	//To get data by Id
	public boolean getCustomer(int id) {
		connection = config.getConnection();
		
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement("select * from customer where id = ?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();	
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("=====================");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}
