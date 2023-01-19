package com.meaningfarm.mall.file;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.meaningfarm.mall.product.Product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "productfile")
public class File {
	
	@Id
	@Column(name = "productfile_code")
	private Integer productfileCode;
	
	@Column(name = "productfile_name")
	private String productfileName;
	
	@Column(name = "productfile_path")
	private String productfilePath;
	
//	@Column(name = "product_code")
//	private Integer productCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code")
	private Product product;
	
	@Builder
	public File(Integer productfileCode, String productfileName, String productfilePath, Integer productCode) {
		this.productfileCode = productfileCode;
		this.productfileName = productfileName;
		this.productfilePath = productfilePath;
//		this.productCode = productCode;
	}

}
