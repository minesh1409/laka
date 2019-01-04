package com.lakazambia.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/swagger")
public class RootController {

	
	
	@RequestMapping(method = RequestMethod.GET)
	public String swaggerUi() {
		return "redirect:/swagger-ui.html";
	}
}
