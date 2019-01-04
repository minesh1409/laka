package com.lakazambia.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.model.Favourites;
import com.lakazambia.api.service.IFavouriteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class FavouritesController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FavouritesController.class);
	
	@Autowired
	private IFavouriteService favouriteService;
	
	@ApiOperation(value="Get All Favourite")
	@GetMapping("/favourites")
	public ResponseEntity<List<Favourites>> getAllFavourites(HttpServletRequest request) {
		
		List<Favourites> list = favouriteService.getAllFavourites();
		LOGGER.info("Get All Favourite");
		return new ResponseEntity<List<Favourites>>(list, HttpStatus.OK);
	}

	@ApiOperation(value="Post Favourite")
	@PostMapping("/favourite")
	public ResponseEntity<?> addFavourite(@RequestBody Favourites fav, UriComponentsBuilder builder) {
		boolean flag = favouriteService.createFavourites(fav);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Favourite");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/favourite/{id}").buildAndExpand(fav.getFavourite_id()).toUri());
		return new ResponseEntity<Integer>(fav.getFavourite_id(), HttpStatus.CREATED);
	}

	@ApiOperation(value="Get Favourite by Id")
	@GetMapping("favourite/{id}")
	public ResponseEntity<Favourites> getFavouritesById(@PathVariable("id") int id) {
		Favourites fav=favouriteService.getFavouritesById(id);
	
		LOGGER.info("Get Favourite by Id");
		return new ResponseEntity<Favourites>(fav, HttpStatus.OK);
	}
	@ApiOperation(value="Update Favourite")
	@PutMapping("updateFavourite")
	public ResponseEntity<Favourites> updateFavourite(@RequestBody Favourites fav) {
		favouriteService.updateFavourites(fav);
		LOGGER.info("Update Favourite");
		return new ResponseEntity<Favourites>(fav, HttpStatus.OK);
	}
	@ApiOperation(value="Delete Favourite")
	@DeleteMapping("deleteFavourite/{id}")
	public ResponseEntity<?> deleteFavourite(@PathVariable("id") int id) {
		favouriteService.deleteFavourites(id);
		LOGGER.info("Delete Favourite");
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}



}
