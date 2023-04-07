package com.github.antoniomauriciofg96.realestateapp.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.antoniomauriciofg96.realestateapp.constants.TypeProperty;

import jakarta.validation.constraints.NotNull;

public record PropertyUpdateDTO(
		@NotNull(message = "{error.id.null}")
		Long id,
		String title, 
		LocalDateTime avalilableIn, 
		BigDecimal value,
		String description, 
		Integer area,
		TypeProperty type, 
		AddressUpdateDTO address
) {

}
