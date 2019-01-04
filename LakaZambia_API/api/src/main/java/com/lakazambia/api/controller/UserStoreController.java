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


import com.lakazambia.api.model.UserStore;
import com.lakazambia.api.service.IUserStoreService;

@RestController
public class UserStoreController {
	
	@Autowired
	private IUserStoreService userstoreService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoreController.class); 
	
	
	@GetMapping("/usersores")
	// @RequestMapping("hello")
	public ResponseEntity<List<UserStore>> getAllUserStores(HttpServletRequest request) {
		
		List<UserStore> list = userstoreService.getAllUserStores();
		LOGGER.info("get user store");
		return new ResponseEntity<List<UserStore>>(list, HttpStatus.OK);
	}

	@PostMapping("/userstore")
	public ResponseEntity<?> addCountry(@RequestBody UserStore us, UriComponentsBuilder builder) {
		boolean flag = userstoreService.createUserStore(us);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("post user store data");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/userstore/{id}").buildAndExpand(us.getStore_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("userstore/{id}")
	public ResponseEntity<UserStore> getUserStoreById(@PathVariable("id") int id) {
		UserStore us=userstoreService.getUserStoreById(id);
		LOGGER.info("get user store data by id");
		
		return new ResponseEntity<UserStore>(us, HttpStatus.OK);
	}
	
	@PutMapping("updateUserStore")
	public ResponseEntity<UserStore> updateUserStore(@RequestBody UserStore us) {
		userstoreService.updateUserStore(us);
		LOGGER.info("update user store data");
		return new ResponseEntity<UserStore>(us, HttpStatus.OK);
	}


}
