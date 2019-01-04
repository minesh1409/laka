package com.lakazambia.api.controller;


import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.connection.RethinkDBConnectionFactory;
import com.lakazambia.api.model.Customer;

import com.lakazambia.api.service.ICustomerService;
import com.rethinkdb.RethinkDB;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class CustomerController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	 
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema}")
	public String tab;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	
	@Autowired
	private ICustomerService customerService;

	@ApiOperation(value="Get All Customers Data", position = 1)
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(HttpServletRequest request) {
		
		System.out.println("Request ID::"+UUID.randomUUID().toString());
		System.out.println("Requested URL::"+request.getRequestURL());
		List<Customer> list = customerService.getAllCustomers();
		LOGGER.info("Get All Customers Data", "LAKA");
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Customer", position = 2)
	@PostMapping("/customer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer u, UriComponentsBuilder builder) throws ParseException {
		boolean flag = customerService.createCustomer(u);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Customer");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(u.getUser_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Customer By Id")
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getUserById(@PathVariable("id") Long id) {

		Customer c=customerService.getCustomerById(id);
		LOGGER.info("Get Customer By Id");
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}

	@ApiOperation(value="Update Customer")
	@PutMapping("updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) {
		System.out.println("In Controller");
		customerService.updateCustomer(c);
		System.out.println("Password Updated.......!!!");
		LOGGER.info("updateCustomer");
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@ApiOperation(value="Login Url")
	@RequestMapping(value = "customers/{name}/{pswd}", method = RequestMethod.GET)
	public ResponseEntity<?> loginC(@PathVariable("name") String name, @PathVariable("pswd") String pswd,
			HttpServletRequest request) {
		System.out.println("Requested URL::" + request.getRequestURL());
		Customer customer = customerService.doLogin(name, pswd);
		System.out.println("customer ::" +customer);
		if (customer==null) {

			return new ResponseEntity<String>("Failure", HttpStatus.CONFLICT);
		}
		

		// model.put("name", name);
		// model.put("pswd", pswd);
		LOGGER.info("Login Url called");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}
	@ApiOperation(value="Get Customer Data using Rethink")
	@RequestMapping(value = "/customersdata", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getcustomers() {

		List<Customer> customers = r.db(db).table(tab)
				// .orderBy().optArg("index", r.desc("time"))
				.limit(50).orderBy("time").run(connectionFactory.createConnection());
		// Object u=null;
		// Cursor cursor =
		// r.db("userData").table("user").run(connectionFactory.createConnection(),
		// User.class);
		// for (Object doc : cursor)
		// System.out.println(doc);
		// u=doc;
		LOGGER.info("Get Customer Data using Rethink");
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	@ApiOperation(value="Update Status")
	@PutMapping("updateStatus")
	public ResponseEntity<Customer> updateStatus(@RequestBody Customer c) {
		System.out.println("In Controller");
		customerService.updateStatus(c);
		System.out.println("Status Updated.......!!!");
		LOGGER.info("Status Updated.......!!!");
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}	

}
