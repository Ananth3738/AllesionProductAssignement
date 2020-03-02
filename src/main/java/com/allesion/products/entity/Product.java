package com.allesion.products.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private BigDecimal currentPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;
	
	public Product(String name, BigDecimal currentPrice,Date lastUpdated ){
		this.name=name;
		this.currentPrice=currentPrice;
		this.lastUpdated=lastUpdated;
	}
}
