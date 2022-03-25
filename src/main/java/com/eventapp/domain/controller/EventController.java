package com.eventapp.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EventController {
	

	@RequestMapping("createEvent")
	public String form() {
		return "event/pages/formEvent";
	}

}
