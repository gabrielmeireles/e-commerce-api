package com.example.ecommerceapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerceapi.dto.ProductDTO;
import com.example.ecommerceapi.entity.ProductEntity;
import com.example.ecommerceapi.repository.ProductsRepository;
import com.example.ecommerceapi.util.Mapper;

@Service
public class ProductsService {

	@Autowired
	ProductsRepository repository;

	public List<ProductDTO> getProducts() {
		List<ProductEntity> entityList = Mapper.iterableToList(repository.findAll());
		return Mapper.mapList(entityList, ProductDTO.class);
	}

	public void putProduct(ProductDTO product) {
		ProductEntity productEntity = Mapper.map(product, ProductEntity.class);
		repository.save(productEntity);
	}
}
