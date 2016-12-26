package org.ps.poc.refactory.repository;

import org.ps.poc.refactory.domain.TicketBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {

}
