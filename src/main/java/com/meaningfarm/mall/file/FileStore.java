package com.meaningfarm.mall.file;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileStore {

	@Value("${file.dir}/")
	private String fileDirPath;
	
	// 확장자 추출 메소드
	private String extractExt(String productfileName) {
		int idx = productfileName.lastIndexOf(".");
		String ext = productfileName.substring(idx);
		return ext;
	}
	
	// 저장할 파일 이름 구성
	private String createStoreFilename(String productfileName) {
		String uuid = UUID.randomUUID().toString();
		String ext = extractExt(productfileName);
		String storeFilename = uuid + ext;
		return storeFilename;
	}
	
	// 파일 경로 구성
	public String createPath(String productfileName) {
		return fileDirPath+productfileName;
	}
	
	public File storeFile(MultipartFile multipartFile) {
		if(multipartFile.isEmpty()) {
			return null;
		}
		
		String productfileName = multipartFile.getOriginalFilename();
		String storeFilename = createStoreFilename(productfileName);
//		multipartFile.transferTo(new File(createPath(productfileName)));
		
		return File.builder()
				   .productfileName(productfileName)
				   .productfilePath(storeFilename)
				   .build();
	}
	
	public List<File> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
		List<File> files = new ArrayList<>();
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				files.add(storeFile(multipartFile));
			}
		}
		return files;
	}
}
