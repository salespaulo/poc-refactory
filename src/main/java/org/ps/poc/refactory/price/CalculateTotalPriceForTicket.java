package org.ps.poc.refactory.price;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class CalculateTotalPriceForTicket {
	
	private final List<BigDecimal> values;
	
	private BigDecimal discount;

	private CalculateTotalPriceForTicket(final List<BigDecimal> values) {
		this.values = values;
	}

	public CalculateTotalPriceForTicket withDiscount(final BigDecimal discount) {
		this.discount = Optional.ofNullable(discount).orElse(BigDecimal.ZERO);
		return this;
	}

	public BigDecimal calculate() {
		return values.stream()
				.reduce(BigDecimal.ZERO, BigDecimal::add)
				.subtract(this.discount);
	}

	public static CalculateTotalPriceForTicket from(final BigDecimal... values) {
		return new CalculateTotalPriceForTicket(
				Arrays.asList(values)
					.stream()
					.map(Optional::ofNullable)
					.filter(Optional::isPresent)
					.map(Optional::get)
					.collect(Collectors.toList()));
	}
	
}
