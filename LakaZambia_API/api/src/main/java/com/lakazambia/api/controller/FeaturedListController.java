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


import com.lakazambia.api.model.FeaturedList;
import com.lakazambia.api.service.IFeaturedListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class FeaturedListController {

	@Autowired
	private IFeaturedListService featuredListService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeaturedListController.class);
	
	@ApiOperation(value="Get Featured List")
	@GetMapping("/featuredLists")
	// @RequestMapping("hello")
	public ResponseEntity<List<FeaturedList>> getAllfeaturedLists(HttpServletRequest request) {
		
		List<FeaturedList> list = featuredListService.getAllfeaturedLists();
		LOGGER.info("Get Featured List");
		return new ResponseEntity<List<FeaturedList>>(list, HttpStatus.OK);
	}
	@ApiOperation(value="Post Featured List")
	@PostMapping("/FeaturedList")
	public ResponseEntity<?> addFeaturedList(@RequestBody FeaturedList fl, UriComponentsBuilder builder) {
		boolean flag = featuredListService.createfeaturedList(fl);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Featured List");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/featuredlist/{id}").buildAndExpand(fl.getFeatured_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get Featured List by ID")
	@GetMapping("FeaturedList/{id}")
	public ResponseEntity<FeaturedList> getFeaturedListById(@PathVariable("id") int id) {
		FeaturedList list=featuredListService.getfeaturedListById(id);
		LOGGER.info("Get Featured List by ID");
		
		return new ResponseEntity<FeaturedList>(list, HttpStatus.OK);
	}
	@ApiOperation(value="Update Featured List")
	@PutMapping("updateFeaturedList")
	public ResponseEntity<FeaturedList> updateFeaturedList(@RequestBody FeaturedList fl) {
		featuredListService.updatefeaturedList(fl);
		LOGGER.info("Update Featured List");
		return new ResponseEntity<FeaturedList>(fl, HttpStatus.OK);
	}

}
