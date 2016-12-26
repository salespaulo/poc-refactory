package org.ps.poc.refactory.repository;

import org.ps.poc.refactory.domain.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Integer> {

	Pricing findOneByServiceIdAndTicketTypeAndSeatType(Integer serviceId, String ticketType, String seatType);

}
