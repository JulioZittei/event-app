package com.eventapp.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventapp.domain.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

	public Optional<Guest> findById(Long id);
}
