package com.lakazambia.api.service;

import java.util.List;

import com.lakazambia.api.model.Review;

public interface IReviewService {
	

	boolean createReview(Review c);

	Review getReviewById(int id);

	List<Review> getAllReviews();

	void updateReview(Review c);


}
