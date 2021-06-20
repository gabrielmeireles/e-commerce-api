package com.example.ecommerceapi.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private int id;
	private String name;
	private Double originalPrice;
	private String category;
	private String fabric;
	
	private ColorDTO colors;
	private List<String> tags;
}
