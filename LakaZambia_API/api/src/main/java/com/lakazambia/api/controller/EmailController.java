package com.lakazambia.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.model.Email;

import com.lakazambia.api.service.IEmailService;

@RestController
public class EmailController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private IEmailService emailService;
	
	@GetMapping("/supports")
	// @RequestMapping("hello")
	public ResponseEntity<List<Email>> getAllEmails(HttpServletRequest request) {
		
		System.out.println("Request ID::"+UUID.randomUUID().toString());
		System.out.println("Requested URL::"+request.getRequestURL());
		List<Email> list = emailService.getAllEmails();
		LOGGER.info("GET supports");
		return new ResponseEntity<List<Email>>(list, HttpStatus.OK);
	}

	@PostMapping("/support")
	public ResponseEntity<?> addemail(@RequestBody Email e, UriComponentsBuilder builder) throws ParseException {
		boolean flag = emailService.createEmail(e);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post support");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/email/{id}").buildAndExpand(e.getId()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	/*@GetMapping("/supports")
	// @RequestMapping("hello")
	public ResponseEntity<String> sendEmails(HttpServletRequest request) {
		
		System.out.println("Request ID::"+UUID.randomUUID().toString());
		System.out.println("Requested URL::"+request.getRequestURL());
		emailService.sendMail(toEmail, subject, message);
		LOGGER.info("GET supports");
		return new ResponseEntity<String>("Email Send", HttpStatus.OK);
	}*/

	
	
	

}
