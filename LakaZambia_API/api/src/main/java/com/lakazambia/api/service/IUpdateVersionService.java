package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.UpdateVersion;

public interface IUpdateVersionService {

	
	
	
	boolean createVersion(UpdateVersion c);
	UpdateVersion getUpdateVersionById(int id);
	List<UpdateVersion> getAllUpdateVersions();
}
