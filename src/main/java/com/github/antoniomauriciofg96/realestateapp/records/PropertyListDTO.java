package com.github.antoniomauriciofg96.realestateapp.records;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.github.antoniomauriciofg96.realestateapp.constants.TypeProperty;
import com.github.antoniomauriciofg96.realestateapp.model.Property;

public record PropertyListDTO(
		Long id,
		String title, 
		LocalDateTime avalilableIn, 
		BigDecimal value, 
		String description, 
		Integer area,
		TypeProperty type,
		Integer status,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
) {
	
	public PropertyListDTO(Property property) {
        this(property.getId(), property.getTitle(), property.getAvalilableIn(), 
        		property.getValue(), property.getDescription(), 
        		property.getArea(), property.getType(), property.getStatus(), 
        		property.getCreatedAt(), property.getUpdatedAt());
    }

}
