package com.meaningfarm.mall.file;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

	private FileRepository fileRepository;
	private FileStore fileStore;
	
	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}
	
	@Transactional
	public Integer saveFile(FileDTO fileDTO) {
		return fileRepository.save(fileDTO.toEntity()).getProductfileCode();
	}
	
	@Transactional
	public FileDTO getFile(Integer productfileCode) {
		File file = fileRepository.findById(productfileCode).get();
		
		FileDTO fileDTO = FileDTO.builder()
						  .productfileCode(productfileCode)
						  .productfileName(file.getProductfileName())
						  .productfilePath(file.getProductfilePath())
//						  .productCode(file.getProductCode())
						  .build();
		return fileDTO;
	}
	
	public List<File> saveFiles(List<MultipartFile> multipartFileList) {
//		List<File> files = fileStore.storeFiles(multipartFileList);
//		List
		return null;
	}
}
