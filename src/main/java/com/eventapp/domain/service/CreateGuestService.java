package com.eventapp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventapp.domain.model.Event;
import com.eventapp.domain.repository.EventRepository;

@Service
public class CreateGuestService {

	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public void createGuest(Long id, String name, String email) {
		Event event = eventRepository.findByid(id);
		event.addGuest(name, email);
	}
	
	
}
