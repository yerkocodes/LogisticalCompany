package com.logistiqal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
//			Product productToFind = dao.findById(id).get();
			Product productToFind = dao.findByID(id);
			System.out.println("productTofind");
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
		response = new ProductVO(new ArrayList<Product>(), "An error as ocurred", "108");
		
		try {
			Pageable pageable = PageRequest.of(page, count);
			Page<Product> responsePage = dao.findAll(pageable);
			response.setProductList(responsePage.getContent());;
			response.setMessage(String.format("%d results found", response.getProductList().size()));
			response.setStatusCode("0");
			
		} catch (Exception e) {
			log.error("ProductService: getPage() error", e);
		}

		return response;
	}

	/*
	 * Ahora, crearemos otro método para obtener el total de páginas que se crearían
	 * al tener una cantidad determinada de registros por página. Por ejemplo, si
	 * tuviésemos 50 registros en la tabla y quisiéramos páginas de 5 registros,
	 * obtendremos 10 páginas a través de este método
	 */	
	@Override
	@Transactional(readOnly = true)
	public NumberVO getPageCount(long registersPerPage) {
		NumberVO response = new NumberVO((long) 0, "An error as ocurred", "109");
		
		try {
			long registers = dao.count();
			if (registersPerPage == 0 && registers == 0) {
				response.setValue((long) 1);
			} else {
//				Adicional a esto, si la cantidad de registros de la tabla no es un múltiplo de la cantidad de
//				registros, utilizaremos (registros % registrosPorPagina == 0 ? 0 : 1) para obtener una página
//				final incompleta y así mostraremos todos los registros de la base de datos.
				response.setValue( (registers/registersPerPage) + (registers%registersPerPage == 0 ? 0 : 1) );
			}
			response.setStatusCode("201");
			response.setMessage(String.format("%d pages found", response.getValue()));
			
		} catch (Exception e) {
			log.error("ProductService: getPageCount() error", e);
		}
		
		return response;
	}

}
