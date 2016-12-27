package org.ps.poc.refactory.price.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Table(name="price")
public class Price {

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column
	private BigDecimal base;

	@Column
	private BigDecimal boardTax;

	@Column
	private BigDecimal discount;

	@Column
	private BigDecimal insurance;

	@Column(name="other_taxes")
	private BigDecimal otherTaxes;

	@Column
	private BigDecimal tax;

	@Column
	private BigDecimal toll;
	
}
