package org.ps.poc.refactory.ticket.domain;

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

import org.ps.poc.refactory.price.CalculateTotalPriceForTicket;
import org.ps.poc.refactory.price.domain.Price;
import org.ps.poc.refactory.travel.domain.Seat;
import org.ps.poc.refactory.travel.domain.ServiceTravel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

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
	
	@Getter
	@Column(name="price_base", nullable=false)
	private BigDecimal priceBase;

	@Getter
	@Column(name="price_board_tax")
	private BigDecimal priceBoardTax;

	@Getter
	@Column(name="price_discount")
	private BigDecimal priceDiscount;

	@Getter
	@Column(name="price_insurance")
	private BigDecimal priceInsurance;

	@Getter
	@Column(name="price_other_taxes")
	private BigDecimal priceOtherTaxes;

	@Getter
	@Column(name="price_tax")
	private BigDecimal priceTax;

	@Getter
	@Column(name="price_toll")
	private BigDecimal priceToll;

	@ManyToOne
	@JoinColumn(name="seat_id", nullable=false)
	private Seat seat;
	
	//uni-directional many-to-one association to ServiceTravel
	@ManyToOne
	@JoinColumn(name="serv_trav_id", nullable=false)
	private ServiceTravel service;

	public BigDecimal getPriceTotal() {
		return CalculateTotalPriceForTicket.from(
				this.priceBase, 
				this.priceToll, 
				this.priceTax, 
				this.priceBoardTax,
				this.priceInsurance, 
				this.priceOtherTaxes)
				.withDiscount(this.priceDiscount)
				.calculate();
	}
	
	public TicketBooking setPrice(final Price price) {
		this.setPriceBase(price.getBase());
		this.setPriceToll(price.getToll());
		this.setPriceTax(price.getTax());
		this.setPriceBoardTax(price.getBoardTax());
		this.setPriceInsurance(price.getInsurance());
		this.setPriceOtherTaxes(price.getOtherTaxes());
		this.setPriceDiscount(price.getDiscount());
		return this;
	}
}
