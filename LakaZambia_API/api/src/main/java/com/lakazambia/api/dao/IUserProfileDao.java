package com.lakazambia.api.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.model.UserProfile;

public interface IUserProfileDao {
	

	void createUserProfile(UserProfile u);

	List<UserProfile> getAllUserProfiles();

	void updateUserProfile(UserProfile u);

	UserProfile getUserProfileById(Long UserProfileId);

	public String uploadProfile(MultipartFile imageFile, HttpServletRequest request) throws IOException;
}
