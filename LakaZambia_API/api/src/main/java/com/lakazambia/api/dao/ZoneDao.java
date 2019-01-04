package com.lakazambia.api.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Zone;

@Transactional
@Repository
public class ZoneDao implements IZoneDao{

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createZone(Zone u) {
		// TODO Auto-generated method stub
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Zone> getAllZones() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Zone").getResultList();
	}

	@Override
	public void updateZone(Zone u) {
		// TODO Auto-generated method stub
		Zone zone=getZoneById(u.getZone_id());
		zone.setName(u.getName());
		zone.setCode(u.getCode());
		zone.setStatus(u.getStatus());
		zone.setCreated_at(u.getCreated_at());
		zone.setUpdated_at(u.getUpdated_at());
	}

	@Override
	public Zone getZoneById(int ZoneId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Zone.class, ZoneId);
	}

	
}
