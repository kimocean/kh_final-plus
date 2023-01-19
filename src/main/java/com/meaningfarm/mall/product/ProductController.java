package com.meaningfarm.mall.product;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meaningfarm.mall.board.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	private final ProductRepository productRepository;
	
	@GetMapping("/productList")
	public String productList(Model model,
			@PageableDefault(page = 0, size = 10, sort = "productCode", direction = Sort.Direction.DESC) Pageable pageable,
    		String searchKeyword) {
		Page<Product> pageList = null;
    	if(searchKeyword == null) {
    		pageList = productService.productList(pageable);
    	} else {
    		pageList = productService.productSearchList(searchKeyword, pageable);
    	}
    	
    	int nowPage = pageList.getPageable().getPageNumber() + 1;
    	int startPage = Math.max(nowPage - 4, 1);
    	int endPage = Math.min(nowPage + 5, pageList.getTotalPages());
    	
//		model.addAttribute("list", productService.productList());
    	model.addAttribute("list", pageList);
    	model.addAttribute("nowPage", nowPage);
    	model.addAttribute("startPage", startPage);
    	model.addAttribute("endPage", endPage);
		return "product/productList";
	}
	
	@GetMapping("/productInsert")
	public String productInsert(HttpServletRequest request) {
		return "product/productInsert";
	}
	
	@PostMapping("/productInsert")
	public String productInsert(Product product) {
		productService.productInsert(product);
		return "redirect:/product/productList";
	}
	
	@GetMapping("/productDetail")
	public String productDetail(Model model, Integer productCode) {
		model.addAttribute("product", productService.productDetail(productCode));
		return "product/productDetail";
	}
	
	@GetMapping("/productUpdate/{productCode}")
	public String productUpdate(@PathVariable("productCode") Integer productCode, Model model) {
		model.addAttribute("product", productService.productDetail(productCode));
		return "product/productUpdate";
	}
	
	@PutMapping("/productUpdate/{productCode}")
	public String productUpdate(Product product) {
		productService.productInsert(product);
		return "redirect:/product/productList";
	}
	
	@GetMapping("/productDelete")
	public String productDelete(Integer productCode) {
		productService.productDelete(productCode);
		return "redirect:/product/productList";
	}
}
