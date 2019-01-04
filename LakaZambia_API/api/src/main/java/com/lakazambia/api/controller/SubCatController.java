package com.lakazambia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.connection.RethinkDBConnectionFactory;
import com.lakazambia.api.model.Category;
import com.lakazambia.api.model.SubCategory;
import com.lakazambia.api.service.ISubCatService;
import com.rethinkdb.RethinkDB;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@PropertySource("classpath:db.properties")
public class SubCatController {
	
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema3}")
	public String tab;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	@Autowired
	private ISubCatService subcatservice;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubCatController.class); 
	
	@ApiOperation(value="Get All Sub Category")
	@GetMapping("/SubCategories")
	public ResponseEntity<List<SubCategory>> getAllSubCategories(HttpServletRequest request) {
		
		List<SubCategory> list = subcatservice.getAllSubCategories();
		LOGGER.info("Get All Sub Category");
		return new ResponseEntity<List<SubCategory>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Sub Category")
	@PostMapping("/subCategory")
	public ResponseEntity<?> addSubCategory(@RequestBody SubCategory c, UriComponentsBuilder builder) {
		boolean flag = subcatservice.createSubCategory(c);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Sub Category");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(c.getSubcat_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Sub Category by id")
	@GetMapping("subCategory/{id}")
	public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable("id") int id) {
		SubCategory sc=subcatservice.getSubCategoryById(id);
	
		LOGGER.info("Get Sub Category by id");
		return new ResponseEntity<SubCategory>(sc, HttpStatus.OK);
	}
	@ApiOperation(value="Update Sub Category")
	@PutMapping("updateSubCategory")
	public ResponseEntity<SubCategory> updateCountry(@RequestBody SubCategory c) {
		subcatservice.updateSubCategory(c);
		LOGGER.info("Update Sub Category");
		return new ResponseEntity<SubCategory>(c, HttpStatus.OK);
	}
	
	
	//FOR RETHINK
	@ApiOperation(value="Get All Sub Category Data using Rethink")
		@RequestMapping(value = "/subcategoriesData", method = RequestMethod.GET)
		public ResponseEntity<List<Category>> getUsers() {

			List<Category> cat = r.db(db).table(tab)
					// .orderBy().optArg("index", r.desc("time"))
					.limit(50).orderBy("time").run(connectionFactory.createConnection());
			// Object u=null;
			// Cursor cursor =
			// r.db("userData").table("user").run(connectionFactory.createConnection(),
			// User.class);
			// for (Object doc : cursor)
			// System.out.println(doc);
			// u=doc;
			LOGGER.info("Get All Sub Category Data using Rethink");
			return new ResponseEntity<List<Category>>(cat, HttpStatus.OK);
		}

}
