package com.lakazambia.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.model.Review;

import com.lakazambia.api.service.IReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class ReviewController {
	
	
	@Autowired
	private IReviewService reviewService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewController.class);
	
	@ApiOperation(value="Get All Reviews")
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(HttpServletRequest request) {
	
		System.out.println("Request ID::"+UUID.randomUUID().toString());
		System.out.println("Requested URL::"+request.getRequestURL());
		List<Review> list = reviewService.getAllReviews();
		LOGGER.info("Get All Reviews");
		return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
	}
	@ApiOperation(value="Post Review")
	@PostMapping("/review")
	public ResponseEntity<?> addReview(@RequestBody Review review, UriComponentsBuilder builder) throws ParseException {
		boolean flag = reviewService.createReview(review);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("Post Review");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/review/{id}").buildAndExpand(review.getReview_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get Review By Id")
	@GetMapping("review/{id}")
	public ResponseEntity<Review> getReviewById(@PathVariable("id") int id) {

		Review review=reviewService.getReviewById(id);
		LOGGER.info("Get Review By Id");
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

	@ApiOperation(value="Update Review")
	@PutMapping("updateReview")
	public ResponseEntity<Review> updateReview(@RequestBody Review review) {
		reviewService.updateReview(review);
		System.out.println("Password Updated.......!!!");
		LOGGER.info("Update Review");
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}

}
