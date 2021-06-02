package com.example.ecommerceapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class ProductEntity {
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PRICE")
	private Double originalPrice;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "COLOR")
	private String color;
	
	@OneToOne
	private DiscountEntity discount;
}
