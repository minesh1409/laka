package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.ListingPackage;



public interface IPackageService {
	
	boolean createPackage(ListingPackage p);
	ListingPackage getPackageById(int id);
	List<ListingPackage> getAllPackages();
	void updatePackage(ListingPackage p);
	

}
