package com.lakazambia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lakazambia.api.model.ForeignExchange;
import com.lakazambia.api.service.IForeignExchangeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class ForeignExchangeController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ForeignExchangeController.class);
	
	@Autowired
	private IForeignExchangeService foreignExchangeService;
	
	@ApiOperation(value="Get All exchanges Data")
	@GetMapping("/exchanges")
	// @RequestMapping("hello")
	public ResponseEntity<List<ForeignExchange>> getAllForeignExchages(HttpServletRequest request) {
		
		List<ForeignExchange> list = foreignExchangeService.getExchange();
		LOGGER.info("Get All Country Data");
		return new ResponseEntity<List<ForeignExchange>>(list, HttpStatus.OK);
	}
}
