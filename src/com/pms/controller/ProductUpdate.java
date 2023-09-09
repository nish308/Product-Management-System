package com.pms.controller;

import com.pms.service.ProductService;

public class ProductUpdate {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		
		boolean s = productService.updateProduct("Cable", 500, 3);
		System.out.println(s);
	}
}
