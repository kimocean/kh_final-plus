package com.meaningfarm.mall.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_code")
	private Integer productCode;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private String productPrice;
	
	@Column(name = "product_detail")
	private String productDetail;
	
	@Column(name = "category_type_code")
	private Integer categoryTypeCode;
	
	@Column(name = "category_local_code")
	private Integer categoryLocalCode;
	
}
