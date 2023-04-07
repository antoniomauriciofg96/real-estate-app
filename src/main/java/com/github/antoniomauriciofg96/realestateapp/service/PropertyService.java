package com.github.antoniomauriciofg96.realestateapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.antoniomauriciofg96.realestateapp.model.Property;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyCreateDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyDetailDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyListDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyUpdateDTO;
import com.github.antoniomauriciofg96.realestateapp.repository.PropertyRepository;

import jakarta.validation.Valid;

@Service
public class PropertyService {

	PropertyRepository repository;

	@Autowired
	public PropertyService(PropertyRepository repository) {
		this.repository = repository;
	}
	
	@Transactional
	public Property save(PropertyCreateDTO dto) {
		Property property = new Property(dto);
		return repository.saveAndFlush(property);
	}

	public Page<PropertyListDTO> findAll(Pageable page) {
		return repository.findAll(page).map(PropertyListDTO::new);
	}
	
	public PropertyDetailDTO findById(Long id) {
		Property property = repository.getReferenceById(id);
		return new PropertyDetailDTO(property);
	}

	@Transactional
	public Property update(@Valid PropertyUpdateDTO dto) {
		Property property = repository.getReferenceById(dto.id());
		property.updateByDTO(dto);
		return property;
	}

	@Transactional
	public void delete(Long id) {
		Property property = repository.getReferenceById(id);
		property.setStatus(-1);
	}

}
