package com.example.ecommerceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findAllById(Arrays.asList("11", "12")));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByCategory("shirts"));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByNameContaining("polo"));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByOriginalPriceBetween(25d, 50d));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByCategoryAndFabricOrderByOriginalPriceDesc("shirts", "wool"));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByOrderByOriginalPriceDesc());
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByColors_WhiteTrue());
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByTags_Tag("Adolescente"));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.queryPersonalizada("gola v", "shirts", "leather", "Praia"));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.queryPersonalizadaNativa(50d, 10));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findAll(getProductExample()));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findAll(getPageable()));
//		List<ProductEntity> entityList = Mapper.iterableToList(repository.findByOriginalPriceBetween(25d, 50d, getPageable()));
		
		return Mapper.mapListEntityToListDTO(entityList);
	}
	
	public ProductDTO getProductByID(Integer id) {
		Optional<ProductEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return Mapper.mapEntityToDTO(entity.get());
		}
		return null;
	}

	public void putProducts(List<ProductDTO> product) {
		List<ProductEntity> productEntityList = Mapper.mapListDTOToListEntity(product);
		repository.saveAll(productEntityList);
	}

	public long countProducts(String param) {
		return repository.count();
	}
	
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}
	
	public void updateProductNameById(Integer id) {
		repository.updateProductNameById(id, "Novo Nome do Produto");
	}
	
	private Example<ProductEntity> getProductExample() {
		ProductEntity entity = new ProductEntity();
		entity.setCategory("shirts");
		entity.setFabric("leather");
		Example<ProductEntity> example = Example.of(entity);
		
		return example;
	}
	
	private Pageable getPageable() {
//		return PageRequest.of(0, 2);
		return PageRequest.of(0, 2, Sort.by("originalPrice").descending());
	}
}
