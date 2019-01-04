package com.lakazambia.api.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.dao.IImageListingDao;
import com.lakazambia.api.model.ImageListing;

@Service
public class ImageListingService implements IImageListingService{
	
	@Autowired
	private IImageListingDao imageListingDao;

	@Override
	public boolean createImageListing(ImageListing c) {
		// TODO Auto-generated method stub
		imageListingDao.createImageListing(c);
		return true;
	}

	@Override
	public ImageListing getImageListingById(int id) {
		// TODO Auto-generated method stub
		return imageListingDao.getImageListingById(id);
	}

	@Override
	public List<ImageListing> getAllImageListings() {
		// TODO Auto-generated method stub
		return imageListingDao.getAllImageListings();
	}

	@Override
	public void updateImageListing(ImageListing c) {
		// TODO Auto-generated method stub
		imageListingDao.updateImageListing(c);
	}

	@Override
	public void uploadAdd(MultipartFile imageFile, HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub
		imageListingDao.uploadimage(imageFile, request);
	}

}
