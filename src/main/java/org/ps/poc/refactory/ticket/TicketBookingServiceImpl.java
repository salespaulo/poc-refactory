package org.ps.poc.refactory.ticket;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.ps.poc.refactory.price.PricingRepository;
import org.ps.poc.refactory.price.domain.Price;
import org.ps.poc.refactory.price.domain.Pricing;
import org.ps.poc.refactory.ticket.domain.TicketBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Less visibility to implementation.
 */
@Service
@Transactional
class TicketBookingServiceImpl implements TicketBookingService {

	private final TicketBookingRepository ticketBookingRepository;
	private final PricingRepository pricingRepository;

	@Override
	public List<TicketBooking> findAll() {
		return ticketBookingRepository.findAll();
	}

	@Override
	public Optional<TicketBooking> findOne(Integer ticketId) {
		return Optional.ofNullable(ticketBookingRepository.findOne(ticketId));
	}

	@Autowired
	public TicketBookingServiceImpl(final TicketBookingRepository ticketBookingRepository, 
			final PricingRepository pricingRepository) {
		this.ticketBookingRepository = ticketBookingRepository;
		this.pricingRepository = pricingRepository;
	}

	public Set<TicketBooking> pricingByIds(final Integer[] ids) {
		return ticketBookingRepository.findAll(Arrays.asList(ids))
				.stream()
				.map(t -> t.setPrice(findPriceBy(t)))
				.collect(Collectors.toSet());
	}

	private Price findPriceBy(final TicketBooking ticket) {
		final Integer travelId = ticket.getService().getId();
		final String ticketType = ticket.getType();
		final String seatType = ticket.getSeat().getType();

		return pricingRepository.findOneByServiceIdAndTicketTypeAndSeatType(travelId, ticketType, seatType)
				.map(Pricing::getPrice)
				.orElseThrow(newTicketPricingNotFound(ticket));
	}

	private Supplier<? extends RuntimeException> newTicketPricingNotFound(final TicketBooking ticket) {
		return () -> new RuntimeException("Ticket pricing not found: " + ticket.toString());
	}

}
