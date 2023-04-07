package com.github.antoniomauriciofg96.realestateapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.antoniomauriciofg96.realestateapp.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{
	
	@Query("select obj from #{#entityName} obj where obj.id = ?1")
	Optional<Property> findById(Long id);
	
	@Query("select obj from #{#entityName} obj where obj.status <> -1 ")
	List<Property> findAllByActiveStatuses(Pageable pageable);

}
