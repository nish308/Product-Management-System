package com.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pms.configuration.Config;
import com.pms.dto.Product;

public class ProductDao {
	
	Config config = new Config();
	Connection connection = null;
	
	//To insert the data
	public Product saveProduct(Product product) {
		connection = config.getConnection();
		String sql = "insert into product values (?,?,?)";
		
		try {
			//create statement
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//passed the values to placeholder
			preparedStatement.setInt(1, product.getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			
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
		return product;
	}
	
	//To Delete the product
	public boolean deleteProduct(int id) {
		connection = config.getConnection();
		int i = 0;
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
			
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
	public boolean updateProduct(String name, int price, int id) {
		connection = config.getConnection();
		
		try {
		  PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?, price = ? where id = ?");
		  
		  preparedStatement.setString(1, name);
		  preparedStatement.setInt(2, price);
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
	public boolean getProduct(int id) {
		connection = config.getConnection();
		
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement("select * from product where id = ?");
			
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();	
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
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
