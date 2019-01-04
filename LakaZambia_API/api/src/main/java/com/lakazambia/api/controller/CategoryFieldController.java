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

import com.lakazambia.api.model.CategoryField;
import com.lakazambia.api.service.ICategoryFieldService;

@RestController
public class CategoryFieldController {

	@Autowired
	private ICategoryFieldService categoryFieldService;

	@GetMapping("/categoryFields")
	// @RequestMapping("hello")
	public ResponseEntity<List<CategoryField>> getAllCategoryFields(HttpServletRequest request) {
		
		List<CategoryField> list = categoryFieldService.getAllCategoryFields();
		return new ResponseEntity<List<CategoryField>>(list, HttpStatus.OK);
	}

	@PostMapping("/categoryfield")
	public ResponseEntity<?> addCategoryField(@RequestBody CategoryField cf, UriComponentsBuilder builder) {
		boolean flag = categoryFieldService.createCategoryField(cf);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/categoryField/{id}").buildAndExpand(cf.getField_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("categoryField/{id}")
	public ResponseEntity<CategoryField> getCategoryFieldById(@PathVariable("id") int id) {
		CategoryField cf=categoryFieldService.getCategoryFieldById(id);
	
		
		return new ResponseEntity<CategoryField>(cf, HttpStatus.OK);
	}
	
	@PutMapping("updateCategoryField")
	public ResponseEntity<CategoryField> updateCategoryField(@RequestBody CategoryField cf) {
			categoryFieldService.updateCategoryField(cf);
		
		return new ResponseEntity<CategoryField>(cf, HttpStatus.OK);
	}

}
