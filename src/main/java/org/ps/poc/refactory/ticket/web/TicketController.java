package org.ps.poc.refactory.ticket.web;

import java.util.List;
import java.util.Set;

import org.ps.poc.refactory.ticket.TicketBookingService;
import org.ps.poc.refactory.ticket.domain.TicketBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	/**
	 * Using only interface, low coupling.
	 */
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TicketBooking> findAll() {
		return ticketBookingService.findAll();
	}
	
	@RequestMapping(value="/pricing", method=RequestMethod.GET)
	public Set<TicketBooking> pricing(@RequestParam("ticketIds") Integer[] ticketIds) {
		return ticketBookingService.pricingByIds(ticketIds);
	}
	
}
