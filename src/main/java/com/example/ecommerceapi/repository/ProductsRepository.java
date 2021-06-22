package com.example.ecommerceapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecommerceapi.entity.ProductEntity;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {
	public List<ProductEntity> findByCategory(String category);
	public List<ProductEntity> findByOrderByOriginalPriceDesc();
	public List<ProductEntity> findByCategoryAndFabricOrderByOriginalPriceDesc(String category, String fabric);
	public List<ProductEntity> findByNameContaining(String name);
	public List<ProductEntity> findByOriginalPriceBetween(Double minPrice, Double maxPrice);
	public List<ProductEntity> findByOriginalPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);
	public List<ProductEntity> findByColors_WhiteTrue();
	public List<ProductEntity> findByTags_Tag(String tag);
	
	
	@Query("select p from ProductEntity p "
			+ "join fetch p.tags t "
			+ " where p.name like %?1% and p.category = ?2 and p.fabric = ?3 and t.tag = ?4"
			+ " order by p.originalPrice asc")
	public List<ProductEntity> queryPersonalizada(String name, String category, String fabric, String tag);
	
	@Query(value = "select * from PRODUCT where abs(PRICE - ?1) < ?2", nativeQuery = true)
	public List<ProductEntity> queryPersonalizadaNativa(Double basePrice, int priceRange);
}
