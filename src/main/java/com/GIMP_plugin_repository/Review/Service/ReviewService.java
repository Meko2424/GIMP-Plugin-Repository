//package com.GIMP_plugin_repository.Review.Service;
//
//import com.GIMP_plugin_repository.Plugin.Model.Plugin;
//import com.GIMP_plugin_repository.Plugin.Repository.PluginRepository;
//import com.GIMP_plugin_repository.Review.Dto.ReviewDto;
//import com.GIMP_plugin_repository.Review.Model.Review;
//import com.GIMP_plugin_repository.Review.Repository.ReviewRepository;
//import com.GIMP_plugin_repository.User.Model.User;
//import com.GIMP_plugin_repository.User.Repository.UserRepository;
//import com.GIMP_plugin_repository.Version.Model.PluginVersion;
//import com.GIMP_plugin_repository.Version.Repository.PluginVersionRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ReviewService {
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @Autowired
//    private  PluginRepository pluginRepository;
//
//    @Autowired
//    private PluginVersionRepository pluginVersionRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    public ReviewDto createReview( ReviewDto reviewDto){
////
//        PluginVersion pluginVersion = pluginVersionRepository.findById(reviewDto.getPluginVersion().getId())
//                .orElseThrow(() -> new RuntimeException("Version not found"));
//
//        Review review = modelMapper.map(reviewDto, Review.class);
//        review.setPluginVersion(pluginVersion);
//        review.setRating(reviewDto.getRating());
//        review.setComment(reviewDto.getComment());
//        review.setReviewDate(reviewDto.getReviewDate());
//
//        // Save the review to the repository
//        Review savedReview = reviewRepository.save(review);
//
//        //Return the saved Review as DTO, including pluginId
//        ReviewDto savedReviewDto = modelMapper.map(savedReview, ReviewDto.class);
//        return modelMapper.map(savedReview, ReviewDto.class);
//
//
//    }
//
//    //===========================================================
////    public ReviewDto createReview(ReviewDto reviewDto){
//////        Review review = modelMapper.map(reviewDto, Review.class);
////        User user = userRepository.findById(reviewDto.getUser().getId())
////                .orElseThrow(() -> new RuntimeException("User not found"));
//////                .orElseGet(() -> {
//////                    User newUser = new User();
//////                    newUser.setId(reviewDto.getId());
//////                    return userRepository.save(newUser);
//////                });
////        PluginVersion pluginVersion = pluginVersionRepository.findById(reviewDto.getPluginVersion().getId())
////                .orElseThrow(() -> new RuntimeException("Version not found"));
////
//////        Plugin plugin = pluginRepository.findById(reviewDto.getPluginVersion().getPlugin().getId())
//////                .orElseThrow(() -> new RuntimeException("PluginVersion or Plugin not found"));
////
////        // Retrieve the Plugin associated with the PluginVersion
////        Long pluginId = pluginRepository.findById(reviewDto.getPluginVersion().getPlugin().getId())
////                .orElseThrow(() -> new RuntimeException("PluginVersion or Plugin not found")).getId();
////
////        Review review = modelMapper.map(reviewDto, Review.class);
////
////        review.setUser(user);
////        review.setPluginVersion(pluginVersion);
////
//////        review.setReviewDate(LocalDateTime.now());
////
////        // Save the review to the repository
////        Review savedReview = reviewRepository.save(review);
////
////        //Return the saved Review as DTO, including pluginId
////        ReviewDto savedReviewDto = modelMapper.map(savedReview, ReviewDto.class);
//////        return modelMapper.map(savedReview, ReviewDto.class);
////        savedReviewDto.setPluginId(pluginId);
////        return savedReviewDto;
////    }
//
//    //=========================================================
//
////    public List<ReviewDto> getReviewByPluginIdAndVersionId(Long pluginId, Long pluginVersionId){
////
////
////        // Find all reviews associated with the given plugin and version and assign review
////        List<Review> reviews = reviewRepository.findByPluginIdAndVersionId(pluginId, pluginVersionId);
////            return reviews.stream().map(review -> modelMapper.map(review, ReviewDto.class))
////                    .collect(Collectors.toList());
////
////    }
//}
