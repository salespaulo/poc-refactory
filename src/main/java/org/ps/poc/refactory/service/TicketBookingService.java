package org.ps.poc.refactory.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.ps.poc.refactory.domain.Pricing;
import org.ps.poc.refactory.domain.TicketBooking;
import org.ps.poc.refactory.repository.PricingRepository;
import org.ps.poc.refactory.repository.TicketBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TicketBookingService {

	private final TicketBookingRepository ticketBookingRepository;
	private final PricingRepository pricingRepository;

	@Autowired
	public TicketBookingService(final TicketBookingRepository ticketBookingRepository, 
			final PricingRepository pricingRepository) {
		this.ticketBookingRepository = ticketBookingRepository;
		this.pricingRepository = pricingRepository;
	}

	public Set<TicketBooking> pricingByIds(final Set<Integer> ids) {
		final List<TicketBooking> tickets = ticketBookingRepository.findAll(ids);

		for (TicketBooking ticket: tickets) {
			Pricing pricing = pricingRepository.findOneByServiceIdAndTicketTypeAndSeatType(ticket.getService().getId(),
					ticket.getType(), ticket.getSeat().getType());
			ticket.setPriceBase(pricing.getPrice().getBase());
			ticket.setPriceToll(pricing.getPrice().getToll());
			ticket.setPriceTax(pricing.getPrice().getTax());
			ticket.setPriceBoardTax(pricing.getPrice().getBoardTax());
			ticket.setPriceInsurance(pricing.getPrice().getInsurance());
			ticket.setPriceOtherTaxes(pricing.getPrice().getOtherTaxes());
			ticket.setPriceDiscount(pricing.getPrice().getDiscount());
		}
		
		return new HashSet<TicketBooking>(tickets);
	}
	
}
