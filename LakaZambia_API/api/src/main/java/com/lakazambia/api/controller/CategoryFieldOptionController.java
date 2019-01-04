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

import com.lakazambia.api.model.CategoryFieldOption;

import com.lakazambia.api.service.ICategoryFieldOptionService;

@RestController
public class CategoryFieldOptionController {
	
	
	@Autowired
	private ICategoryFieldOptionService categoryFieldoptionService;
	

	@GetMapping("/categoryOptions")
	// @RequestMapping("hello")
	public ResponseEntity<List<CategoryFieldOption>> getAllCategoryOptions(HttpServletRequest request) {
		
		List<CategoryFieldOption> list = categoryFieldoptionService.getAllCategoryFieldOptions();
		return new ResponseEntity<List<CategoryFieldOption>>(list, HttpStatus.OK);
	}

	@PostMapping("/categoryOption")
	public ResponseEntity<?> addCategoryOption(@RequestBody CategoryFieldOption cfo, UriComponentsBuilder builder) {
		boolean flag = categoryFieldoptionService.createCategoryFieldOption(cfo);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/categoryOption/{id}").buildAndExpand(cfo.getOption_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("categoryOption/{id}")
	public ResponseEntity<CategoryFieldOption> getcategoryOptionById(@PathVariable("id") int id) {
		CategoryFieldOption con=categoryFieldoptionService.getCategoryFieldOptionById(id);
	
		
		return new ResponseEntity<CategoryFieldOption>(con, HttpStatus.OK);
	}
	
	@PutMapping("updateCategoryOption")
	public ResponseEntity<CategoryFieldOption> updateCategoryOption(@RequestBody CategoryFieldOption cfo) {
		categoryFieldoptionService.updateCategoryFieldOption(cfo);
		
		return new ResponseEntity<CategoryFieldOption>(cfo, HttpStatus.OK);
	}


}
