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


import com.lakazambia.api.model.ListingState;
import com.lakazambia.api.service.IListingStateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class ListingStateController {
	
	
	@Autowired
	private IListingStateService listingStateService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ListingStateController.class);
	
	@ApiOperation(value="Get All Listing States")
	@GetMapping("/listingStates")
	public ResponseEntity<List<ListingState>> getAllListingstates(HttpServletRequest request) {
		
		List<ListingState> list = listingStateService.getAllListingStates();
		LOGGER.info("Get All Listing States");
		return new ResponseEntity<List<ListingState>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Listing States")
	@PostMapping("/listingstate")
	public ResponseEntity<?> addListingState(@RequestBody ListingState ls, UriComponentsBuilder builder) {
		boolean flag =listingStateService.createListingState(ls);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Listing States");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/listingservice/{id}").buildAndExpand(ls.getListing_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Listing State By Id")
	@GetMapping("listingState/{id}")
	public ResponseEntity<ListingState> getListingStateById(@PathVariable("id") int id) {
		ListingState ls=listingStateService.getListingStateById(id);
		LOGGER.info("Get Listing State By Id");
		
		return new ResponseEntity<ListingState>(ls, HttpStatus.OK);
	}
	
	@ApiOperation(value="Update Listing State")
	@PutMapping("updateListingState")
	public ResponseEntity<ListingState> updateListingState(@RequestBody ListingState ls) {
		listingStateService.updateListingState(ls);
		LOGGER.info("Update Listing State");
		return new ResponseEntity<ListingState>(ls, HttpStatus.OK);
	}


}
