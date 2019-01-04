package com.lakazambia.api.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.dao.IUserProfileDao;
import com.lakazambia.api.model.UserProfile;

@Service
public class UserProfileService implements IUserProfileService{
	
	
	@Autowired
	private IUserProfileDao userProfileDao;

	@Override
	public boolean createUserProfile(UserProfile c) {
		// TODO Auto-generated method stub
		userProfileDao.createUserProfile(c);
		return true;
	}

	@Override
	public UserProfile getUserProfileById(Long id) {
		// TODO Auto-generated method stub
		return userProfileDao.getUserProfileById(id);
	}

	@Override
	public List<UserProfile> getAllUserProfiles() {
		// TODO Auto-generated method stub
		return userProfileDao.getAllUserProfiles();
	}

	@Override
	public void updateUserProfile(UserProfile c) {
		// TODO Auto-generated method stub
		userProfileDao.updateUserProfile(c);
	}

	@Override
	public void uploadProfile(MultipartFile imageFile, HttpServletRequest request) throws IOException {
		// TODO Auto-generated method stub
		userProfileDao.uploadProfile(imageFile, request);
	}

}
