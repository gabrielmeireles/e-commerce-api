package com.example.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceapi.dto.ProductDTO;
import com.example.ecommerceapi.service.ProductsService;

@RestController
public class ProductsController {
	
	@Autowired
	ProductsService service;
	
	@GetMapping("/v1/products")
	public ResponseEntity<List<ProductDTO>> getProducts() {
		try {
			return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/v1/products")
	public ResponseEntity<String> putProduct(@RequestBody ProductDTO product) {
		try {
			service.putProduct(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
