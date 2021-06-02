package com.example.ecommerceapi.service;

import java.util.List;
import java.util.Optional;

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

	public List<ProductDTO> getProducts(String param) {
		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByCategoryAndColorOrderByOriginalPriceDesc("shirts", "black"));
		return Mapper.mapList(entityList, ProductDTO.class);
	}
	
	public ProductDTO getProductByID(String id) {
		Optional<ProductEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return Mapper.map(entity.get(), ProductDTO.class);
		}
		return null;
	}

	public void putProducts(List<ProductDTO> product) {
		List<ProductEntity> productEntity = Mapper.mapList(product, ProductEntity.class);
		repository.saveAll(productEntity);
	}

	public long countProducts(String param) {
		return repository.count();
	}
}
