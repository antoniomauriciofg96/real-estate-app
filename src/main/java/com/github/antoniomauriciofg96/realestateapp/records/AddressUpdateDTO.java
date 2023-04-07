package com.github.antoniomauriciofg96.realestateapp.records;

import com.github.antoniomauriciofg96.realestateapp.model.Address;

import jakarta.validation.constraints.Pattern;

public record AddressUpdateDTO(
		String street, 
		String district, 
		@Pattern(regexp="\\d{8}")
		String cep, 
		String city,
		String uf, 
		String complement,
		String number
) {

	public AddressUpdateDTO(Address address) {
		this(address.getStreet(), address.getDistrict(), address.getCep(), 
				address.getCity(), address.getUf(), address.getComplement(), address.getNumber());
	}
	

}
