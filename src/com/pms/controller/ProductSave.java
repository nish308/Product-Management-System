package com.pms.controller;

import com.pms.dto.Product;
import com.pms.service.ProductService;

public class ProductSave {
	public static void main(String[] args) {
		Product product = new Product();
		
		product.setId(3);
		product.setName("Charger");
		product.setPrice(1899);
		
		ProductService productService = new ProductService();
		Product p = productService.saveProduct(product);
		if(p != null) {
			System.out.println(p.getId() +" Added Successfully");
			System.out.println(p.getName() +" Added Successfully");
			System.out.println(p.getPrice() +" Added Successfully");
		}
	}
}
