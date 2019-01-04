package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Location;

@Transactional
@Repository
public class LocationDao implements ILocationDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createLocation(Location u) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		u.setCreated_at(sdf.format(date));
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Location").getResultList();
	}

	@Override
	public void updateLocation(Location u) {
		// TODO Auto-generated method stub
		Location l = getLocationById(u.getLocation_id());
		l.setCity(u.getCity());
		l.setZip(u.getZip());
		l.setLatitude(u.getLatitude());
		l.setLongitude(u.getLongitude());
		l.setRetries(u.getRetries());
		l.setStatus(u.getStatus());
		l.setCreated_at(u.getCreated_at());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		u.setUpdated_at(sdf.format(date));
		entitymanager.flush();
	}

	@Override
	public Location getLocationById(int LocationId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Location.class, LocationId);
	}

}
