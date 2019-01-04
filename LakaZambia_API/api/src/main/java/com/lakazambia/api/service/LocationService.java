package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.ILocationDao;
import com.lakazambia.api.model.Location;

@Service
public class LocationService implements ILocationService{
	
	
	@Autowired
	private ILocationDao locationDao;

	@Override
	public boolean createLocation(Location c) {
		// TODO Auto-generated method stub
		locationDao.createLocation(c);
		return true;
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		return locationDao.getLocationById(id);
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return locationDao.getAllLocations();
	}

	@Override
	public void updateLocation(Location c) {
		// TODO Auto-generated method stub
		locationDao.updateLocation(c);
	}

}
