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

import com.lakazambia.api.model.CategoryType;

import com.lakazambia.api.service.ICategoryTypeService;

@RestController
public class CategoryTypeController {
	
	
	@Autowired
	private ICategoryTypeService categoryTypeService;
	
	@GetMapping("/categorytypes")
	// @RequestMapping("hello")
	public ResponseEntity<List<CategoryType>> getAllCategoryTypes(HttpServletRequest request) {
		
		List<CategoryType> list = categoryTypeService.getAllCategoryTypes();
		return new ResponseEntity<List<CategoryType>>(list, HttpStatus.OK);
	}

	@PostMapping("/categoryType")
	public ResponseEntity<?> addCountry(@RequestBody CategoryType ct, UriComponentsBuilder builder) {
		boolean flag = categoryTypeService.createCategoryType(ct);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(ct.getType_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("categoryType/{id}")
	public ResponseEntity<CategoryType> getCategoryTypeById(@PathVariable("id") int id) {
		CategoryType ct=categoryTypeService.getCategoryTypeById(id);
	
		
		return new ResponseEntity<CategoryType>(ct, HttpStatus.OK);
	}
	
	@PutMapping("updateCategoryTpe")
	public ResponseEntity<CategoryType> updateCategoryType(@RequestBody CategoryType ct) {
		categoryTypeService.updateCategoryType(ct);
		
		return new ResponseEntity<CategoryType>(ct, HttpStatus.OK);
	}


}
