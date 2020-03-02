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


/**
 * The Class Product.
 */
@Entity

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new product.
 */
@NoArgsConstructor
public class Product {

	/** The id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/** The name. */
	private String name;
	
	/** The current price. */
	private BigDecimal currentPrice;
	
	/** The last updated. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;
	
	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 * @param currentPrice the current price
	 * @param lastUpdated the last updated
	 */
	public Product(String name, BigDecimal currentPrice,Date lastUpdated ){
		this.name=name;
		this.currentPrice=currentPrice;
		this.lastUpdated=lastUpdated;
	}
}
