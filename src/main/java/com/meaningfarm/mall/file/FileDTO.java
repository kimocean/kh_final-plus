package com.meaningfarm.mall.file;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDTO {

	private Integer productfileCode;
	private String productfileName;
	private String productfilePath;
	private Integer productCode;
	
	public File toEntity() {
		File build = File.builder()
					.productfileCode(productfileCode)
					.productfileName(productfileName)
					.productfilePath(productfilePath)
					.productCode(productCode)
					.build();
		return build;
	}
	
	@Builder
	public FileDTO(Integer productfileCode, String productfileName, String productfilePath, Integer productCode) {
		this.productfileCode = productfileCode;
		this.productfileName = productfileName;
		this.productfilePath = productfilePath;
		this.productCode = productCode;
	}
	
}
