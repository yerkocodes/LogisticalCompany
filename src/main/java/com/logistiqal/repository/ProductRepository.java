package com.logistiqal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.logistiqal.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

	@Query(value = "SELECT * FROM product WHERE name LIKE '%?%'", countQuery = "SELECT COUNT(*) FROM Product WHERE name LIKE '%?%'", nativeQuery = true)
	public Page<Product> findAllByName(String name, Pageable pageable);
	
	
	@Query("FROM Product WHERE name = :userName AND password = :userPass")
	public List<Product> findByNombreAndClave(@Param("userName") String name, @Param("userPass") String password);
	
	@Query("FROM Product WHERE id_product = :id")
	public Product findByID(@Param("id") Integer id);
}
