package org.ps.poc.refactory.ticket;

import org.ps.poc.refactory.ticket.domain.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Less visibility with default package
 */
@Repository
interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

}
