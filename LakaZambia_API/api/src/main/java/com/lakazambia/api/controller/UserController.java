package com.lakazambia.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
import com.lakazambia.api.model.User;
import com.lakazambia.api.service.IUserService;
import com.rethinkdb.RethinkDB;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api
@PropertySource("classpath:db.properties")
public class UserController {
	
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema}")
	public String tab;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	
	@Autowired
	private IUserService userservice;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class); 
	
	@ApiOperation(value="Get All Users")
	@GetMapping("/users")
	// @RequestMapping("hello")
	public ResponseEntity<List<User>> getAllUsers(HttpServletRequest request) {
		
		System.out.println("Request ID::"+UUID.randomUUID().toString());
		System.out.println("Requested URL::"+request.getRequestURL());
		List<User> list = userservice.getAllUsers();
		LOGGER.info("Get All Users");
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post User")
	@PostMapping("/user")
	public ResponseEntity<?> addUser(@RequestBody User u, UriComponentsBuilder builder) throws ParseException {
		boolean flag = userservice.createUser(u);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post User");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(u.getUser_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get User By Id")
	@GetMapping("user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {

		User u = userservice.getUserById(id);
		LOGGER.info("Get User By Id");
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@ApiOperation(value="LoginUser")
	@GetMapping("/users/find?email={email}")
	// @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		User u = userservice.getUserByEmail(email);
		LOGGER.info("LoginUser");
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("users/find?mobile={mobile}")
	public ResponseEntity<User> getUserByMobile(@PathVariable("mobile") String mobile) {
		User u = userservice.getUserByMobile(mobile);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	@ApiOperation(value="Update User")
	@PutMapping("updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User u) {
		System.out.println("In Controller");
		userservice.updateUser(u);
		System.out.println("Password Updated.......!!!");
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	@ApiOperation(value="User Login Name Password")
	@RequestMapping(value = "users/{name}/{pswd}", method = RequestMethod.GET)
	public ResponseEntity<?> loginUser(@PathVariable("name") String name, @PathVariable("pswd") String pswd,
			HttpServletRequest request) {
		System.out.println("Requested URL::" + request.getRequestURL());
		User user = userservice.doLogin(name, pswd);
		System.out.println("user::" +user);
		if (user==null) {

			return new ResponseEntity<String>("Failure", HttpStatus.CONFLICT);
		}
		LOGGER.info("User Login Name Password");

		// model.put("name", name);
		// model.put("pswd", pswd);

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	@ApiOperation(value="Get All user data using Rethink")
	@RequestMapping(value = "/usersdata", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {

		List<User> users = r.db(db).table(tab)
				// .orderBy().optArg("index", r.desc("time"))
				.limit(50).orderBy("time").run(connectionFactory.createConnection());
		// Object u=null;
		// Cursor cursor =
		// r.db("userData").table("user").run(connectionFactory.createConnection(),
		// User.class);
		// for (Object doc : cursor)
		// System.out.println(doc);
		// u=doc;
		LOGGER.info("Get All user data using Rethink");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
