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
	@NotNull
	private String place;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime time;
	
	@NotNull
	private OffsetDateTime createdAt;
	
	@NotNull
	private OffsetDateTime updatedAt;
	
	
}
