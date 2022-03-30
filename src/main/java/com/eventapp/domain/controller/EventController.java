package com.eventapp.domain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventapp.domain.model.Event;
import com.eventapp.domain.model.Guest;
import com.eventapp.domain.repository.EventRepository;
import com.eventapp.domain.repository.GuestRepository;
import com.eventapp.domain.service.CreateGuestService;

@Controller
@RequestMapping("/")
public class EventController {
	
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private GuestRepository guestRepository;
	
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
		ModelAndView mv = new ModelAndView("eventos/formEvent");
		Event event = new Event();
		mv.addObject("event", event);
		return mv;
	}
	
	
	@RequestMapping(value = "eventos/cadastro", method = RequestMethod.POST)
	public String createEvent(@Valid Event event, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("error", "Verifique os campos!");
			return "redirect:/eventos/cadastro";
		}
		eventRepository.save(event);
		attributes.addFlashAttribute("success", "Evento Cadastrado com Sucesso!");
		return "redirect:/eventos/cadastro";
	}
	
	@RequestMapping(value = "eventos/{id}", method = RequestMethod.GET)
	public ModelAndView eventDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("eventos/eventDetails");
		Event event = eventRepository.findById(id).orElse(null);
		mv.addObject("event", event);
		return mv;
	}
	
	@RequestMapping(value = "eventos/{id}/convidados/cadastro", method = RequestMethod.POST)
	public String createGuest(@PathVariable("id") Long id, @Valid Guest guest, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("error", "Verifique os campos!");
			return "redirect:/eventos/{id}";
		}
		createGuestService.createGuest(id, guest.getName(), guest.getEmail());
		attributes.addFlashAttribute("success", "Convidado Cadastrado com Sucesso!");
		return "redirect:/eventos/{id}";
	}
	
	
	@RequestMapping(value = "eventos/{id}/remove", method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("id") Long id) {
		Event event = eventRepository.findById(id).orElse(null);
		eventRepository.delete(event);
		return "redirect:/eventos";
	}
	
	@RequestMapping(value = "eventos/{idEvent}/convidados/{idGuest}/remove", method = RequestMethod.GET)
	public String deleteEvent(@PathVariable("idEvent") Long idEvent, @PathVariable("idGuest") Long idGuest) {
		Guest guest = guestRepository.findById(idGuest).orElse(null);
		guestRepository.delete(guest);
		return "redirect:/eventos/{idEvent}";
	}

}
