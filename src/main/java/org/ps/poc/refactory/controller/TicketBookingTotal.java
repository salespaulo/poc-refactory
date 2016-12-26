package org.ps.poc.refactory.controller;

import java.math.BigDecimal;

import org.ps.poc.refactory.domain.TicketBooking;

import lombok.Data;

@Data
public class TicketBookingTotal {

	private TicketBooking ticket;
	
	private BigDecimal total;

}
