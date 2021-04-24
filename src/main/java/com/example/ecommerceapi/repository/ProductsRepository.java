package com.example.ecommerceapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerceapi.entity.ProductEntity;

@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity, Integer>{}
