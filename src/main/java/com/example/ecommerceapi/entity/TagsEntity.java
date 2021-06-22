package com.example.ecommerceapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "TAGS")
@IdClass(TagsEntityPK.class)
public class TagsEntity {
	@Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;
	
	@Id
	@Column(name = "TAG")
    private String tag;
}
