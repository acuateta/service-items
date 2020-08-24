package com.ferreteria.app.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Items{

	private Product product;
	private Integer amount;

	public Double getTotal() {
		return amount.doubleValue() * product.getSalePrice();
	}
	


}
