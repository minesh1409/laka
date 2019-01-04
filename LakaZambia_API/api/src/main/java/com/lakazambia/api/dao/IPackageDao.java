package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.ListingPackage;

public interface IPackageDao {

	void createPackage(ListingPackage u);

	List<ListingPackage> getAllPackages();

	void updatePackage(ListingPackage u);

	ListingPackage getPackageById(int packageId);

}
