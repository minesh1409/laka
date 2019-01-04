package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Location;

public interface ILocationService {
	
	boolean createLocation(Location c);
	Location getLocationById(int id);
	List<Location> getAllLocations();
	void updateLocation(Location c);

}
