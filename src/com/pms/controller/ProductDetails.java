package com.pms.controller;

import com.pms.service.ProductService;

public class ProductDetails {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		
		boolean details = productService.getProduct(1);
		
		System.out.println(details);
	}
}
