package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Location;

public interface ILocationDao {
	
	
	void createLocation(Location  u);
	 List<Location> getAllLocations();
	 void updateLocation(Location u);
	 Location getLocationById(int LocationId);

}
