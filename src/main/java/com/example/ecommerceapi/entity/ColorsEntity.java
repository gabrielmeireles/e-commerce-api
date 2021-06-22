package com.example.ecommerceapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "COLORS")
public class ColorsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "PRODUCT_ID")
    private Integer productId;
	
	@Column(name = "WHITE")
    private boolean white;
	
	@Column(name = "BLACK")
    private boolean black;
	
	@Column(name = "BLUE")
    private boolean blue;	
	
    @OneToOne
    @MapsId
    private ProductEntity product;
}
