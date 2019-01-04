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

import com.lakazambia.api.model.Country;

import com.lakazambia.api.service.ICountryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	private ICountryService countryService;
	
	@ApiOperation(value="Get All Country Data")
	@GetMapping("/countries")
	// @RequestMapping("hello")
	public ResponseEntity<List<Country>> getAllCountries(HttpServletRequest request) {
		
		List<Country> list = countryService.getAllContries();
		LOGGER.info("Get All Country Data");
		return new ResponseEntity<List<Country>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Country Data")
	@PostMapping("/country")
	public ResponseEntity<?> addCountry(@RequestBody Country c, UriComponentsBuilder builder) {
		boolean flag = countryService.createCountry(c);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Country Data");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(c.getCountry_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Country Data By Id")
	@GetMapping("country/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") int id) {
		Country con=countryService.getCountryById(id);
	
		LOGGER.info("Get Country Data By Id");
		return new ResponseEntity<Country>(con, HttpStatus.OK);
	}
	@ApiOperation(value="Update All Country Data")
	@PutMapping("updateCountry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country c) {
		countryService.updateCountry(c);
		LOGGER.info("Update All Country Data");
		return new ResponseEntity<Country>(c, HttpStatus.OK);
	}


}
