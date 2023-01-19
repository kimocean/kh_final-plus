package com.meaningfarm.mall.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.meaningfarm.mall.file.File;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@SequenceGenerator(
	name="SEQ_PRODUCT_CODE",
	sequenceName = "SEQ_PRODUCT_CODE",
	initialValue=1, allocationSize=1
)
@Entity
@Data
@Table(name = "product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_CODE")
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
	
//	@ManyToOne
//	@JoinColumn(name = "category_local_code")
	@Column(name = "category_local_code")
	private Integer categoryLocalCode;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<File> files = new ArrayList<>();
	
	
}
