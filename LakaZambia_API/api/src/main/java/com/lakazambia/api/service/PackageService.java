package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IPackageDao;
import com.lakazambia.api.model.ListingPackage;

@Service
public class PackageService implements IPackageService{
	
	@Autowired
	private IPackageDao packagedao;

	@Override
	public boolean createPackage(ListingPackage p) {
		// TODO Auto-generated method stub
		packagedao.createPackage(p);
		return true;
	}

	@Override
	public ListingPackage getPackageById(int id) {
		// TODO Auto-generated method stub
		
		return packagedao.getPackageById(id);
	}

	@Override
	public List<ListingPackage> getAllPackages() {
		// TODO Auto-generated method stub
		return packagedao.getAllPackages();
	}

	@Override
	public void updatePackage(ListingPackage p) {
		// TODO Auto-generated method stub
		packagedao.updatePackage(p);
	}

}
