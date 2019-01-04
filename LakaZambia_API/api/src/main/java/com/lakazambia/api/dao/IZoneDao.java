package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Zone;

public interface IZoneDao {

	
	 void createZone(Zone  u);
	 List<Zone> getAllZones();
	 void updateZone(Zone u);
	 
	Zone getZoneById(int ZoneId);
	 
}
