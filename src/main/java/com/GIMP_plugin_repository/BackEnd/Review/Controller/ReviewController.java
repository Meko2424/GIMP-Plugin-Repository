//package com.GIMP_plugin_repository.BackEnd.Review.Controller;
//
//
//import com.GIMP_plugin_repository.BackEnd.Review.Dto.ReviewDto;
//import com.GIMP_plugin_repository.BackEnd.Review.Service.ReviewService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/reviews")
//public class ReviewController {
//
//    @Autowired
//    private ReviewService reviewService;
//
//    // create/Add review by Plugin and Version
//    @PostMapping("/{pluginId}/versions/{pluginVersionId}/reviews")
//    public ResponseEntity<ReviewDto> createReview(@PathVariable Long pluginId,
//                                                  @PathVariable Long pluginVersionId,
//                                                  @RequestBody ReviewDto reviewDto) {
//
//        ReviewDto createdReview = reviewService.createReview(pluginId, pluginVersionId, reviewDto);
//        return ResponseEntity.ok(createdReview);
//    }
//
//     // Get reviews by PluginId and PluginVersionId
//    @GetMapping("/{pluginId}/versions/{pluginVersionId}/reviews")
//    public ResponseEntity<List<ReviewDto>> getReviewsByPluginAndVersion(@PathVariable Long pluginId, @PathVariable Long pluginVersionId) {
//        List<ReviewDto> reviews = reviewService.getReviewsByPluginAndVersion(pluginId, pluginVersionId);
//        return ResponseEntity.ok(reviews);
//    }
//}
