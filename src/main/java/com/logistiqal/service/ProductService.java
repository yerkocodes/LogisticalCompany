package com.logistiqal.service;

import com.logistiqal.model.Product;
import com.logistiqal.vo.NumberVO;
import com.logistiqal.vo.ProductVO;

public interface ProductService {
	public ProductVO getAllProducts();
	public ProductVO findByNameAndPassword(String name, String password);
	public ProductVO add(Product product);
	public ProductVO update(Product product);
	public ProductVO delete(Product product);
	public ProductVO findById(Integer id);
	public ProductVO getPage(Integer page, Integer count);
	public NumberVO getPageCount(long recordsPerPage);
}
