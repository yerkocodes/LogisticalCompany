package com.logistiqal.vo;

import java.util.List;

import com.logistiqal.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductVO extends GenericVO {
	
	private List<Product> productList;

	public ProductVO(List<Product> productList, String message, String statusCode) {
		super(message, statusCode);
		this.productList = productList;
	}

}
