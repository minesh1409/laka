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
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.lakazambia.api.model.Advertisement;

import com.lakazambia.api.service.IAdvertisementService;
import com.rethinkdb.RethinkDB;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@PropertySource("classpath:db.properties")
@Api
public class AdvertisementController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdvertisementController.class);
	
	@Value("${rethink.db}")
	public String db;

	@Value("${rethink.schema2}")
	public String tab;
	
	private static final RethinkDB r = RethinkDB.r;
	@Autowired
	private RethinkDBConnectionFactory connectionFactory;
	
	@Autowired
	private IAdvertisementService advertisementService;
	
	@ApiOperation(value="Get All Advertisement Data")
	@GetMapping("/advertisements")
	public ResponseEntity<List<Advertisement>> getAllAdvertisements(HttpServletRequest request) {
		
		List<Advertisement> list = advertisementService.getAllAdvertisements();
		LOGGER.info("GET ADVERTISEMENTS");
		return new ResponseEntity<List<Advertisement>>(list, HttpStatus.OK);
	}
	
	@ApiOperation(value="Post Advertisement Data")
	@PostMapping("/advertisement")
	public ResponseEntity<?> addAdvertisement(@RequestBody Advertisement a, UriComponentsBuilder builder) {
		boolean flag = advertisementService.createAdvertisement(a);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/advertisement/{id}").buildAndExpand(a.getListing_id()).toUri());
		System.out.println("Listing Id :: " +a.getListing_id());
		int li = a.getListing_id();
		String list=String.valueOf(li);
		LOGGER.info("POST ADVERTISEMENTS");
		return new ResponseEntity<String>(list, HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Advertisement Data By ID")
	@GetMapping("advertisement/{id}")
	public ResponseEntity<Advertisement> getAdvertisementById(@PathVariable("id") int id) {
		Advertisement adv=advertisementService.getAdvertisementById(id);
	
		LOGGER.info("Get By ID");
		return new ResponseEntity<Advertisement>(adv, HttpStatus.OK);
	}
	@ApiOperation(value="Update Advertisement Data")
	@PutMapping("updateAdvertisement")
	public ResponseEntity<Advertisement> updateAdvertisement(@RequestBody Advertisement a) {
		advertisementService.updateAdvertisement(a);
		LOGGER.info("LAKA","Update Advertisement Data");
		return new ResponseEntity<Advertisement>(a, HttpStatus.OK);
	}
	
	@DeleteMapping("deleteAdvertise/{id}")
	public ResponseEntity<String> deleteAdvertisement(@PathVariable("id") int id)
	{
		advertisementService.deleteAdvertisement(id);
		LOGGER.info("LAKA","Delete Advertisement Data");
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	//FOR Rethink
	@ApiOperation(value="Get All Advertisement Data using REthink")
	@RequestMapping(value = "/advertisementsdata", method = RequestMethod.GET)
	public ResponseEntity<List<Advertisement>> getUsers() {

		List<Advertisement> add = r.db(db).table(tab)
				// .orderBy().optArg("index", r.desc("time"))
				.limit(50).orderBy("time").run(connectionFactory.createConnection());
		// Object u=null;
		// Cursor cursor =
		// r.db("userData").table("user").run(connectionFactory.createConnection(),
		// User.class);
		// for (Object doc : cursor)
		// System.out.println(doc);
		// u=doc;
		LOGGER.info("Get All Advertisement Data using REthink");
		return new ResponseEntity<List<Advertisement>>(add, HttpStatus.OK);
	}
	

}
