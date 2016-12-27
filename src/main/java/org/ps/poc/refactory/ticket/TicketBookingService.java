package org.ps.poc.refactory.ticket;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.ps.poc.refactory.ticket.domain.TicketBooking;

/**
 * More visibility to interfaces
 */
public interface TicketBookingService {

	Set<TicketBooking> pricingByIds(final Integer[] ids);

	List<TicketBooking> findAll();

	Optional<TicketBooking> findOne(Integer ticketId);
	
}
