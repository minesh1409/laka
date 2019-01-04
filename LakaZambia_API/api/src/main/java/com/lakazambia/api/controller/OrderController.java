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


import com.lakazambia.api.model.Order;
import com.lakazambia.api.service.IOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@ApiOperation(value="Get All Orders")
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(HttpServletRequest request) {
		
		List<Order> list = orderService.getAllOrders();
		LOGGER.info("Get All Orders");
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Order")
	@PostMapping("/order")
	public ResponseEntity<?> addOrder(@RequestBody Order o, UriComponentsBuilder builder) {
		boolean flag = orderService.createOrder(o);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Order");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/order/{id}").buildAndExpand(o.getOrder_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Order By Id")
	@GetMapping("order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") int id) {
		Order o=orderService.getOrderById(id);
		LOGGER.info("Get Order By Id");
		
		return new ResponseEntity<Order>(o,HttpStatus.OK);
	}
	
	@ApiOperation(value="Update Order")
	@PutMapping("updateOrder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order o) {
		orderService.updateOrder(o);
		LOGGER.info("Update Order");
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}

}
