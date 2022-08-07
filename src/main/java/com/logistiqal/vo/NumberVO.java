package com.logistiqal.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class NumberVO extends GenericVO {
	private Long value;

	public NumberVO(Long value, String message, String statusCode) {
		super(message, statusCode);
		this.value = value;
	}
	
}
