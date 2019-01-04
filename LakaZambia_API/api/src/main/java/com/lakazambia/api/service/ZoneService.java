package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IZoneDao;
import com.lakazambia.api.model.Zone;

@Service
public class ZoneService implements IZoneService{
	
	
	@Autowired
	private IZoneDao zonedao;

	@Override
	public boolean createZone(Zone c) {
		// TODO Auto-generated method stub
		zonedao.createZone(c);
		return true;
	}

	@Override
	public Zone getZoneById(int id) {
		// TODO Auto-generated method stub
		return zonedao.getZoneById(id);
	}

	@Override
	public List<Zone> getAllZones() {
		// TODO Auto-generated method stub
		return zonedao.getAllZones();
	}

	@Override
	public void updateZone(Zone c) {
		// TODO Auto-generated method stub
		zonedao.updateZone(c);
	}

}
