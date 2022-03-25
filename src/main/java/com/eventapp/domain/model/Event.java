package com.eventapp.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	private String name;
	
	@NotBlank	
	@NotNull()
	private String place;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime time;
	
	@NotNull
	private OffsetDateTime createdAt = this.getCreatedAt() == null ? OffsetDateTime.now() : this.getCreatedAt();
	
	@NotNull
	private OffsetDateTime updatedAt = OffsetDateTime.now();
	
	
}
