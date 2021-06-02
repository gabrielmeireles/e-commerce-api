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
@Table(name = "DISCOUNT")
public class DiscountEntity {
	@Id
	@Column(name = "ID")
	private String productId;
	
	@Column(name = "DISCOUNT_PERCENTAGE")
	private Double discountPercentage;
	
	@Column(name = "END_TIMESTAMP")
	private Long discountEndTimestamp;
}
