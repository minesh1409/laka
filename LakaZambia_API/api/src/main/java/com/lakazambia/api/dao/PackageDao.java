package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.ListingPackage;


@Transactional
@Repository
public class PackageDao implements IPackageDao{

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createPackage(ListingPackage u) {
		// TODO Auto-generated method stub
		
		
		entitymanager.persist(u);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ListingPackage> getAllPackages() {
		// TODO Auto-generated method stub
		String hql="FROM ListingPackage";
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public void updatePackage(ListingPackage u) {
		// TODO Auto-generated method stub
		
		ListingPackage pkg=getPackageById(u.getPackage_id());
		pkg.setTitle(u.getTitle());
		pkg.setPrice(u.getPrice());
		pkg.setListing_days(u.getListing_days());
		pkg.setPromo_days(u.getPromo_days());
		pkg.setPromo_show_featured_area(u.getPromo_show_featured_area());
		pkg.setPromo_show_at_top(u.getPromo_show_at_top());
		pkg.setPromo_sign(u.getPromo_sign());
		pkg.setRecommended_sign(u.getRecommended_sign());
		pkg.setAuto_renewal(u.getAuto_renewal());
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			System.out.println(sdf.format(date));
			//u.setCreated_at(sdf.format(date));
		//pkg.setUpdated_at(sdf.format(date));;
	
		
	}

	@Override
	public ListingPackage getPackageById(int packageId) {
		// TODO Auto-generated method stub
		return entitymanager.find(ListingPackage.class, packageId);
	}
}
