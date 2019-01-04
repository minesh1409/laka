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

import com.lakazambia.api.model.OrderTransaction;
import com.lakazambia.api.service.IOrderTransactionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Api
public class OrderTransactionController {
	
	@Autowired
	private IOrderTransactionService orderTransactionService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderTransactionController.class);
	
	@ApiOperation(value="Get All Order Transaction")
	@GetMapping("/transactions")
	public ResponseEntity<List<OrderTransaction>> getAllTransactions(HttpServletRequest request) {
		
		List<OrderTransaction> list = orderTransactionService.getAllOrderTransactions();
		LOGGER.info("Get All Order Transaction");
		return new ResponseEntity<List<OrderTransaction>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Order Transaction")
	@PostMapping("/transaction")
	public ResponseEntity<?> addCountry(@RequestBody OrderTransaction ot, UriComponentsBuilder builder) {
		boolean flag = orderTransactionService.createOrderTransaction(ot);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Order Transaction");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/transaction/{id}").buildAndExpand(ot.getTransaction_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get All Order Transaction By Id")
	@GetMapping("transaction/{id}")
	public ResponseEntity<OrderTransaction> getTransactionById(@PathVariable("id") int id) {
		OrderTransaction ot=orderTransactionService.getOrderTransactionById(id);
		LOGGER.info("Get All Order Transaction By Id");
		
		return new ResponseEntity<OrderTransaction>(ot, HttpStatus.OK);
	}
	
	@ApiOperation(value="Update Order Transaction")
	@PutMapping("updateTransaction")
	public ResponseEntity<OrderTransaction> updateTransaction(@RequestBody OrderTransaction ot) {
		orderTransactionService.updateOrderTransaction(ot);
		LOGGER.info("Update Order Transaction");
		return new ResponseEntity<OrderTransaction>(ot, HttpStatus.OK);
	}

}
