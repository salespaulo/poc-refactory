package org.ps.poc.refactory.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.ps.poc.refactory.component.CalculateTotalPriceForTicket;
import org.ps.poc.refactory.domain.TicketBooking;
import org.ps.poc.refactory.repository.TicketBookingRepository;
import org.ps.poc.refactory.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketBookingRepository ticketBookingRepository;
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@Autowired
	private CalculateTotalPriceForTicket calculateTotalPriceForTicket;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TicketBooking> findAll() {
		return ticketBookingRepository.findAll();
	}
	
	@RequestMapping(value="/pricing", method=RequestMethod.GET)
	public Set<TicketBooking> pricing(@RequestParam("ticketIds") Integer[] ticketIds) {
		Set<Integer> setTicketIds = new HashSet<Integer>(Arrays.asList(ticketIds));
		Set<TicketBooking> tickets = ticketBookingService.pricingByIds(setTicketIds);
		return tickets;
	}
	
	@RequestMapping(value="/total", method=RequestMethod.GET)
	public TicketBookingTotal total(@RequestParam("ticketId") Integer ticketId) {
		TicketBooking ticket = ticketBookingRepository.findOne(ticketId);
		BigDecimal calculate = calculateTotalPriceForTicket.calculate(ticket);
		TicketBookingTotal total = new TicketBookingTotal();
		total.setTicket(ticket);
		total.setTotal(calculate);
		return total;
	}

	@RequestMapping(value="/type/grouping", method=RequestMethod.GET)
	public Map<String, List<TicketBooking>> groupingByType() {
		List<TicketBooking> tickets = ticketBookingRepository.findAll();
		Map<String, List<TicketBooking>> grouped = new HashMap<String, List<TicketBooking>>();
		
		for (TicketBooking ticket : tickets) {
			if (! grouped.containsKey(ticket.getType())) {
				grouped.put(ticket.getType(), new ArrayList<TicketBooking>());
				grouped.get(ticket.getType()).add(ticket);
			} else {
				grouped.get(ticket.getType()).add(ticket);
			}
		}
		
		return grouped;
	}

}
