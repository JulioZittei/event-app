package com.eventapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventapp.domain.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	public Event findByid(Long id);
}
