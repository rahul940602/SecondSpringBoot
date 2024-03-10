package com.rahul.SecondSpringBoot.review.impl;

import com.rahul.SecondSpringBoot.company.*;
import com.rahul.SecondSpringBoot.company.ResourceNotFound;
import com.rahul.SecondSpringBoot.review.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;

    private final CompanyService companyService;
    private final ModelMapper model;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyRepository companyRepository,CompanyService companyService, ModelMapper model) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
        this.companyService = companyService;
        this.model = model;
    }


    @Override
    public List<ReviewDto> getAllReviews(Long companyId) {

        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews.stream().map((review)->model.map(review, ReviewDto.class)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto addReview(Long companyId, ReviewDto reviewDto) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(()->new ResourceNotFound("company","id",companyId));



        reviewDto.setCompany(company);
        Review review = model.map(reviewDto,Review.class);

        Review savedReview = reviewRepository.save(review);
        return model.map(savedReview, ReviewDto.class);

    }

    @Override
    public ReviewDto getReviewById(Long companyId, Long reviewId) {

        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

         Review getReview =reviews.stream()
                .filter((review) -> review.getId().equals(reviewId))
                .findFirst()
                .orElseThrow(()-> new ResourceNotFound("review","id",reviewId));




        ReviewDto reviewDto = model.map(getReview, ReviewDto.class);

        return reviewDto;



    }

    @Override
    public ReviewDto updateReview(Long companyId, Long reviewId, ReviewDto reviewDto) {
        // Find reviews by companyId

        return null;
    }


}
