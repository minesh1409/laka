package com.lakazambia.api.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;


import com.lakazambia.api.model.UserProfile;
import com.lakazambia.api.service.IUserProfileService;

@RestController
public class UserProfileController {
	
	
	@Autowired
	private IUserProfileService userProfileService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileController.class); 
	
	@GetMapping("/userprofiles")
	// @RequestMapping("hello")
	public ResponseEntity<List<UserProfile>> getAllUserProfiles(HttpServletRequest request) {
		
		List<UserProfile> list = userProfileService.getAllUserProfiles();
		LOGGER.info("User Profile get");
		return new ResponseEntity<List<UserProfile>>(list, HttpStatus.OK);
	}

	@PostMapping("/userprofile")
	public ResponseEntity<?> addUserProfile(@RequestBody UserProfile up, UriComponentsBuilder builder) {
		boolean flag = userProfileService.createUserProfile(up);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		LOGGER.info("User Profile post");
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/userprofile/{id}").buildAndExpand(up.getUser_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

	@GetMapping("userprofile/{id}")
	public ResponseEntity<UserProfile> getUserProfileById(@PathVariable("id") Long id) {
		UserProfile up=userProfileService.getUserProfileById(id);
		LOGGER.info("User Profile get by id");
		
		return new ResponseEntity<UserProfile>(up, HttpStatus.OK);
	}
	
	@PutMapping("updateUserProfile")
	public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile up) {
		userProfileService.updateUserProfile(up);
		LOGGER.info("update User Profile");
		return new ResponseEntity<UserProfile>(up, HttpStatus.OK);
	}
	
	@PostMapping("/uploadProfile")
	public ResponseEntity<String> uploaddemo(@RequestParam(value = "Profilepic", required = true) MultipartFile imageFile, HttpServletRequest request)
			throws IOException {
		userProfileService.uploadProfile(imageFile, request);
		System.out.println("Image Uploaded...");
		LOGGER.info("Image Uploaded...");
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}


}
