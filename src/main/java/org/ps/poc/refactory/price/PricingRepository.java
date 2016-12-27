package org.ps.poc.refactory.price;

import java.util.Optional;

import org.ps.poc.refactory.price.domain.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends JpaRepository<Pricing, Integer> {

	Optional<Pricing> findOneByServiceIdAndTicketTypeAndSeatType(Integer serviceId, String ticketType, String seatType);

}
