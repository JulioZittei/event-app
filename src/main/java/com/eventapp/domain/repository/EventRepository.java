package com.eventapp.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.domain.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	public Optional<Event> findById(Long id);
}
