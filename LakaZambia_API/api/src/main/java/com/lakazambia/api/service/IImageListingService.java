package com.lakazambia.api.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.model.ImageListing;

public interface IImageListingService {
	

	boolean createImageListing(ImageListing c);

	ImageListing getImageListingById(int id);

	List<ImageListing> getAllImageListings();

	void updateImageListing(ImageListing c);
	
	void uploadAdd(MultipartFile imageFile, HttpServletRequest request) throws IOException;
}
