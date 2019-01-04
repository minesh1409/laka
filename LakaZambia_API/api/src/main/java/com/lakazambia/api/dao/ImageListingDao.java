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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.lakazambia.api.exceptions.ImageCountException;
import com.lakazambia.api.model.ImageListing;

@Transactional
@Repository
public class ImageListingDao implements IImageListingDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImageListingDao.class);

	@Autowired
	private EntityManager entitymanager;

	int count = 0;

	@Override
	public void createImageListing(ImageListing u) {
		// TODO Auto-generated method stub
		entitymanager.persist(u);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ImageListing> getAllImageListings() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM ImageListing").getResultList();
	}

	@Override
	public void updateImageListing(ImageListing u) {
		// TODO Auto-generated method stub
		ImageListing imagelist = getImageListingById(u.getImage_id());
		imagelist.setImage_path(u.getImage_path());
		imagelist.setSort_order(u.getSort_order());
		imagelist.setUpdated_at(u.getUpdated_at());
		entitymanager.flush();
	}

	@Override
	public ImageListing getImageListingById(int ImageListingId) {
		// TODO Auto-generated method stub
		return entitymanager.find(ImageListing.class, ImageListingId);
	}

	@Override
	public void uploadimage(MultipartFile imageFile, HttpServletRequest request) throws IOException {

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
				webAppRoot = "/opt/api";
				String imgname = imageFile.getOriginalFilename();
				LOGGER.info("imag file name :: " + imgname);
				System.out.println("imag file name :: " + imgname);
				String str = imgname;
				String[] arrOfStr = str.split("u", 2);
				String f1 = arrOfStr[0];
				LOGGER.info("imag folder name :: " + f1);
				System.out.println("imag folder name :: " + f1);
				String s1 = arrOfStr[1];
				String[] arrOfStr1 = s1.split("l", 2);
				String f2 = arrOfStr1[0];
				LOGGER.info("imag folder name :: " + f2);
				System.out.println("imag folder name :: " + f2);
				String fname = arrOfStr1[1];
				System.out.println("File Name :: " + fname);

				String dir = webAppRoot + "/resources/images/" + f1 + "/" + f2;
				File f = new File(dir);
				boolean flag = f.mkdirs();
				int fileCount=f.list().length;
				System.out.println("File :: " +fileCount);
				LOGGER.info("Are dirs created (T/F)? " + flag);
				System.out.println("Are dirs created (T/F)? " + flag);

				System.out.println("WebAPPRoot :: " + dir);
				LOGGER.info("WebAPPRoot :: " + dir);
			
				/* Generate :- Random UUID */
				imageUUID = UUID.randomUUID();
				
							if (f.list().length >= 5) {
								
								System.out.println("File Length :: " +f.length());
								throw new ImageCountException("try to send more than 3 image");
							}
							else {

								/* Set New :- Image File */
								profilePictureUrl.delete(0, profilePictureUrl.length()).append(webAppRoot)
										.append(File.separator).append(File.separator).append("resources")
										.append(File.separator).append("images").append(File.separator).append(f1)
										.append(File.separator).append(f2).append(File.separator).append(fname);

								String fileUrl = webAppRoot + "/" + f1 + "/" + f2 + fname;

								/* Set :- Image File */
								outStream = new BufferedOutputStream(
										new FileOutputStream(profilePictureUrl.toString()));
								LOGGER.info(imageFile.getOriginalFilename());
								System.out.println(imageFile.getOriginalFilename());
								/* Write :- Image File */
								outStream.write(bytes);
								outStream.close();
								LOGGER.info("File URL :: " + fileUrl);
								System.out.println("File URL :: " + fileUrl);
								// return fileUrl;
							}
					
				
			} else {
				System.out.println("In Else");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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

	}

	@SuppressWarnings("unchecked")
	public List<ImageListing> findImageEntities(boolean all, int maxResults, int firstResult) {

		try {
			javax.persistence.Query q = entitymanager.createQuery("select object(u) from Advertisement as u");
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			entitymanager.close();
		}
	}

	public List<ImageListing> findImageExampleEntities() {
		return findImageEntities(true, -1, -1);
	}

	public List<ImageListing> findImageEntities(int maxResults, int firstResult) {
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

	public void getString() {
		System.out.println("Files length is more than 3");
	}

}
