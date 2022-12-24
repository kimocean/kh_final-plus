package com.meaningfarm.mall.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meaningfarm.mall.board.Board;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> productList() {
		return productRepository.findAll();
	}
	
	public Page<Product> productList(Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	public Page<Product> productSearchList(String SearchKeyword, Pageable pageable) {
		return productRepository.findByProductNameContaining(SearchKeyword, pageable);
	}

	@Transactional
	public void productInsert(Product product) {
		productRepository.save(product);
	}
	
	public Product productDetail(Integer productCode) {
		return productRepository.findOneByProductCode(productCode);
	}
	
	public void productDelete(Integer productCode) {
		productRepository.deleteById(productCode);
	}
}
