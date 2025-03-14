package com.GIMP_plugin_repository.Review.Controller;


import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Repository.ReviewRepository;
import com.GIMP_plugin_repository.Review.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/createReview")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto){
       ReviewDto createdReview = reviewService.createReview(reviewDto);
       return ResponseEntity.ok(createdReview);
    }
}
