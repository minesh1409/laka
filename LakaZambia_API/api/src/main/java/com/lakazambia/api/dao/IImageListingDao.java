package com.lakazambia.api.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.model.ImageListing;

public interface IImageListingDao {
	
	
	void createImageListing(ImageListing u);

	List<ImageListing> getAllImageListings();

	void updateImageListing(ImageListing u);

	ImageListing getImageListingById(int ImageListingId);
	
	void uploadimage(MultipartFile imageFile, HttpServletRequest request) throws IOException;

}
