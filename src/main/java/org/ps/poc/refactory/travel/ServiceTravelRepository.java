package org.ps.poc.refactory.travel;

import org.ps.poc.refactory.travel.domain.ServiceTravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ServiceTravelRepository extends JpaRepository<ServiceTravel, Integer> {

}
