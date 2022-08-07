package com.logistiqal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistiqal.LogistiqalCompanyApplication;
import com.logistiqal.model.Product;
import com.logistiqal.repository.ProductRepository;
import com.logistiqal.service.ProductService;
import com.logistiqal.vo.NumberVO;
import com.logistiqal.vo.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger log = LoggerFactory.getLogger(LogistiqalCompanyApplication.class); 
	
	@Autowired
	ProductRepository dao;
	
	com.logistiqal.vo.ProductVO response;
	
	
	@Override
	@Transactional(readOnly = true)
	public ProductVO getAllProducts() {
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "102");
		try {
			response.setProductList((List<Product>) dao.findAll());
			response.setMessage(String.format("%d results found", response.getProductList().size()));
			response.setStatusCode("0");
		} catch (Exception e) {
			log.trace("ProductService: getAllProduct error", e);
		}
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductVO findByNameAndPassword(String name, String password) {
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "101");
		
		try {
			
			List<Product> listOfProducts = dao.findByNombreAndClave(name, password);
			if (listOfProducts.size() > 0) {
				response.setProductList(listOfProducts);
				response.setMessage("Product found successfully");
				response.setStatusCode("0");
			} else {
				response.setMessage("Product Not Found");
			}
		} catch (Exception e) {
			log.trace("ProductService: findByNameAndPassword error", e);
		}

		return response;
	}

	@Override
	@Transactional
	public ProductVO add(Product product) {
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "104");
		
		try {
			dao.save(product);
			response.setMessage(String.format("Product %s has been saved successfully", product.getName()));
			response.setStatusCode("0");
		} catch (Exception e) {
			log.trace("ProductService: add error", e);
		}
		return response;
	}

	@Override
	@Transactional
	public ProductVO update(Product product) {
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "105");
		
		try {
			dao.save(product);
			response.setMessage(String.format("Product %s has been updated successfully", product.getName()));
			response.setStatusCode("0");
		} catch (Exception e) {
			log.trace("ProductService: update error", e);
		}
		return response;
	}

	@Override
	@Transactional
	public ProductVO delete(Product product) {
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "106");
		
		try {
			dao.delete(product);
			response.setMessage(String.format("Product %s has been deleted successfully", product.getName()));
			response.setStatusCode("0");
		} catch (Exception e) {
			log.trace("ProductService: delete error", e);
		}
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductVO findById(Integer id) {
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "106");
		
		try {
			Product productToFind = dao.findById(id).get();
			response.getProductList().add(productToFind);
			response.setMessage("Product has been found successfully");
			response.setStatusCode("0");
		} catch (Exception e) {
			log.trace("ProductService: findById error", e);
		}
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductVO getPage(Integer page, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public NumberVO getPageCount(long recordsPerPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
