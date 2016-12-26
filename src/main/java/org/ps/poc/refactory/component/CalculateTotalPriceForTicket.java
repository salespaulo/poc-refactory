package org.ps.poc.refactory.component;

import java.math.BigDecimal;

import org.ps.poc.refactory.domain.TicketBooking;
import org.springframework.stereotype.Component;

@Component
public class CalculateTotalPriceForTicket {
	
	public BigDecimal calculate(TicketBooking ticket) {
		BigDecimal base = ticket.getPriceBase();
		BigDecimal toll = ticket.getPriceToll() == null ? BigDecimal.ZERO : ticket.getPriceToll();
		BigDecimal tax = ticket.getPriceTax() == null ? BigDecimal.ZERO : ticket.getPriceTax();
		BigDecimal boardTax = ticket.getPriceBoardTax() == null ? BigDecimal.ZERO : ticket.getPriceBoardTax();
		BigDecimal insurance = ticket.getPriceInsurance() == null ? BigDecimal.ZERO : ticket.getPriceInsurance();
		BigDecimal otherTaxes = ticket.getPriceOtherTaxes() == null ? BigDecimal.ZERO : ticket.getPriceOtherTaxes();
		BigDecimal discount = ticket.getPriceDiscount() == null ? BigDecimal.ZERO : ticket.getPriceDiscount();
		
		return base.add(toll).add(tax).add(boardTax).add(insurance).add(otherTaxes).subtract(discount);
	}

}
