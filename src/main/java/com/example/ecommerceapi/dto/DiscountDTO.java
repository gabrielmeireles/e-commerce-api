package com.example.ecommerceapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscountDTO {
	private Double discountPercentage;
	private Long discountEndTimestamp;
}
