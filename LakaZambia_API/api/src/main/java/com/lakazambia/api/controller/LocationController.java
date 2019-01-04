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


import com.lakazambia.api.model.Location;
import com.lakazambia.api.service.ILocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class LocationController {
	
	
	@Autowired
	private ILocationService locationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LocationController.class);
	
	
	@ApiOperation(value="Get All Locations")
	@GetMapping("/Locations")
	public ResponseEntity<List<Location>> getAllLocations(HttpServletRequest request) {
		
		List<Location> list = locationService.getAllLocations();
		LOGGER.info("Get All Locations");
		return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Location")
	@PostMapping("/Location")
	public ResponseEntity<?> addLocation(@RequestBody Location l, UriComponentsBuilder builder) {
		boolean flag = locationService.createLocation(l);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Location");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(l.getLocation_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get Location By Id")
	@GetMapping("location/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable("id") int id) {
		Location loc=locationService.getLocationById(id);
		LOGGER.info("Get Location By Id");
		
		return new ResponseEntity<Location>(loc, HttpStatus.OK);
	}
	@ApiOperation(value="Update Location")
	@PutMapping("updateLocation")
	public ResponseEntity<Location> updateLocation(@RequestBody Location l) {
		locationService.updateLocation(l);
		LOGGER.info("Update Location");
		return new ResponseEntity<Location>(l, HttpStatus.OK);
	}


}
