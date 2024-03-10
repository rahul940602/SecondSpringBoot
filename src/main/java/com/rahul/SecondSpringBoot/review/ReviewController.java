package com.rahul.SecondSpringBoot.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/review")
    public ResponseEntity<List<ReviewDto>> getAllReviews(@PathVariable Long companyId){

        return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
    }

    @PostMapping("/review")
    public ResponseEntity<ReviewDto> addReview(@PathVariable Long companyId,
                                               @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.addReview(companyId,reviewDto),HttpStatus.OK);
    }

    @GetMapping("review/{reviewId}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("review/{reviewId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable Long companyId,
                                                  @PathVariable Long reviewId,
                                                  @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.updateReview(companyId,reviewId,reviewDto),HttpStatus.OK);
    }
}
