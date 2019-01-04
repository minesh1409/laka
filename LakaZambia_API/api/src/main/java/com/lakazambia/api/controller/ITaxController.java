package com.lakazambia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.model.Tax;
import com.lakazambia.api.service.ITaxService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class ITaxController {
	
	@Autowired
	private ITaxService taxService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ITaxController.class);
	
	
	@ApiOperation(value="Get All Taxes")
	@GetMapping("/taxes")
	public ResponseEntity<List<Tax>> getAllTaxes(HttpServletRequest request) {
		
		List<Tax> list=taxService.getAllTaxes();
		LOGGER.info("Get All Taxes");
		return new ResponseEntity<List<Tax>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Taxes")
	@PostMapping("/tax")
	public ResponseEntity<?> addTax(@RequestBody Tax tax, UriComponentsBuilder builder) {
		boolean flag = taxService.createTax(tax);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Taxes");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/tax/{id}").buildAndExpand(tax.getTax_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Taxes By Id")
	@GetMapping("tax/{id}")
	public ResponseEntity<Tax> getTaxById(@PathVariable("id") int id) {
		Tax tax=taxService.getTaxById(id);
	
		LOGGER.info("Get Taxes By Id");
		return new ResponseEntity<Tax>(tax, HttpStatus.OK);
	}
	
	@ApiOperation(value="Update Tax")
	@PutMapping("updateTax")
	public ResponseEntity<Tax> updateTax(@RequestBody Tax t) {
		taxService.updateTax(t);
		LOGGER.info("Update Tax");
		return new ResponseEntity<Tax>(t, HttpStatus.OK);
	}


}
