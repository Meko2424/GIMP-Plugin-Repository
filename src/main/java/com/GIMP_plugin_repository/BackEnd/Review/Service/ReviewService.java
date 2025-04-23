//package com.GIMP_plugin_repository.BackEnd.Review.Service;
//
//import com.GIMP_plugin_repository.BackEnd.Plugin.Model.Plugin;
//import com.GIMP_plugin_repository.BackEnd.Plugin.Repository.PluginRepository;
//import com.GIMP_plugin_repository.BackEnd.Review.Dto.ReviewDto;
//import com.GIMP_plugin_repository.BackEnd.Review.Model.Review;
//import com.GIMP_plugin_repository.BackEnd.Review.Repository.ReviewRepository;
//import com.GIMP_plugin_repository.BackEnd.User.Repository.UserRepository;
//import com.GIMP_plugin_repository.BackEnd.Version.Model.PluginVersion;
//import com.GIMP_plugin_repository.BackEnd.Version.Repository.PluginVersionRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
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
//    private PluginRepository pluginRepository;
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
//    public ReviewDto createReview(Long pluginId, Long pluginVersionId, ReviewDto reviewDto) {
//        Plugin plugin = pluginRepository.findById(pluginId).orElseThrow(() -> new RuntimeException("Plugin not found"));
//        // Retrieve plugin version by pluginId and version number
//        PluginVersion pluginVersion = pluginVersionRepository.findByPluginIdAndId(pluginId, pluginVersionId);
//        if (pluginVersion == null) {
//            throw new RuntimeException("PluginVersion not found for given Plugin ID and Version ID");
//        }
//
//        // Create a new Review entity and set values form ReviewDto
//        Review review = modelMapper.map(reviewDto, Review.class);
//
//        //review.setPluginVersion(pluginVersion);
//        review.setRating(reviewDto.getRating());
//        review.setComment(reviewDto.getComment());
//        review.setReviewDate(reviewDto.getReviewDate());
//
//        // Save the review to the database
//        Review savedReview = reviewRepository.save(review);
//
//        //Return the saved Review as ReviewDTO, including pluginId
//        return modelMapper.map(savedReview, ReviewDto.class);
//    }
//
//    public List<ReviewDto> getReviewsByPluginAndVersion(Long pluginId, Long pluginVersionId) {
//        PluginVersion pluginVersion = pluginVersionRepository.findByPluginIdAndId(pluginId, pluginVersionId);
//        List<Review> reviews = reviewRepository.findByPluginVersion(pluginVersion);
//        return reviews.stream().map(review -> modelMapper.map(review, ReviewDto.class))
//                .collect(Collectors.toList());
//    }
//
//
//}
