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


import com.lakazambia.api.model.Zone;
import com.lakazambia.api.service.IZoneService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class ZoneController {
	
	
	@Autowired
	private IZoneService zoneservice;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZoneController.class); 
	
	@ApiOperation(value="Get All Zones")
	@GetMapping("/zones")
	public ResponseEntity<List<Zone>> getAllZones(HttpServletRequest request) {
		
		List<Zone> list = zoneservice.getAllZones();
		LOGGER.info("Get All Zones");
		return new ResponseEntity<List<Zone>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Zone")
	@PostMapping("/zone")
	public ResponseEntity<?> addZone(@RequestBody Zone z, UriComponentsBuilder builder) {
		boolean flag = zoneservice.createZone(z);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Zone");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(z.getZone_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get Zone By Id")
	@GetMapping("zone/{id}")
	public ResponseEntity<Zone> getZoneById(@PathVariable("id") int id) {
		Zone z=zoneservice.getZoneById(id);
	
		LOGGER.info("Get Zone By Id");
		return new ResponseEntity<Zone>(z, HttpStatus.OK);
	}
	@ApiOperation(value="Update Zone")
	@PutMapping("updateZone")
	public ResponseEntity<Zone> updateZone(@RequestBody Zone z) {
		zoneservice.updateZone(z);
		LOGGER.info("Update Zone");
		return new ResponseEntity<Zone>(z, HttpStatus.OK);
	}

}
