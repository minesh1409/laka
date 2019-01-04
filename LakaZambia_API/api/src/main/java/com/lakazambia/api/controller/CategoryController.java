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

import com.lakazambia.api.service.ICategoryService;
import com.rethinkdb.RethinkDB;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@PropertySource("classpath:db.properties")
public class CategoryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema1}")
	public String tab;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	
	@Autowired
	private ICategoryService categoryService;
	
	@ApiOperation(value="Get All Categories Data")
	@GetMapping("/categories")
	// @RequestMapping("hello")
	public ResponseEntity<List<Category>> getAllCategories(HttpServletRequest request) {
		
		List<Category> list = categoryService.getAllCategories();
		LOGGER.info("Get All Categories Data");
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Advertisement Data")
	@PostMapping("/category")
	public ResponseEntity<?> addCategory(@RequestBody Category c, UriComponentsBuilder builder) {
		boolean flag = categoryService.createCategory(c);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Advertisement Data");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/category/{id}").buildAndExpand(c.getCategory_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get All Advertisement Data by Id")
	@GetMapping("category/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
		Category cat=categoryService.getCategoryById(id);
		LOGGER.info("Get All Advertisement Data by Id");
		
		return new ResponseEntity<Category>(cat, HttpStatus.OK);
	}
	@ApiOperation(value="Update Advertisement Data")
	@PutMapping("updateCategory")
	public ResponseEntity<Category> updateCategory(@RequestBody Category c) {
		categoryService.updateCategory(c);
		LOGGER.info("Update Advertisement Data");
		return new ResponseEntity<Category>(c, HttpStatus.OK);
	}

	//FOR RETHINK
	@ApiOperation(value="Get All Advertisement Data using Rethink")
	@RequestMapping(value = "/categoriesData", method = RequestMethod.GET)
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
		LOGGER.info("Get All Advertisement Data using Rethink");
		return new ResponseEntity<List<Category>>(cat, HttpStatus.OK);
	}

}
