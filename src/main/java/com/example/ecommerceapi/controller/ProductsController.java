package com.example.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerceapi.dto.ProductDTO;
import com.example.ecommerceapi.service.ProductsService;

@RestController
public class ProductsController {
	
	@Autowired
	ProductsService service;
	
	@GetMapping("/v1/products")
	public ResponseEntity<List<ProductDTO>> getProducts(@Nullable @RequestParam String param) {
		try {
			return new ResponseEntity<>(service.getProducts(param), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/v1/products/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable String id) {
		try {
			return new ResponseEntity<>(service.getProductByID(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/v1/products/count")
	public ResponseEntity<Long> countProducts(@Nullable @RequestParam String param) {
		try {
			return new ResponseEntity<>(service.countProducts(param), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/v1/products")
	public ResponseEntity<String> putProduct(@RequestBody List<ProductDTO> products) {
		try {
			service.putProducts(products);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}