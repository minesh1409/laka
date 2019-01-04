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

import com.lakazambia.api.model.ListingPackage;

import com.lakazambia.api.service.IPackageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class PackageController {
	
	
	@Autowired
	private IPackageService packageService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PackageController.class);
	
	@ApiOperation(value="Get All Packages")
	@GetMapping("/packages")
	public ResponseEntity<List<ListingPackage>> getAllPackages(HttpServletRequest request) {
		
		List<ListingPackage> list = packageService.getAllPackages();
		LOGGER.info("Get All Packages");
		return new ResponseEntity<List<ListingPackage>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Packages")
	@PostMapping("/package")
	public ResponseEntity<?> addPackage(@RequestBody ListingPackage lp, UriComponentsBuilder builder) {
		boolean flag = packageService.createPackage(lp);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Packages");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(lp.getPackage_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Package By Id")
	@GetMapping("package/{id}")
	public ResponseEntity<ListingPackage> getPackageById(@PathVariable("id") int id) {
		ListingPackage lp=packageService.getPackageById(id);
	
		LOGGER.info("Get Package By Id");
		return new ResponseEntity<ListingPackage>(lp, HttpStatus.OK);
	}
	@ApiOperation(value="Update Package")
	@PutMapping("updatePackage")
	public ResponseEntity<ListingPackage> updatePackage(@RequestBody ListingPackage p) {
		packageService.updatePackage(p);
		LOGGER.info("Update Package");
		return new ResponseEntity<ListingPackage>(p, HttpStatus.OK);
	}


}
