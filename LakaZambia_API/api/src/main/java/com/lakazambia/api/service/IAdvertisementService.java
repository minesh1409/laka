package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Advertisement;

public interface IAdvertisementService {

	boolean createAdvertisement(Advertisement a);

	Advertisement getAdvertisementById(int id);

	List<Advertisement> getAllAdvertisements();

	void updateAdvertisement(Advertisement a);
	
	void deleteAdvertisement(int id);

}
