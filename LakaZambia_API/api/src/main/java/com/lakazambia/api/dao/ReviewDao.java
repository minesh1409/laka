package com.lakazambia.api.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lakazambia.api.model.Review;

@Transactional
@Repository
public class ReviewDao implements IReviewDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public void createReview(Review r) {
		// TODO Auto-generated method stub
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		r.setCreated_at(sdf.format(date));
		entitymanager.persist(r);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return entitymanager.createQuery("FROM Review").getResultList();
	}

	@Override
	public void updateReview(Review r) {
		// TODO Auto-generated method stub
		Review review = getReviewById(r.getReview_id());
		review.setReview(r.getReview());
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));
		// u.setCreated_at(sdf.format(date));
		r.setUpdated_at(sdf.format(date));
	}

	@Override
	public Review getReviewById(int ReviewId) {
		// TODO Auto-generated method stub
		return entitymanager.find(Review.class, ReviewId);
	}

}
