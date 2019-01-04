package com.lakazambia.api.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.model.UserProfile;

public interface IUserProfileService {

	boolean createUserProfile(UserProfile c);

	UserProfile getUserProfileById(Long id);

	List<UserProfile> getAllUserProfiles();

	void updateUserProfile(UserProfile c);
	
	void uploadProfile(MultipartFile imageFile, HttpServletRequest request) throws IOException;
}
