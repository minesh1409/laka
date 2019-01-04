package com.lakazambia.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lakazambia.api.dao.IReviewDao;
import com.lakazambia.api.model.Review;

@Service
public class ReviewService implements IReviewService{
	
	
	@Autowired
	private IReviewDao reviewDao;

	@Override
	public boolean createReview(Review c) {
		// TODO Auto-generated method stub
		reviewDao.createReview(c);
		return true;
	}

	@Override
	public Review getReviewById(int id) {
		// TODO Auto-generated method stub
		return reviewDao.getReviewById(id);
	}

	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return reviewDao.getAllReviews();
	}

	@Override
	public void updateReview(Review c) {
		// TODO Auto-generated method stub
		reviewDao.updateReview(c);
	}

}
