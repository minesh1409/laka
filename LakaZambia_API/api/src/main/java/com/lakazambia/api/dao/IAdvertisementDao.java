package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Advertisement;


public interface IAdvertisementDao {

	void createAdvertisement(Advertisement u);

	List<Advertisement> getAllAdvertisements();

	void updateAdvertisement(Advertisement u);

	Advertisement getAdvertisementById(int advertisementId);
	
	public void deleteAdvertisement(int id);


	// FOR RETHINK

	List<Advertisement> findAll();

	List<Advertisement> getAdvertisementByID(int ad_id);

}
