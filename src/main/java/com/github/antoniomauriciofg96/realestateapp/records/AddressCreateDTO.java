package com.github.antoniomauriciofg96.realestateapp.records;

import com.github.antoniomauriciofg96.realestateapp.model.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressCreateDTO(
		@NotBlank(message = "{error.street.empty}")
		String street, 
		@NotBlank(message = "{error.district.empty}")
		String district, 
		@NotBlank(message = "{error.cep.empty}")
		@Pattern(regexp="\\d{8}")
		String cep, 
		@NotBlank(message = "{error.city.empty}")
		String city,
		@NotBlank(message = "{error.uf.empty}")
		String uf, 
		String complement,
		String number
) {

	public AddressCreateDTO(Address address) {
		this(address.getStreet(), address.getDistrict(), address.getCep(), 
				address.getCity(), address.getUf(), address.getComplement(), address.getNumber());
	}
	

}
