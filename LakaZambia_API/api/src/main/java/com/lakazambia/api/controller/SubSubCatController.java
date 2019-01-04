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

import com.lakazambia.api.model.SubSubCategory;
import com.lakazambia.api.service.ISubSubCAtegory;
import com.rethinkdb.RethinkDB;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@PropertySource("classpath:db.properties")
public class SubSubCatController {
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema4}")
	public String tab;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	@Autowired
	private ISubSubCAtegory subsubcategory;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SubSubCatController.class); 
	
	@ApiOperation(value="Get All Sub Sub Category")
	@GetMapping("/subsubcategories")
	public ResponseEntity<List<SubSubCategory>> getAllSubSubCategories(HttpServletRequest request) {
		
		List<SubSubCategory> list = subsubcategory.getAllSubSubCategories();
		LOGGER.info("Get All Sub Sub Category");
		return new ResponseEntity<List<SubSubCategory>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Sub Sub Category")
	@PostMapping("/SubSubCategory")
	public ResponseEntity<?> addSubSubCategory(@RequestBody SubSubCategory c, UriComponentsBuilder builder) {
		boolean flag = subsubcategory.createSubSubCategory(c);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Sub Sub Category");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subsubcat/{id}").buildAndExpand(c.getSub_subcat_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get Sub Sub Category By ID")
	@GetMapping("subsubcategory/{id}")
	public ResponseEntity<SubSubCategory> getSubSubCategoryById(@PathVariable("id") int id) {
		SubSubCategory con=subsubcategory.getSubSubCategoryById(id);
		LOGGER.info("Get Sub Sub Category By ID");
		
		return new ResponseEntity<SubSubCategory>(con, HttpStatus.OK);
	}
	
	@ApiOperation(value="Get Sub Sub Category by category id")
	@GetMapping("subsubcatByCatId/{id}")
	public ResponseEntity<List<SubSubCategory>> getSubSubCategoryByCatId(@PathVariable("id") int id) {
		
		
		
		List<SubSubCategory> list = subsubcategory.getSubSubCatByCatId(id);
		LOGGER.info("Get Sub Sub Category by category id");
		return new ResponseEntity<List<SubSubCategory>>(list, HttpStatus.OK);
	}
	@ApiOperation(value="Update Sub Sub Category")
	@PutMapping("updateSubSubCategory")
	public ResponseEntity<SubSubCategory> updateSubSubCategory(@RequestBody SubSubCategory c) {
		subsubcategory.updateSubSubCategory(c);
		LOGGER.info("Update Sub Sub Category");
		return new ResponseEntity<SubSubCategory>(c, HttpStatus.OK);
	}
	
	
	//FOR RETHINK
	@ApiOperation(value="Get All Sub Category Using Rethink")
			@RequestMapping(value = "/subsubcategoriesData", method = RequestMethod.GET)
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
				LOGGER.info("Get All Sub Category Using Rethink");
				return new ResponseEntity<List<Category>>(cat, HttpStatus.OK);
			}

}
