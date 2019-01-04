package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IAdvertisementDao;
import com.lakazambia.api.model.Advertisement;

@Service
public class AdvertisementService implements IAdvertisementService{

	@Autowired
	private IAdvertisementDao advertisementdao;
	
	@Override
	public boolean createAdvertisement(Advertisement a) {
		// TODO Auto-generated method stub
		advertisementdao.createAdvertisement(a);;
		return true;
	}

	@Override
	public Advertisement getAdvertisementById(int id) {
		// TODO Auto-generated method stub
		return advertisementdao.getAdvertisementById(id);
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		// TODO Auto-generated method stub
		return advertisementdao.getAllAdvertisements();
	}

	@Override
	public void updateAdvertisement(Advertisement a) {
		// TODO Auto-generated method stub
		advertisementdao.updateAdvertisement(a);
	}

	@Override
	public void deleteAdvertisement(int id) {
		// TODO Auto-generated method stub
		advertisementdao.deleteAdvertisement(id);
	}
	
	
	
	

}
