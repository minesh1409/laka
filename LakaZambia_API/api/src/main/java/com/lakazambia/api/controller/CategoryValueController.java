package com.lakazambia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.lakazambia.api.model.CategoryFieldValue;

import com.lakazambia.api.service.ICategoryValueService;

@RestController
public class CategoryValueController {
	
	@Autowired
	private ICategoryValueService categoryValueService;
	
	@GetMapping("/categoryValues")
	// @RequestMapping("hello")
	public ResponseEntity<List<CategoryFieldValue>> getAllCategoryFieldValues(HttpServletRequest request) {
		
		List<CategoryFieldValue> list = categoryValueService.getAllContries();
		return new ResponseEntity<List<CategoryFieldValue>>(list, HttpStatus.OK);
	}

	@PostMapping("/categoryValue")
	public ResponseEntity<?> addCategoryValue(@RequestBody CategoryFieldValue cfv, UriComponentsBuilder builder) {
		boolean flag = categoryValueService.createCategoryFieldValue(cfv);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/categoryValue/{id}").buildAndExpand(cfv.getValue_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("categoryValue/{id}")
	public ResponseEntity<CategoryFieldValue> getCategoryFieldValueById(@PathVariable("id") int id) {
		CategoryFieldValue cfv= categoryValueService.getCategoryFieldValueById(id);
	
		
		return new ResponseEntity<CategoryFieldValue>(cfv, HttpStatus.OK);
	}
	
	@PutMapping("updateCategoryValue")
	public ResponseEntity<CategoryFieldValue> updateCategoryValue(@RequestBody CategoryFieldValue cfv) {
		categoryValueService.updateCategoryFieldValue(cfv);
		
		return new ResponseEntity<CategoryFieldValue>(cfv, HttpStatus.OK);
	}



}
