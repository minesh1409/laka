package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.UpdateVersion;

public interface IUpdateVersion {
	
	public void createVersion(UpdateVersion v);
	
	public List<UpdateVersion> getVersions();
	
	public UpdateVersion getVersionById(int id);
	
//	public String getVersionName();
	

}
