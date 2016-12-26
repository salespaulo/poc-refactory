package org.ps.poc.refactory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id", callSuper = false)
@Entity
@Table(name="pricing")
public class Pricing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(unique=true, nullable=false, length=100)
	private String name;

	@Column(name="tp_ticket", insertable=false, updatable=false, unique=true, nullable=false)
	private String ticketType;

	@Column(name="tp_seat", insertable=false, updatable=false, unique=true, nullable=false)
	private String seatType;

	//bi-directional many-to-one association to ServiceTravel
	@ManyToOne
	@JoinColumn(name="serv_trav_id", nullable=false, insertable=false, updatable=false)
	private ServiceTravel service;

	//uni-directional many-to-one association to Price
	@ManyToOne
	@JoinColumn(name="price_id", nullable=false, insertable=false, updatable=false)
	private Price price;

}
