package com.meaningfarm.mall.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.meaningfarm.mall.board.Board;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findOneByProductCode(Integer productCode);
	
	Page<Product> findByProductNameContaining(String searchKeyword, Pageable pageable);
	
	@Transactional
	Product deleteByProductCode(Integer productCode);
	
}
