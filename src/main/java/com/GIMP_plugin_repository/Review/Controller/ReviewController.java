package com.GIMP_plugin_repository.Review.Controller;


import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
import com.GIMP_plugin_repository.Review.Repository.ReviewRepository;
//import com.GIMP_plugin_repository.Review.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

//    @Autowired
//    private ReviewService reviewService;

    //@PostMapping("/createReview")
//    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto){
////       ReviewDto createdReview = reviewService.createReview(reviewDto);
////       return ResponseEntity.ok(createdReview);
//    }

//    @GetMapping("plugin/{pluginId}/version/{versionId}")
//    public ResponseEntity<List<ReviewDto>> getReviewByPluginIdAndVersionId(@PathVariable Long pluginId, Long pluginVersionId){
//        List<ReviewDto> reviews = reviewService.getReviewByPluginIdAndVersionId(pluginId, pluginVersionId);
//        return ResponseEntity.ok(reviews);
//    }
}
