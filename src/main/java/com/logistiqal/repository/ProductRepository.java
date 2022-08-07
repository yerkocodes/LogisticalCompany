package com.logistiqal.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.logistiqal.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {
	@Query(value = "SELECT * FROM product WHERE name LIKE '%?%'", countQuery = "SELECT COUNT(*) FROM Product WHERE name LIKE '%?%'", nativeQuery = true)
	public Page<Product> findAllByName(String name, Pageable pageable);
}
