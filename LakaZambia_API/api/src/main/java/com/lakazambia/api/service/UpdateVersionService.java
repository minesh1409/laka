package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IUpdateVersion;
import com.lakazambia.api.model.UpdateVersion;

@Service
public class UpdateVersionService implements IUpdateVersionService{

	
	@Autowired
	private IUpdateVersion versionService;
	
	@Override
	public boolean createVersion(UpdateVersion c) {
		// TODO Auto-generated method stub
		versionService.createVersion(c);
		return true;
	}

	@Override
	public UpdateVersion getUpdateVersionById(int id) {
		// TODO Auto-generated method stub
		return versionService.getVersionById(id);
	}

	@Override
	public List<UpdateVersion> getAllUpdateVersions() {
		// TODO Auto-generated method stub
		return versionService.getVersions();
	}

}
