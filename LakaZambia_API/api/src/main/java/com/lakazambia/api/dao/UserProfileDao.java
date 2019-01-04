package com.lakazambia.api.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.model.Customer;

import com.lakazambia.api.model.UserProfile;

@Transactional
@Repository
public class UserProfileDao implements IUserProfileDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void createUserProfile(UserProfile u) {
		// TODO Auto-generated method stub

		entityManager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserProfile> getAllUserProfiles() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM UserProfile").getResultList();
	}

	@Override
	public void updateUserProfile(UserProfile u) {
		// TODO Auto-generated method stub
		UserProfile up = getUserProfileById(u.getUser_id());
		up.setFname(u.getFname());
		up.setLname(u.getLname());
		up.setOccupation(u.getOccupation());
		up.setAbout(u.getAbout());
		up.setWebsiteUrl(u.getWebsiteUrl());
		up.setAvatar(u.getAvatar());

		entityManager.flush();
	}

	@Override
	public UserProfile getUserProfileById(Long userProfileId) {
		// TODO Auto-generated method stub
		return entityManager.find(UserProfile.class, userProfileId);
	}

	@Override
	public String uploadProfile(MultipartFile imageFile, HttpServletRequest request) throws IOException {
		String fileUrl = null;
		@SuppressWarnings("unused")
		UUID imageUUID = null;
		byte[] bytes = null;
		System.out.println("Called.....");
		BufferedOutputStream outStream = null;
        
		String webAppRoot = null;
		StringBuilder profilePictureUrl = null;
		try {
			profilePictureUrl = new StringBuilder();

			if (!imageFile.isEmpty()) {
				/* Convert :- MultipartFile to Bytes */
				bytes = imageFile.getBytes();

				/* Set :- AbsolutePath */
				//webAppRoot = new File(request.getSession().getServletContext().getRealPath("/")).getAbsolutePath();
				webAppRoot="/opt/api";
				System.out.println("WebAPPRoot :: "+webAppRoot);
				
				String dir=webAppRoot + "/resources/profiles/";
				File f=new File(dir);
				boolean flag = f.mkdirs();
			
				System.out.println("Are dirs created (T/F)? "+flag);
				/* Generate :- Random UUID */
				imageUUID = UUID.randomUUID();
				//webAppRoot="D:\\Scoan\\api\\src\\main\\webapp\\resources\\images\\imgURL";
				/* Set New :- Image File */
				profilePictureUrl.delete(0, profilePictureUrl.length()).append(webAppRoot).append(File.separator)
					.append("resources").append(File.separator).append("profiles")
					.append(File.separator).append(imageFile.getOriginalFilename());

				
				/* Set :- Image File */
				fileUrl=webAppRoot + imageFile.getOriginalFilename();
				outStream = new BufferedOutputStream(new FileOutputStream(profilePictureUrl.toString()));
				System.out.println(imageFile.getOriginalFilename());
				/* Write :- Image File */
				outStream.write(bytes);
				outStream.close();
				System.out.println("File URL :: " +fileUrl);
			//	return fileUrl;

			} else {
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			if (bytes != null) {
				bytes = null;
			}
			if (outStream != null) {
				outStream = null;
			}
			if (profilePictureUrl != null) {
				profilePictureUrl.delete(0, profilePictureUrl.length());
				profilePictureUrl = null;
			}
			webAppRoot = null;
			
		}
		return fileUrl;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findImageEntities(boolean all, int maxResults, int firstResult) {

		try {
			javax.persistence.Query q = entityManager.createQuery("select object(u) from Customer as u");
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			entityManager.close();
		}
	}

	public List<Customer> findImageExampleEntities() {
		return findImageEntities(true, -1, -1);
	}

	public List<Customer> findImageEntities(int maxResults, int firstResult) {
		return findImageEntities(false, maxResults, firstResult);
	}

	public void writeFile(File file, byte[] data) throws IOException {

		OutputStream fo = new FileOutputStream(file);
		// Write the data
		fo.write(data);

		fo.flush();
		// Close the door to keep the smell in.
		fo.close();
	}

}
