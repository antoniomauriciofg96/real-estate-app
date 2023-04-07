package com.github.antoniomauriciofg96.realestateapp.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.antoniomauriciofg96.realestateapp.constants.TypeProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PropertyCreateDTO(
		@NotBlank(message = "{error.title.empty}")
		String title, 
		@NotNull(message = "{error.availablein.null}")
		LocalDateTime avalilableIn, 
		@NotNull(message = "{error.value.null}")
		BigDecimal value, 
		@NotBlank(message = "{error.description.empty}")
		String description, 
		@NotNull(message = "{error.area.null}")
		Integer area,
		@NotNull(message = "{error.type.null}")
		TypeProperty type, 
		@NotNull(message = "{error.address.null}") @Valid 
		AddressCreateDTO address
) {

}
