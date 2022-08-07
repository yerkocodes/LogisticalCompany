package com.logistiqal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@SequenceGenerator(name = "SQ_PRODUCT", initialValue = 1, allocationSize = 1, sequenceName = "SQ_PRODUCTO") // ORACLE
public class Product {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUCT") // ORACLE JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // MYSQL JPA
	private Long idProduct;
	
	@Column(unique = true, nullable = false)
	private String code;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private Integer price;

	@Column(nullable = false)
	private Integer stock;
}
