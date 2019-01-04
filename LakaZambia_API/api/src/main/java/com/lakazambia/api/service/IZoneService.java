package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Zone;

public interface IZoneService {
	
	boolean createZone(Zone c);
	Zone getZoneById(int id);
	List<Zone> getAllZones();
	void updateZone(Zone c);

}
