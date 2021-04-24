package com.example.ecommerceapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "PRODUTOS")
public class ProductEntity {
	@Id
	@Column(name = "ID")
	private String productId;
	
	@Column(name = "NAME")
	private String productName;
	
	@Column(name = "PRICE")
	private Double productOriginalPrice;	
}
