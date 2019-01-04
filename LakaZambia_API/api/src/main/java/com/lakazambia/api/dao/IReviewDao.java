package com.lakazambia.api.dao;

import java.util.List;

import com.lakazambia.api.model.Review;

public interface IReviewDao {
	
	
	void createReview(Review r);

	List<Review> getAllReviews();

	void updateReview(Review r);

	Review getReviewById(int ReviewId);

}
