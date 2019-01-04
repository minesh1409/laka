package com.lakazambia.api.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.lakazambia.api.model.ImageListing;
import com.lakazambia.api.service.IImageListingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class ImageListController {
	
	@Autowired
	private IImageListingService imageListingService;
	
	@ApiOperation(value="Get All Images data")
	@GetMapping("/images")
	// @RequestMapping("hello")
	public ResponseEntity<List<ImageListing>> getAllImageLists(HttpServletRequest request) {
		
		List<ImageListing> list = imageListingService.getAllImageListings();
		return new ResponseEntity<List<ImageListing>>(list, HttpStatus.OK);
	}
	@ApiOperation(value="Post Image data")
	@PostMapping("/image")
	public ResponseEntity<?> addImageList(@RequestBody ImageListing imageList, UriComponentsBuilder builder) {
		boolean flag = imageListingService.createImageListing(imageList);
		if (flag == false) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/imageList/{id}").buildAndExpand(imageList.getImage_id()).toUri());
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}
	@ApiOperation(value="Get Image data By Id")
	@GetMapping("image/{id}")
	public ResponseEntity<ImageListing> getImageById(@PathVariable("id") int id) {
		ImageListing imageList=imageListingService.getImageListingById(id);
	
		
		return new ResponseEntity<ImageListing>(imageList, HttpStatus.OK);
	}
	@ApiOperation(value="Update Image data")
	@PutMapping("updateImageList")
	public ResponseEntity<ImageListing> updateImageList(@RequestBody ImageListing imageList) {
		imageListingService.updateImageListing(imageList);
		
		return new ResponseEntity<ImageListing>(imageList, HttpStatus.OK);
	}
	@ApiOperation(value="Upload Image data")
	@PostMapping("/upload")
	public ResponseEntity<String> uploaddemo(@RequestParam(value = "advertise", required = true) MultipartFile imageFile, HttpServletRequest request)
			throws IOException {

		imageListingService.uploadAdd(imageFile, request);
		System.out.println("Image Uploaded...");
		return new ResponseEntity<String>("Success", HttpStatus.CREATED);
	}

}
