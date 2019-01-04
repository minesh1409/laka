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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.lakazambia.api.model.UpdateVersion;
import com.lakazambia.api.service.IUpdateVersionService;



@RestController
public class VersionController {

	@Autowired
	private IUpdateVersionService versionService;

	private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class); 
	
	@GetMapping("/versions")
	public ResponseEntity<List<UpdateVersion>> getAllVersions(HttpServletRequest request) {

		List<UpdateVersion> list = versionService.getAllUpdateVersions();
		LOGGER.info("Versions Get");
		return new ResponseEntity<List<UpdateVersion>>(list, HttpStatus.OK);
	}

	
	@PostMapping("/version")
	public ResponseEntity<?> addVersion(@RequestBody UpdateVersion v, UriComponentsBuilder builder) {
		boolean flag = versionService.createVersion(v);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Versions post");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/version/{id}").buildAndExpand(v.getId()).toUri());
		
	
		return new ResponseEntity<UpdateVersion>(v, HttpStatus.CREATED);
	}

	
	@GetMapping("version/{id}")
	public ResponseEntity<UpdateVersion> getUpdateVersionById(@PathVariable("id") int id) {
		UpdateVersion v = versionService.getUpdateVersionById(id);
		LOGGER.info("Versions get by id");
		return new ResponseEntity<UpdateVersion>(v, HttpStatus.OK);
	}

}
