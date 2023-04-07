package com.github.antoniomauriciofg96.realestateapp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.antoniomauriciofg96.realestateapp.model.Property;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyCreateDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyDetailDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyListDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyUpdateDTO;
import com.github.antoniomauriciofg96.realestateapp.service.PropertyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyService service;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid PropertyCreateDTO dto, UriComponentsBuilder uriBuilder) {
		Property property = service.save(dto);
		URI uri = uriBuilder.path("/property/{id}").buildAndExpand(property.getId()).toUri();
		return ResponseEntity.created(uri).body(new PropertyDetailDTO(property));
	}

	@GetMapping
	public ResponseEntity<Page<PropertyListDTO>> findAll(@PageableDefault(size = 10, page = 0, sort = {"updatedAt"}) Pageable page) {
		return ResponseEntity.ok(service.findAll(page));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PropertyDetailDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@PutMapping
	public ResponseEntity<PropertyDetailDTO> update(@RequestBody @Valid PropertyUpdateDTO dto) {
		Property property = service.update(dto);
		return ResponseEntity.ok(new PropertyDetailDTO(property));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
