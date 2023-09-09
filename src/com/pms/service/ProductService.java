package com.pms.service;

import com.pms.dao.ProductDao;
import com.pms.dto.Product;

public class ProductService {
	ProductDao productDao = new ProductDao();
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}
	
	public boolean updateProduct(String name, int price, int id) {
		return productDao.updateProduct(name, price, id);
	}
	
	public boolean getProduct(int id) {
		return productDao.getProduct(id);
	}
}
