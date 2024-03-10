package com.rahul.SecondSpringBoot.review;

import java.util.List;

public interface ReviewService {


List<ReviewDto> getAllReviews(Long companyId);

ReviewDto addReview(Long companyId, ReviewDto reviewDto);

ReviewDto getReviewById(Long companyId, Long reviewId);

ReviewDto updateReview(Long companyId, Long reviewId, ReviewDto reviewDto);

void deleteReview(Long companyId, Long ReviewId);
}
