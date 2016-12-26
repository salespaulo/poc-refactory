package org.ps.poc.refactory.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name="ticket_booking")
public class TicketBooking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="dt_departure", nullable=false)
	private LocalDate departureDate;

	@Column(name="tm_departure", nullable=false)
	private LocalTime departureTime;

	@Column(name="tp_ticket", nullable=false)
	private String type;
	
	@Column(name="price_base", nullable=false)
	private BigDecimal priceBase;

	@Column(name="price_board_tax", nullable=false)
	private BigDecimal priceBoardTax;

	@Column(name="price_discount", nullable=false)
	private BigDecimal priceDiscount;

	@Column(name="price_insurance", nullable=false)
	private BigDecimal priceInsurance;

	@Column(name="price_other_taxes", nullable=false)
	private BigDecimal priceOtherTaxes;

	@Column(name="price_tax", nullable=false)
	private BigDecimal priceTax;

	@Column(name="price_toll", nullable=false)
	private BigDecimal priceToll;

	@ManyToOne
	@JoinColumn(name="seat_id", nullable=false)
	private Seat seat;
	
	//uni-directional many-to-one association to ServiceTravel
	@ManyToOne
	@JoinColumn(name="serv_trav_id", nullable=false)
	private ServiceTravel service;

}
