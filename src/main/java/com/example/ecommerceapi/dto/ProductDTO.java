package com.example.ecommerceapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private String id;
	private String name;
	private Double originalPrice;
	private String category;
	private String color;
	
	private DiscountDTO discount;
}
