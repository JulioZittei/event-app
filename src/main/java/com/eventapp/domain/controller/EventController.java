package com.eventapp.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventapp.domain.model.Event;
import com.eventapp.domain.repository.EventRepository;

@Controller
@RequestMapping("/")
public class EventController {
	
	
	@Autowired
	private EventRepository eventRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("index");
		List<Event> events = eventRepository.findAll();
		mv.addObject("events", events);
		return mv;
	}

	@RequestMapping(value = "createEvent", method = RequestMethod.GET)
	public String createEventForm() {
		return "event/pages/formEvent";
	}
	
	
	@RequestMapping(value = "createEvent", method = RequestMethod.POST)
	public String createEvent(@Valid Event event) {
		eventRepository.save(event);
		return "redirect:/createEvent";
	}
	
	

}
