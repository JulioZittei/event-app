package com.eventapp.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventapp.domain.model.Event;
import com.eventapp.domain.model.Guest;
import com.eventapp.domain.repository.EventRepository;
import com.eventapp.domain.service.CreateGuestService;

@Controller
@RequestMapping("/")
public class EventController {
	
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private CreateGuestService createGuestService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "redirect:/eventos";
	}
	
	@RequestMapping(value = "/eventos", method = RequestMethod.GET)
	public ModelAndView events() {
		ModelAndView mv = new ModelAndView("index");
		List<Event> events = eventRepository.findAll();
		mv.addObject("events", events);
		return mv;
	}

	@RequestMapping(value = "eventos/cadastro", method = RequestMethod.GET)
	public ModelAndView createEventForm() {
		ModelAndView mv = new ModelAndView("event/pages/formEvent");
		Event event = new Event();
		mv.addObject("event", event);
		return mv;
	}
	
	
	@RequestMapping(value = "eventos/cadastro", method = RequestMethod.POST)
	public String createEvent(@Valid Event event) {
		eventRepository.save(event);
		return "redirect:/eventos/cadastro";
	}
	
	@RequestMapping(value = "eventos/{id}", method = RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("event/pages/eventDetails");
		Event event = eventRepository.findByid(id);
		mv.addObject("event", event);
		return mv;
	}
	
	@RequestMapping(value = "eventos/{id}/convidados/cadastro", method = RequestMethod.POST)
	public String createGuest(@PathVariable("id") Long id, @Valid Guest guest) {
		createGuestService.createGuest(id, guest.getName(), guest.getEmail());
		return "redirect:/eventos/{id}";
	}
	

}
