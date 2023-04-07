package com.github.antoniomauriciofg96.realestateapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.github.antoniomauriciofg96.realestateapp.constants.TypeProperty;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyCreateDTO;
import com.github.antoniomauriciofg96.realestateapp.records.PropertyUpdateDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "properties")
@Entity(name = "Property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private LocalDateTime avalilableIn;

	private BigDecimal value;

	private String description;

	private Integer area;

	@Enumerated(EnumType.STRING)
	private TypeProperty type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", nullable = false)
	private Address address;

	private Integer status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@CreationTimestamp 
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Property() {
		super();
	}

	public Property(Long id, String title, LocalDateTime avalilableIn, BigDecimal value, String description,
			Integer area, TypeProperty type, Address address, Integer status, User user, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.avalilableIn = avalilableIn;
		this.value = value;
		this.description = description;
		this.area = area;
		this.type = type;
		this.address = address;
		this.status = status;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Property(PropertyCreateDTO dto) {
		super();
		this.title = dto.title();
		this.avalilableIn = dto.avalilableIn();
		this.value = dto.value();
		this.description = dto.description();
		this.area = dto.area();
		this.type = dto.type();
		this.address = new Address(dto.address());
	}

	public void updateByDTO(PropertyUpdateDTO dto) {
		if (dto.title() != null) {
			this.title = dto.title();
		}
		if (dto.avalilableIn() != null) {
			this.avalilableIn = dto.avalilableIn();
		}
		if (dto.value() != null) {
			this.value = dto.value();
		}
		if (dto.description() != null) {
			this.description = dto.description();
		}
		if (dto.area() != null) {
			this.area = dto.area();
		}
		if (dto.type() != null) {
			this.type = dto.type();
		}
		if (dto.address() != null) {
			this.address.updateByDTO(dto.address());
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getAvalilableIn() {
		return avalilableIn;
	}

	public void setAvalilableIn(LocalDateTime avalilableIn) {
		this.avalilableIn = avalilableIn;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public TypeProperty getType() {
		return type;
	}

	public void setType(TypeProperty type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "Property [id=" + id + ", title=" + title + ", avalilableIn=" + avalilableIn + ", value=" + value
				+ ", description=" + description + ", area=" + area + ", type=" + type + ", address=" + address
				+ ", status=" + status + ", user=" + user + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

}
