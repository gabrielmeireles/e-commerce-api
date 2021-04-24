package com.example.ecommerceapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private String productId;
	private String productName;
	private Double productOriginalPrice;
//	private Double discountPercentage;
//	private String productCategory;
}
