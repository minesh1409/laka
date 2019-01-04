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

import com.lakazambia.api.model.Currency;
import com.lakazambia.api.service.ICurrencyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class CurrencyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyController.class);
	
	@Autowired
	private ICurrencyService currencyService;
	
	@ApiOperation(value="Get all Currencies")
	@GetMapping("/currencies")
	public ResponseEntity<List<Currency>> getAllCurrencies(HttpServletRequest request) {
		System.out.println("Currencies");
		List<Currency> list = currencyService.getAllCurrencies();
		System.out.println(list);
		LOGGER.info("Get all Currencies");
		return new ResponseEntity<List<Currency>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Currencies")
	@PostMapping("/currency")
	public ResponseEntity<?> addCurrency(@RequestBody Currency c, UriComponentsBuilder builder) {
		boolean flag = currencyService.createCurrency(c);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Currencies");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/currency/{id}").buildAndExpand(c.getCurrency_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Get Currency By Id")
	@GetMapping("currency/{id}")
	public ResponseEntity<Currency> getCurrencyById(@PathVariable("id") int id) {
		Currency cor=currencyService.getCurrencyById(id);
		LOGGER.info("Get Currency By Id");
		
		return new ResponseEntity<Currency>(cor, HttpStatus.OK);
	}
	@ApiOperation(value="Update Currency")
	@PutMapping("updateCurrency")
	public ResponseEntity<Currency> updateCurrency(@RequestBody Currency c) {
		currencyService.updateCurrency(c);
		LOGGER.info("Update Currency");
		return new ResponseEntity<Currency>(c, HttpStatus.OK);
	}


}
