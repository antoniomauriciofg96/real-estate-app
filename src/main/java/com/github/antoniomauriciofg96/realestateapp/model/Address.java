package com.github.antoniomauriciofg96.realestateapp.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.antoniomauriciofg96.realestateapp.records.AddressCreateDTO;
import com.github.antoniomauriciofg96.realestateapp.records.AddressUpdateDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "addresses")
@Entity(name = "Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String street;

	private String district;

	private String cep;

	private String city;

	private String uf;

	private String complement;

	private String number;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Address() {
		super();
	}

	public Address(Long id, String street, String district, String cep, String city, String uf, String complement,
			String number, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.street = street;
		this.district = district;
		this.cep = cep;
		this.city = city;
		this.uf = uf;
		this.complement = complement;
		this.number = number;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Address(AddressCreateDTO dto) {
		this.street = dto.street();
		this.district = dto.district();
		this.cep = dto.cep();
		this.city = dto.city();
		this.uf = dto.uf();
		this.complement = dto.complement();
		this.number = dto.number();
	}

	public void updateByDTO(AddressUpdateDTO dto) {
		if (dto.street() != null) {
			this.street = dto.street();
		}
		if (dto.district() != null) {
			this.district = dto.district();
		}
		if (dto.cep() != null) {
			this.cep = dto.cep();
		}
		if (dto.city() != null) {
			this.city = dto.city();
		}
		if (dto.uf() != null) {
			this.uf = dto.uf();
		}
		if (dto.complement() != null) {
			this.complement = dto.complement();
		}
		if (dto.number() != null) {
			this.number = dto.number();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, complement, district, id, number, street, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city)
				&& Objects.equals(complement, other.complement) && Objects.equals(district, other.district)
				&& Objects.equals(id, other.id) && Objects.equals(number, other.number)
				&& Objects.equals(street, other.street) && Objects.equals(uf, other.uf);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", district=" + district + ", cep=" + cep + ", city=" + city
				+ ", uf=" + uf + ", complement=" + complement + ", number=" + number + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
