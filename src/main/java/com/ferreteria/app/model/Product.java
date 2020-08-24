package com.ferreteria.app.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class Product implements Serializable {

	private static final long serialVersionUID = -7985041629802747321L;

	private Long id;
	private String code;
	private String name;
	private double purchasePrice;
	private double salePrice;

}
