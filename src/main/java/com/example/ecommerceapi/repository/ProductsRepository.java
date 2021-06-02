package com.example.ecommerceapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceapi.entity.ProductEntity;

@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity, String> {
	public List<ProductEntity> findByCategory(String category);
	public List<ProductEntity> findByOrderByOriginalPriceDesc();
	public List<ProductEntity> findByCategoryAndColorOrderByOriginalPriceDesc(String category, String color);
}
