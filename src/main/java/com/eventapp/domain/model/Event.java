package com.eventapp.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull
	private LocalTime time;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	private List<Guest> guests = new ArrayList<>();
	
	@NotNull
	@Column(updatable = false)
	private OffsetDateTime createdAt = OffsetDateTime.now();
	
	@NotNull
	@Column(updatable = true)
	private OffsetDateTime updatedAt = OffsetDateTime.now();
	
	public void addGuest(String name, String email) {
		Guest guest = new Guest();
		guest.setEvent(this);
		guest.setName(name);
		guest.setEmail(email);
		getGuests().add(guest);
	}
	
	
}
