package org.ps.poc.refactory.price;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class CalculateTotalPriceForTicket {
	
	private final List<BigDecimal> values;
	
	private BigDecimal discount;

	private CalculateTotalPriceForTicket(final List<BigDecimal> values) {
		this.values = values;
	}

	public BigDecimal calculate() {
		return values.stream()
				.map(Optional::ofNullable)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.subtract(this.discount);
	}

	public static CalculateTotalPriceForTicket from(final BigDecimal... values) {
		return new CalculateTotalPriceForTicket(Arrays.asList(values));
	}
	
	public CalculateTotalPriceForTicket withDiscount(final BigDecimal discount) {
		this.discount = discount;
		return this;
	}

}
